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
    
    public float[] majorNote(float [][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException;
   
    public float[] minorNote(float [][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException;
   
    public float groupAverage(float [][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException;
   
    
}
