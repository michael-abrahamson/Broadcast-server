
import java.net.*;

/**
 * This class handles all server associated items and calls the ClientHandler class for messaging/broadcasting + receiving messages from clients.
 */
public class Server {
    private final int PORT = 5050;

    public Server() {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            
            while (true) { 
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
                // parallelize client handlers
            }
        } catch (Exception e) {
            System.out.println("Error in server: " + e.getMessage());
        }

        
    }
}
