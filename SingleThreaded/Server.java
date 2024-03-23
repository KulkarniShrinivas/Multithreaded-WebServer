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
        ServerSocket socket = new ServerSocket(port);
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

             //printwriter
            //this will be used to send the data to the client
            //From client -> sever will accept the connection and we were listenimng IP and Port(8010)
            //So when c1 requests the server then server have opened the socket
            //so client----->server
            // ------------------- (opened socket)(output stream will be from server and input stream will be from client)
            //socket open then will be getting bits/bytes
            //so I need to write something on outputstream so using printwriter class we can write

            //I will be using BufferedReader to read the data from the client
           //Input stream I will be using buffer reader
           //so in this whatever bytes will get it will combine  and give the result
           //PrintWriter->  In this whatever we give text it will convert into bytes and send to the client
           //BufferedReader-> In this whatever bytes we get it will convert into text and give the result

            BufferedReader fromclient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

            toClient.println("Hello from the Server");

            //client---->server
            //fromclient------toclient  |------------|
            //in---------------out

            
        }


    }
    //I will be creating this class because the function which we defined is not static method
    //if its not static method then it will not be stored in memory or it will not be there

    public static void main(String[] args){
        Server server = new Server();
       // so for this will be creating instance
        try{
            server.run();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}