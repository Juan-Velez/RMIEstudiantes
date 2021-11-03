package Client;

import Interface.StudentInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public class StudentClient {

    public static void main(String[] args) throws IOException, NotBoundException {

        int notes, students, flag = 0, choice = 0;
        float noteMatrix[][] = new float[0][0];
        float average;
        float vectorNotes[] = new float[0];
        String resultado = "";
        
        JOptionPane.showMessageDialog(null, "Bienvenido por favor marque aceptar y compete la informacion");
        students = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de estudiantes"));
        notes = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de notas por estudiante"));
        
        do {  
           String lectura = JOptionPane.showInputDialog("1.Ver notas de los estudiantes\n"
                                                    + "2.Mejor nota por estudiante\n"
                                                    + "3.Peor nota por estudiantes\n"
                                                    + "4.Promedio del grupo\n"
                                                    + "5.Salir");

                choice = Integer.parseInt(lectura);
            
            if (choice != 5) {
                try {
                    StudentInterface studentinterface = (StudentInterface) Naming.lookup("Student");
                    if (choice == 1) {
                        if(flag == 0){
                            noteMatrix = studentinterface.fillMatrix(notes, students);
                            for (int i = 0; i < students; i++) {
                                for (int j = 0; j < notes; j++) {
                                    resultado += noteMatrix[i][j];
                                    resultado += "    ";
                                }
                                resultado += "\n";
                            }
                            JOptionPane.showMessageDialog(null, resultado);
                            resultado = " ";
                            flag = 1;
                        }else {
                            for (int i = 0; i < students; i++) {
                                for (int j = 0; j < notes; j++) {
                                    resultado += noteMatrix[i][j];
                                    resultado += "    ";
                                }
                                resultado += "\n";
                            }
                            JOptionPane.showMessageDialog(null, resultado);
                            resultado = " ";
                        }
                    } else if (choice == 2) {
                        vectorNotes = studentinterface.majorNote(noteMatrix, students, notes);
                        for (int i = 0; i < students; i++) {
                            resultado += "La mejor nota del estudiante " + (i+1) + " es: " + vectorNotes[i];
                            resultado += "\n";
                        }
                        JOptionPane.showMessageDialog(null, resultado);
                        resultado = " ";
                    }else if (choice == 3) {
                        vectorNotes = studentinterface.minorNote(noteMatrix, students, notes);
                        for (int i = 0; i < students; i++) {
                            resultado += "La peor nota del estudiante " + (i+1) + " es: " + vectorNotes[i];
                            resultado += "\n";
                        }
                        JOptionPane.showMessageDialog(null, resultado);
                        resultado = " ";
                    }else if (choice == 4){
                        average = studentinterface.groupAverage(noteMatrix, students, notes);
                        JOptionPane.showMessageDialog(null, average);
                        System.out.println(average);
                    }
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    Logger.getLogger(StudentClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }       
        } while (choice != 5);    
    }

}
