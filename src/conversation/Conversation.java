/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Conversation{
    static String filename;
    int count=0;
    int choose;
    static JFileChooser fileChooser;
    static File file;
    public static void choose() {
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF","pdf","DOC","doc","DOCX","docx");
            fileChooser.setFileFilter(filter);
            fileChooser.setMultiSelectionEnabled(true);
            int returnVal = fileChooser.showOpenDialog(null);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                if (file.getPath().substring(file.getPath().length() - 1).equals("f")){
                    String writing=Pdftotxt.convertPDFFileToTXTFile(file.getPath());
                    String newfilepath=file.getPath().replace(".pdf", ".txt");
                }
                else if(file.getPath().substring(file.getPath().length() - 1).equals("c")){
                        String writing=Doctotxt.getreaddocfile(file.getPath());
                        String newfilepath=file.getPath().replace(".doc", ".txt");
                }else if(file.getPath().substring(file.getPath().length() - 1).equals("x")){
                            String writing=Docxtotxt.getreaddocfile(file.getPath());
                            String newfilepath=file.getPath().replace(".docx", ".txt");
                }
               
                }else if(returnVal == JFileChooser.CANCEL_OPTION)
                        System.exit(1);
            
            }

 
        
       
               
    
    
       public static void main(String args[]) throws FileNotFoundException, IOException {
            choose();
           
        }
}        
  