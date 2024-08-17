// This is the server code which will be running on the server machine


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;


public class Server {

  

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
        et
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            //ifconfig will give you the ip address of your machine

            serverSocket.setSoTimeout(70000);
           

            //this will make the server to wait for the client to connect
            System.out.println("Server is listening on port "+port);

            while(true){
          
                Socket acceptedConnection = serverSocket.accept();

               
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedConnection));
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


