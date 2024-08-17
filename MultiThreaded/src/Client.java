import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
   

    public Runnable getRunnable(){
        //Runnable is functional interface whcih doesnot accept and wont give anything
        //only method we can use is run

        return new Runnable() {
            @Override
            public void run() {
                int port = 8010;
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address, port);
                    try (
                            PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                    ) {
                        toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                        String line = fromSocket.readLine();
                        System.out.println("Response from Server " + line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // The socket will be closed automatically when leaving the try-with-resources block
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        //spooning of 100 clients in some miliseconds diffreance


        for(int i=0; i<100; i++){
            try{
                //Runnable is functional interface so we can pass the function as a parameter
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            }catch(Exception ex){
                return;
            }
        }
        return;
    }
}
