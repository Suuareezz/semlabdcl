import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

public class TCPMultiServer {

    public static void main(String argv[]) throws Exception {

        ServerSocket welcomeSocket = new ServerSocket(6789);

        Responder h = new Responder();

        while (true) {

            Socket connectionSocket = welcomeSocket.accept();

            Thread t = new Thread(new MyServer(h, connectionSocket));

            t.start();

        }
    }
}

class MyServer implements Runnable {

    Responder h;
    Socket connectionSocket;

    public MyServer(Responder h, Socket connectionSocket) {
        this.h = h;
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {

        while (h.responderMethod(connectionSocket)) {
            try {

                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        try {
            connectionSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class Responder {

    String serverSentence;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    synchronized public boolean responderMethod(Socket connectionSocket) {
        try {

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clientSentence = inFromClient.readLine();

            if (clientSentence == null || clientSentence.equals("EXIT")) {
                return false;
            }

            if (clientSentence != null) {
                System.out.println("client : " + clientSentence);
            }
            serverSentence = br.readLine() + "\n";

            outToClient.writeBytes(serverSentence);

            return true;

        } catch (SocketException e) {
            System.out.println("Disconnected");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}