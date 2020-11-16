import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.time.*;

public class PatientImpl extends UnicastRemoteObject implements PatIntf {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public HashMap<String, Patient> record;
    public int count;

    public PatientImpl() throws RemoteException {
        record = new HashMap<String, Patient>();
        count = 0;
    }

    public String register(String n, String a, String d, String g, String h, String w, String b)
            throws RemoteException {
        count++;
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        h = date.toString();
        w = time.toString();
        Patient temp = new Patient(n, a, d, g, h, w, b);
        record.put(n, temp);
        return n;
    }

    @Override
    public String search(String pid) throws RemoteException {
        if (!record.containsKey(pid))
            return new String("Invalid Patient ID!Record Not Found");
        return record.get(pid).toString();
    }
}