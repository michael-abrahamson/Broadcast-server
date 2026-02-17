import java.net.Socket;
import java.util.Scanner;
/**
 * This class is only ran by the client and is responsible for handling all client associated items such as messaging/broadcasting + receiving messages from the server.
 */
public class Client {
    private final String SERVER_ADDRESS = "localhost";
    private final int PORT = 5050;

    private String username;

    private final Scanner scanner = new Scanner(System.in);

    public Client() {
        this.username = "DefaultUser";
        System.out.println("Client is starting...");

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            System.out.println("Client is connected to server at: " + SERVER_ADDRESS + ":" + PORT);
            
            setUsername(username);
            
            while (true) { 
                
            }
        } catch (Exception e) {
            System.out.println("Error in client: " + e.getMessage());
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
    }
}
