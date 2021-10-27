package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public interface StudentInterface extends Remote {
    
    public float[][] fillMatrix(int numberNotes, int numberStudents) throws RemoteException;
    
//    public float majorNote(int [][] studentMatrix) throws RemoteException;
//    
//    public float minorNote(int [][] studentMatrix) throws RemoteException;
//    
//    public float groupAverage (int [][] studentMatrix) throws RemoteException;
//    
    
    
}
