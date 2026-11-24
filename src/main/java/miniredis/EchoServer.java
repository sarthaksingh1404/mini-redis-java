package miniredis;

import java.io.*;
import java.net.*;
import java.util.*;
public class EchoServer {
    public static void main(String[] args) throws IOException{
        try(ServerSocket server = new ServerSocket(6380)){
            System.out.println("listening on 6380");
            while (true){
                Socket client = server.accept();
                System.out.println("Client connected : "+ client.getRemoteSocketAddress());
                try(client;
                    InputStream in = client.getInputStream();

                    OutputStream out = client.getOutputStream()){
                    byte[] buf = new byte[1024];
                    int n;
                    while((n = in.read(buf))!=-1){

                        out.write(buf,0,n);
                        out.flush();

                    }
                }
                System.out.println("Client Disconnected");
            }
        }
    }
}
