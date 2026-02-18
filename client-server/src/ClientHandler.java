
import java.io.*;
import java.net.*;

/**
 * This class is only ran by the server and is responsible for handling all
 * client associated items such as messaging/broadcasting + receiving messages
 * from clients.
 */
public class ClientHandler implements Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private String username;
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("Error in client handler: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("\n Client connected at: " + socket.getInetAddress().getHostAddress());
            // Receive client username
            username = in.readLine().split(": ")[1];
            System.out.println("Client username is: " + username);

            listenForMessages();
        } catch (Exception e) {
        } finally {
            closeSocket();
        }
    }

    public final void listenForMessages() {
        try {
            String message;

            while ((message = in.readLine()) != null) {
            if (!message.isEmpty()) {
                System.out.println("Message received from " + username + ": " + message);
                Server.broadcastMessage(message);
            }
        }
        } catch (Exception e) {
            System.out.println("Error in listen for messages: " + e.getMessage());
        }
    }

    public final void broadcastServerMessage(String message) {
        out.println("Server: " + message);
    }

    public Socket getSocket() {
        return socket;
    }

    public final void broadcastClientMessage(String message) {
        out.println(username + ": " + message);
    }

    public final void closeSocket() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error closing client handler socket: " + e.getMessage());
        }
    }

    public final String getUsername() {
        return username;
    }

}
