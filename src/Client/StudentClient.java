package Client;

import Interface.StudentInterface;
import java.io.IOException;
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
        String result = "";
        
        JOptionPane.showMessageDialog(null, "Bienvenido por favor marque aceptar y complete la informacion");
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
                    if(flag == 0){
                        noteMatrix = studentinterface.fillMatrix(notes, students);
                        flag = 1;
                    }
                    if (choice == 1) {
                        for (int i = 0; i < students; i++) {
                            result += "\n" + "estudiante " + (i+1);
                            for (int j = 0; j < notes; j++) {
                                result += "  " + noteMatrix[i][j];
                                result += "    ";
                            }
                        }
                        JOptionPane.showMessageDialog(null, result);
                        result = " ";
                    } else if (choice == 2) {
                        vectorNotes = studentinterface.majorNote(noteMatrix, students, notes);
                        for (int i = 0; i < students; i++) {
                            result += "La mejor nota del estudiante " + (i+1) + " es: " + vectorNotes[i];
                            result += "\n";
                        }
                        JOptionPane.showMessageDialog(null, result);
                        result = " ";
                    }else if (choice == 3) {
                        vectorNotes = studentinterface.minorNote(noteMatrix, students, notes);
                        for (int i = 0; i < students; i++) {
                            result += "La peor nota del estudiante " + (i+1) + " es: " + vectorNotes[i];
                            result += "\n";
                        }
                        JOptionPane.showMessageDialog(null, result);
                        result = " ";
                    }else if (choice == 4){
                        average = studentinterface.groupAverage(noteMatrix, students, notes);
                        JOptionPane.showMessageDialog(null, "El promedio del grupo es: " + average);
                    }
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    Logger.getLogger(StudentClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }       
        } while (choice != 5);    
    }

}
