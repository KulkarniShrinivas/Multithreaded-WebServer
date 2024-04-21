// This is the server code which will be running on the server machine


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;


public class Server {

    //will be using functional Interface
    //will be using Runnable Interface
    //functional Interface are 1st class citizen
    //so we can pass the function as a parameter or we can pass in argument
    //the which we are using will be consumer

    public Consumer<Socket> getConsumer(){

        return (clientSocket) -> {

            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
//                toSocket.println("Hello from server " + clientSocket.getInetAddress());
                    toClient.println("Hello from the server");
                    toClient.close();
                    clientSocket.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } ;
    }


    public static void main(String[] args) {
        int port = 8010;
        //we have opened a server socket on this port
        //I will create new instance  of the server socket
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            //ifconfig will give you the ip address of your machine

            serverSocket.setSoTimeout(70000);
            //this will make the server to wait for 10 seconds for the client to connect
            //if the client does not connect in 10 seconds, the server will throw an exception and it will closes automatically
            //but in realtime production socket will be always open

            //this will make the server to wait for the client to connect
            System.out.println("Server is listening on port "+port);

            while(true){
                //the code will be waiting below line until we get connection from the client
                //After 10 seconds, the server will throw an exception and it will closes automatically
                Socket acceptedConnection = serverSocket.accept();

                //this will accept the connection from the client(So whenever will get connection )

                //Thread will run function so will communicate with the client or associated socket

                //I will be calling get consumer method and thread will be given a consumer
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedConnection));
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// Steps to rhit the request to the server using Jmeter

//I will be installing Jmeter for checking the number of request that I can hit
//cd apache-jmeter-5.6.3/bin
//./jmeter
//I will be creating a new test plan
//I will be adding a thread group
//I will add How many users I need to hit/spoon(Number of Threads)
//I will add the ramp-up period/How many seconds it will take to hit the server ex-60seconds
//will be making 1k request per second
//I will be adding the sampler
//I will be adding the TCP sampler
//I will be adding the server name and port number
//For this I will adding result Tree and view result in table
//Also will be adding graph result
//I will be running the test