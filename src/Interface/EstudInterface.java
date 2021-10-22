package Interface;

import java.rmi.RemoteException;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public interface EstudInterface {
    public float fillMatrix(float numberNotes, float numberStudents, int choice) throws RemoteException;
}
