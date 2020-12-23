import java.io.*;
import java.net.*;

public class LPClient {

    public static void main(String[] args) throws IOException
    {
        Socket clientSocket = null; // the connection socket
        PrintWriter out = null;
        // Get host and port
        String host = "localhost";
        int port = 3333;

        System.out.println("Connecting to " + host + ":" + port);

        // Trying to connect to a socket and initialize an output stream
        try {
            clientSocket = new Socket(host, port); // host and port
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + host);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Couldn't get I/O to " + host + " connection");
            System.exit(1);
        }

        System.out.println("Connected to server!");

        String msg;
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = null;
        // Initialize an input stream
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
        } catch (IOException e) {
            System.out.println("Couldn't get input to " + host + " connection");
            System.exit(1);
        }
        while ((msg = userIn.readLine())!= null)
        {
            out.println(msg);
            if(msg.contains("bye")){
                break;
            }
        }

        System.out.println("Exiting...");

        // Close all I/O
        out.close();
        userIn.close();
        clientSocket.close();
    }
}