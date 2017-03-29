import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteServerThread extends Thread {

    protected static DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public QuoteServerThread() throws IOException {
	this("QuoteServerThread");
    }

    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4446);

        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        } catch (FileNotFoundException e) {
            // System.err.println("Could not open quote file. Serving time instead.");
        }
    }



}
