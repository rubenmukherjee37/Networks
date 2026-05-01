import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public Server() {}

    public static void main(String[] args) throws IOException {


        int port = 20110;


        System.out.println("Opening the server socket on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);


        System.out.println("Server waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");


        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Writer writer = new OutputStreamWriter(clientSocket.getOutputStream());


        String message = reader.readLine();
        System.out.println("The client said : " + message);

        // Sending a message to the client at the other end of the socket
        //System.out.println("Sending a message to the client");
       // writer.write("Nice to meet you\n");
        writer.flush();
        // To make better use of bandwidth, messages are not sent
        // until the flush method is used

        // Close down the connection
        clientSocket.close();
    }
}

