
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class handles all server associated items and calls the ClientHandler class for messaging/broadcasting + receiving messages from clients.
 */
public class Server {
    private final int PORT = 5050;
    private final static List<ClientHandler> clients = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            
            while (true) { 
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                // parallelize client handlers
                new Thread(clientHandler).start(); // socket listener

                listenToServer(); // keyboard listener
                
                // Method to check if users are still connected to the server

            }
        } catch (Exception e) {
            System.out.println("Error in server: " + e.getMessage());
        }

        
    }

    public static synchronized void broadcastMessage(String message) {
        
        System.out.println("Broadcasting message: " + message);
        clients.forEach(client -> client.broadcastClientMessage(message));

    }

    public synchronized void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    private void closeServer() {
        // close server socket
    }

    private void displayUsers() {
        System.out.println("\nCurrently connected users:");

        clients.forEach(client -> System.out.println(client.getUsername()));
    }

    private void listenToServer() {
        while (true) { 
            String input = scanner.nextLine();
            if (input.equals("USERS")) {
                displayUsers();
            }

            if (input.equals("TEST")) {
                broadcastMessage("This is a test message from the server.");
            }
        }
    }


}
