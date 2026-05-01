import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
    public Client() {}

    public static void main(String[] args) throws IOException {


        String IPAddressString = "10.200.51.18";
        InetAddress host = InetAddress.getByName(IPAddressString);

        int port = 20110;


        System.out.println("Client connecting to " + host.toString() + ":" + port);
        Socket clientSocket = new Socket(host, port);

        // Like files, we use readers and writers for convenience
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Writer writer = new OutputStreamWriter(clientSocket.getOutputStream());


        writer.flush();


        // We can read what the server has said
        String response = reader.readLine();
        System.out.println("The server said : " + response);

        // Close down the connection
        clientSocket.close();
    }
}

