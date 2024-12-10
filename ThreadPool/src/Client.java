import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private final ExecutorService threadPool;

    public Client(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void sendRequest(int clientId) {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 8010;

            try (Socket socket = new Socket(address, port);
                 PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Send a message to the server
                String message = "Hello from Client " + clientId;
                toServer.println(message);
                System.out.println("Client " + clientId + " sent: " + message);

                // Read the server's response
                String response = fromServer.readLine();
                System.out.println("Client " + clientId + " received: " + response);

            } catch (IOException e) {
                System.err.println("Client " + clientId + " encountered an error: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int numberOfClients) {
        for (int i = 1; i <= numberOfClients; i++) {
            int clientId = i;
            threadPool.execute(() -> sendRequest(clientId));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        int poolSize = 10;
        int numberOfClients = 50;

        Client client = new Client(poolSize);
        client.start(numberOfClients);
    }
}
