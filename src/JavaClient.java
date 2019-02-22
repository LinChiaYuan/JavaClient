/**
 *
 *  author  :   Chia Yuan Lin (林家源)
 *
 *  email   :   lo919201@gmail.com
 *
 * **/
import java.io.*;
import java.net.*;

public class JavaClient
{
    public static void main(String[] args)
    {
        try
        {
            String remoteHost = "127.0.0.1";
            int port = 8888;

            File file = new File("D:\\FB20180813152108241634.jpg");
            Socket skt = new Socket(remoteHost, port);
            PrintStream printStream = new PrintStream(skt.getOutputStream());
            printStream.println(file.getName());
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            int readin;
            while((readin = inputStream.read()) != -1)
            {
                printStream.write(readin);
                Thread.yield();
            }
            printStream.flush();
            printStream.close();
            inputStream.close();
            skt.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(" END ");
    }
}