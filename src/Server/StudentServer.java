package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Implement.StudentImplement;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public class StudentServer {

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        StudentImplement studentimplement = new StudentImplement(0,0);
        reg.rebind("Student", studentimplement);
        System.out.println("servidor iniciado");
    }
    
}
