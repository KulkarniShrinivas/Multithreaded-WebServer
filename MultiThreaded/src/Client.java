import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
    //In single thread we used only one request to send server
    //But in Multithreaded Client will send multiple requests to the server
    //So to request Client also required the thread to send multiple requests because we have only one client
    //So In this we need to spoon 100 clinets to send multiple requests to the server
    //100 Threads every thread will send the request to the server
    //So we need to create the 100 threads to send the request to the server


    //runnable is interface
    //Runnable is functional interface

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