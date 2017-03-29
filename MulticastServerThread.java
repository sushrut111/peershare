import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServerThread extends QuoteServerThread {

    private long FIVE_SECONDS = 5000;

    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }

    public void exit1()
    {
        try{
            byte[] buf = new byte[1024];
        String dString = "exiting";
        buf = dString.getBytes();
        InetAddress group = InetAddress.getByName("255.255.255.255");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4447);
        socket.send(packet);    
        }       
        catch(Exception e)
        {
            e.printStackTrace();
        }
          
    }

    public void run() {
        while (true) {
            try {
                FileList f = new FileList();

                byte[] buf = new byte[1024];

                String dString = f.getList();

                
                buf = dString.getBytes();



		    // send it
                InetAddress group = InetAddress.getByName("255.255.255.255");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4447);
                socket.send(packet);
               // System.out.println("sent: "+dString);

		    // sleep for a while
		try {
		    sleep((long)(Math.random() * FIVE_SECONDS));
		} catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
		// moreQuotes = false;
            }
        }
	// socket.close();
    }
}
