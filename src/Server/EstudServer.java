package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Implement.EstudImplement;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public class EstudServer {

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        //CalcImplement calcImplement = new CalcImplement(0, 0);
        //nombre objeto
        //reg.rebind("Calc", calcImplement);
        System.out.println("servidor iniciado");
    }
}
