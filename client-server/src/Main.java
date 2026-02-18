
/**
 * This is the main class that runs the server and client handler classes. It is responsible for determining whether to run the server or to connect a client to the server.
 * @param args
 * @throws Exception
 */ 
public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please specify 'start' to run the server or 'connect' to run the client.");
            return;
        }

        switch (args[0]) {
            case "start" -> {
                System.out.println("Switching to server");
                Server server = new Server();
                server.start();
            }
            case "connect" -> {
                System.out.println("Switching to client");
                Client client = new Client();
                client.start();
            }
            default -> System.out.println("Invalid argument. Use 'start' to run the server or 'connect' to run the client.");
        }
    }

}
