
/**
 * This is the main class that runs the server and client handler classes. It is responsible for determining whether to run the server or to connect a client to the server.
 * @param args
 * @throws Exception
 */ 
public class Main {
    public static void main(String[] args) throws Exception {
        String input = args[0];

        switch (input) {
            case "start" -> {
                System.out.println("Switching to server");
                Server server = new Server();
            }
            case "connect" -> {
                System.out.println("Switching to client");
                Client client = new Client();
            }
        }
    }
}
