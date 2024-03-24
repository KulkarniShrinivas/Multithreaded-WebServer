//We are requesting for server so will be creating class for that
//we will be sending millions or thousands of requests to the server by using Jmeter not by using client
//will be using Jmeter because in jmeter we can spoun multiple threads and we can send multiple requests to the server

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() throws UnknownHostException, IOException {
        int port = 8010;
        //server will be runninning on locol port on machine itself
        InetAddress adress = InetAddress.getByName("localhost");
        //locolhost- whatever the machine ip adress is there it will be connected to that
        //this will be connected to the server//unknown host also can gives exception so we will be makeing it checked
        //and will be catching as Throw UnknownHostException in run method

        Socket socket = new Socket(adress, port);
        //socket will be throwing IO exception so we will be catching it by IoException
        //So whatever we have created the socket for client will be having input/output socket



        //client---->server
        //toSocket(PrintWriter)------fromSocket(Buffer)  |------------|
        //PrintWriter(to write)->
        //Buffer(to read)-> In this whatever bytes we get it will convert into text and give the result
        //in---------------out
        //client will be connecting so I will be opening the socket and will be connecting to the server
        //so I will be using printwriter to write the data to the server
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //socket input we need to take
        //so we will be using InputStreamReader to read the data from the socket
        //so we will be using BufferedReader to read the data from the socket

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
//output after connecting to the server specific time it wil disconnects and throws an exception
