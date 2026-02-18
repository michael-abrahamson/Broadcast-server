
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class is only ran by the client and is responsible for handling all
 * client associated items such as messaging/broadcasting + receiving messages
 * from the server.
 */
public final class Client {

    private final String SERVER_ADDRESS = "localhost";
    private final int PORT = 5050;

    private String username;

    private final Scanner scanner = new Scanner(System.in);
    private BufferedReader in;
    private PrintWriter out;

    public void start() {
        this.username = "DefaultUser";
        System.out.println("Client is starting...");

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            System.out.println("Client is connected to server at: " + SERVER_ADDRESS + ":" + PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            setUsername(username);
            out.println("USERNAME: " + username); // send server your username

            

            System.out.println("\n Type in terminal to send messages to the server. Type 'EXIT' to exit the client.\n");
            
            // server listening thread
            new Thread(this::listenForMessages).start();

            while (true) {

                createMessage();
                if (socket.isClosed()) {
                    closeClient();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error in client: " + e.getMessage());
            closeClient();
        }
    }

    public void setUsername(String username) {

        System.out.println("\nYour current username is: " + this.username);

        System.out.print("Would you like to change your username? (y/n): ");

        String input = scanner.nextLine();
        if (input.equals("n")) {
            return;
        }
        System.out.print("Enter your new username: ");
        username = scanner.next();

        this.username = username;
        System.out.println("\nYour username has been updated to: " + this.username);
        scanner.nextLine(); // consume the newline character left by next()
    }

    /**
     * listen for messages from the server and print them out
     */
    public final void listenForMessages() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                if (message.startsWith(username + ": ")) {
                    System.out.println("Message sent by this client: " + message);
                    continue; // skip messages sent by this client
                }
                System.out.println(message);
            }
        } catch (Exception e) {
            System.out.println("Error in listen for messages: " + e.getMessage());
        }
    }

    /**
     * create a message and send it to the server
     */
    public final void createMessage() {
        String message = scanner.nextLine();
        if (message.equals("EXIT")) {
            System.out.println("Exiting client...");
            closeClient();
        }
        out.println(username + ": " + message);
    }

    /**
     * Gracefully terminate the client and close all resources
     */
    public final void closeClient() {
        try {
            if (!in.equals(null)) {
                in.close();
            }
            if (!out.equals(null)) {
                out.close();
            }
            if (!scanner.equals(null)) {
                scanner.close();
            }
            System.exit(0);

        } catch (Exception e) {
            System.out.println("Error closing client: " + e.getMessage());
        } finally {
            System.exit(0); // executes regardless of whether an exception is thrown or not, ensuring the client is terminated
        }
    }
}
