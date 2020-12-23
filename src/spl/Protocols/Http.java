import java.io.*;
import java.net.*;

public class Http {

    public static void main(String[] args) throws Exception {
        String host = "www.cs.bgu.ac.il";//args[0];
        try (Socket lp = new Socket(host, 80);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(lp.getOutputStream(), "UTF-8"), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(lp.getInputStream(),"UTF-8"))) {
            out.print("GET / HTTP/1.0\r\n" +
                    "Host: " + host + "\r\n" +
                    "\r\n");
            out.flush();
            String msg = in.readLine();
            while (msg != null) {
                System.out.println(msg);
                msg = in.readLine();
            }
        }catch (Exception e) { System.out.println("Error: " + e); }
        }

    }
