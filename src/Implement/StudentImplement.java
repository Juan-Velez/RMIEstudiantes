
package Implement;

import java.rmi.server.UnicastRemoteObject;
import Interface.StudentInterface;
import java.rmi.RemoteException;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public class StudentImplement extends UnicastRemoteObject implements StudentInterface {

    public int notes;
    public int students;
    public float noteMatrix[][];
    public float noteVector[];

    public StudentImplement(int notes, int students) throws RemoteException {
        this.notes = notes;
        this.students = students;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    
    @Override
    public float[][] fillMatrix(int numberNotes, int numberStudents) throws RemoteException {
              
        float auxMatrix[][] = new float[numberStudents][numberNotes];
        
        for (int i = 0; i < numberStudents; i++) {
            for (int j = 0; j < numberNotes; j++) {
                auxMatrix[i][j] = (float) (Math.random()*6);
            }
        }
        noteMatrix = auxMatrix;
        return noteMatrix;
      
    }

    @Override
    public float[] majorNote(float[][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException {
        
        float major = 0;
        float auxVector[] = new float[numberStudents];
        float auxMatrix[][] = new float[numberStudents][numberNotes];
        auxMatrix = studentMatrix;
 
        for (int i = 0; i < numberStudents; i++) {
            for (int j = 0; j < numberNotes; j++) {
                if (auxMatrix[i][j] > major) {
                    major = auxMatrix[i][j];
                } 
            }
            auxVector[i] = major;  
            major = 0;
        }
        
        noteVector = auxVector;
        return noteVector;
        
    }

    @Override
    public float[] minorNote(float[][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException {
        
        float minor = 5;
        float auxVector[] = new float[numberStudents];
        float auxMatrix[][] = new float[numberStudents][numberNotes];
        auxMatrix = studentMatrix;
 
        for (int i = 0; i < numberStudents; i++) {
            for (int j = 0; j < numberNotes; j++) {
                if (auxMatrix[i][j] < minor) {
                    minor= auxMatrix[i][j];
                } 
            }
            auxVector[i] = minor;  
            minor = 5;
        }
        
        noteVector = auxVector;
        return noteVector;
        
    }

    @Override
    public float groupAverage(float[][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException {
        
        float sum = 0;
        float aux = 0;
        float aux2 = 0;
        float pro = 0;
        
        float auxMatrix[][] = new float[numberStudents][numberNotes];
        auxMatrix = studentMatrix;
        
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < notes; j++) {
                aux = aux + auxMatrix[i][j];
                sum = aux / notes;

            }
            aux2 = aux2 + sum;
            sum = 0;
            aux = 0;
        }
        pro = aux2 / students;
        return pro ;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    


}
