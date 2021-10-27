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

/** 
 *
 * @author Juan David Velez Velez
 * @author Sneider Alonso Gomez
 */
public class StudentClient {
    
    public static void main (String[] args) throws IOException, NotBoundException {
    
        int notes, students;
        float matrix[][];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {

            System.out.println("Number of students: ");
            notes = Integer.parseInt(br.readLine());
            System.out.println("Number of notes: ");
            students = Integer.parseInt(br.readLine());

            StudentInterface studentinterface = (StudentInterface) Naming.lookup("Student");
            //aqui puede estar el error
            matrix = studentinterface.fillMatrix(notes, students);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.println(matrix[i][j]);
                }
            }
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(StudentClient.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        
        
    }
    
}
