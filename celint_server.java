import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class celint_server {
    
    public static void main(String[] args) throws IOException {
        
        try{
        
        Socket s=new Socket("192.168.1.57",8009);
        DataInputStream dis=new DataInputStream (s.getInputStream());
            DataOutputStream dos=new DataOutputStream (s.getOutputStream());
            Scanner sc=new Scanner (System.in);
            
            System.out.println("Server has been conncted succesfuuly");
            
            Thread th=new Thread(){
                @Override
                public void run(){
                    while(true){
                        try{
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
                @Override
                public void run(){
                    while(true){
                        String message=sc.nextLine();
                        try{
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
