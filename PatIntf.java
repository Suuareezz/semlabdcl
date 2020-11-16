import java.rmi.*;

public interface PatIntf extends Remote {
    String register(String n, String a, String d, String g, String h, String w, String b) throws RemoteException;

    String search(String pid) throws RemoteException;
}