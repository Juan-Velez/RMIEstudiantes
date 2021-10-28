
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
    public float matrix[][];

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

    public float[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(float[][] matrix) {
        this.matrix = matrix;
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

        float matrixx[][] = new float[numberStudents][numberNotes];
        
        System.out.println(numberStudents);
        for (int i = 0; i < numberStudents; i++) {
            for (int j = 0; j < numberNotes; j++) {
                matrixx[i][j] = 14;
      
            } 
        }
        matrix = matrixx;
        return matrix;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


}
