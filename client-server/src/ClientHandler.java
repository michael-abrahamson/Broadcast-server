
import java.net.*;




/**
 * This class is only ran by the server and is responsible for handling all client associated items such as messaging/broadcasting + receiving messages from clients.
 */
public class ClientHandler {
    

    public ClientHandler(Socket socket) {
        System.out.println("Client handler is starting...");

        System.out.println("\n Client connected at: " + socket.getInetAddress().getHostAddress());
    }

}
