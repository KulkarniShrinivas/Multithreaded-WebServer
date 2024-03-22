import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Server{

    public void run() throws IOException, UnknownHostException{
        //will define port so that our server can listen to that port
        int port = 8010;

        //we have opened a server socket on this port
        ServerSocket Socket = new ServerSocket(port);
        //ifconfig will give you the ip address of your machine

        socket.setSoTimeout(10000);
        //this will make the server to wait for 10 seconds for the client to connect
        //if the client does not connect in 10 seconds, the server will throw an exception and it will closes automatically 
        //but in realtime production socket will be always open

        //this will make the server to wait for the client to connect
        while(true){

                 System.out.println("Server is listening on port "+port);
            //the code will be waiting below line until we get connection from the client
            //After 10 seconds, the server will throw an exception and it will closes automatically
            Socket acceptedConnection = socket.accept();
            //this will accept the connection from the client(So whenever will get connection )
            //this will return the socket object which will be used to communicate with the client
            System.out.println("Connection accepted from client: "+acceptedConnection.getInetAddress());
            //this will print the socket ip address of the client ^
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);





            
        }


    }

    public static void main(String[] args){

    }
}