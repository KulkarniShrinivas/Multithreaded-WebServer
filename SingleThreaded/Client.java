// requesting for server so will be creating class for that
//sending millions or thousands of requests to the server by using Jmeter not by using client
// using Jmeter because in jmeter we can spoun multiple threads and we can send multiple requests to the server

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() throws IOException {
        int port = 8010;
       

        Socket socket = new Socket(adress, port);
       
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

       

        toSocket.println("Hello from the client");

        String line = fromSocket.readLine();
        System.out.println("Response from the socket is : "+line);

        toSocket.close();
        fromSocket.close();
        socket.close();
        
    }
    public static void main(String[] args) {
        try {
            //will be creating the object of the class and will be calling the run method
            Client client = new Client();
            client.run();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}

