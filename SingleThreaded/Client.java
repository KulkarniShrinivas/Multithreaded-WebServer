//We are requesting for server so will be creating class for that
//we will be sending millions or thousands of requests to the server by using Jmeter not by using client
//will be using Jmeter because in jmeter we can spoun multiple threads and we can send multiple requests to the server

import java.awt.print.Printable;
import java.io.IOException;
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

        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
    }

}
