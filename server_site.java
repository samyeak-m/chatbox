import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Socket_server {

    
    public static void main(String[] args) throws IOException {
        
        ServerSocket ss=new ServerSocket(8009);
        Socket so=ss.accept();
        
        try{
            
            System.out.println("Server has been started.");
            
            System.out.println("client Server has been started "+so.getInetAddress().getHostAddress());
            
            
            Thread th=new Thread(){
                public void run(){
                    while(true){
                        try{
                            ServerSocket ss=new ServerSocket();
                            
                            DataInputStream dis=new DataInputStream (so.getInputStream());
                            System.out.println(" "+dis.readUTF());
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }
            };
            
            Thread th1=new Thread (){
                public void run(){
                    while(true){
                        Scanner sc=new Scanner (System.in);
                        String message=sc.nextLine();
                        try{
                            ServerSocket ss=new ServerSocket();
                            
                            DataOutputStream dos=new DataOutputStream (so.getOutputStream());
                            dos.writeUTF(message);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }
            };
            th.start();
           th1.start(); 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
