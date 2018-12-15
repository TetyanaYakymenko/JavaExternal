package ua.com.task6;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class JabberClient {
    public static void main(String[] args)throws IOException{
        InetAddress address = InetAddress.getByName("localhost");//!!!!!!!!!!!!!!!
        System.out.println("address = " + address);
        Socket socket = new Socket("127.0.0.1", 8080);
        try{
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            new Thread(()->{
                while (true){
                    try{
                        System.out.println(in.readLine());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
            for (int i = 0; i < 10; i++){
                out.println("client: " + br.readLine());
            }
            out.println("END");
        }finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}
