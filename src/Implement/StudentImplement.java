
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

    public float[][] getNoteMatrix() {
        return noteMatrix;
    }

    public void setNoteMatrix(float[][] noteMatrix) {
        this.noteMatrix = noteMatrix;
    }

    public float[] getNoteVector() {
        return noteVector;
    }

    public void setNoteVector(float[] noteVector) {
        this.noteVector = noteVector;
    }

    
//    public float[][] matrizllena(int numberNotes,int numberStudents){
//                
//        float matrixx[][] = new float[numberStudents][numberNotes];
//        
//        System.out.println(numberStudents);
//        for (int i = 0; i < numberStudents; i++) {
//            for (int j = 0; j < numberNotes; j++) {
//                matrixx[i][j] = 14;
//      
//            } 
//        }
//        matrix = matrixx;
//        return matrix;
//    }
    
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
//        
//        float matrix[][] = new float[numberStudents][numberNotes];
//        
//        System.out.println("hola");
//        for (int i = 0; i < numberStudents; i++) {
//            for (int j = 0; j < numberNotes; j++) {
//                matrix[i][j] = 1;
//                
//            } 
//        }

//        
//       return matrizllena(numberNotes, numberStudents);


       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float groupAverage(float[][] studentMatrix, int numberStudents, int numberNotes) throws RemoteException {
        float sum = 0;
        float average = 0;

        System.out.println("hola");
        
        // Esto solo es de prueba
        for (int i = 0; i < numberStudents; i++) {
            for (int j = 0; j < numberNotes; j++) {
                sum = sum + studentMatrix[i][j];
            }
        }
        average = sum / numberStudents;

        
        return average ;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


}
