package miniredis;

import java.nio.charset.StandardCharsets;
import java.io.*;
import java.net.*;
public class Client_code {
    public static void main(String[] args) throws IOException{
        try (Socket s = new Socket("localhost", 6380)) {
            s.getOutputStream().write("hello\n".getBytes(StandardCharsets.UTF_8));
            s.getOutputStream().flush();
            byte[] buf = new byte[100];
            int n = s.getInputStream().read(buf); // may return fewer bytes than were sent!
            System.out.println(new String(buf, 0, n, StandardCharsets.UTF_8));
        }

    }
}
