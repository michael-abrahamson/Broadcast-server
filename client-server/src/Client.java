import java.net.Socket;
/**
 * This class is only ran by the client and is responsible for handling all client associated items such as messaging/broadcasting + receiving messages from the server.
 */
public class Client {
    private final String SERVER_ADDRESS = "localhost";
    private final int PORT = 5050;

    

    public Client() {
        System.out.println("Client is starting...");

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            System.out.println("Client is connected to server at: " + SERVER_ADDRESS + ":" + PORT);
            while (true) { 
                
            }
        } catch (Exception e) {
            System.out.println("Error in client: " + e.getMessage());
        }
    }
}
