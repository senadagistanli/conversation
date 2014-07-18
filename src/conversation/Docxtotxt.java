/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Sena
 */
class Docxtotxt {
    public static String getreaddocfile(String filepath) {
        
        FileInputStream fis; 
        String outPut = null;
        String str = null;
        int count=0;
        try { 
        fis = new FileInputStream((filepath));
        XWPFDocument doc = new XWPFDocument(fis); 
        XWPFWordExtractor extract = new XWPFWordExtractor(doc);
        outPut = extract.getText();
        System.out.println(outPut);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.replace(".docx", ".txt")));
        writer.write(outPut);
        writer.newLine();
        writer.close();
        System.out.println("donusturme basarili");
         
     
        return outPut; 
        } catch (IOException e) { 

        e.printStackTrace(); 
        } 
        return outPut;
        
    }
    
    
    
    
}
