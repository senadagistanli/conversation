/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author Sena
 */
class Doctotxt {
     public static String getreaddocfile(String filepath) {
        
        FileInputStream fis; 
        String outPut = null;
        String str = null;
        int count=0;
        try { 
            fis = new FileInputStream(new File(filepath)); 
            HWPFDocument doc = new HWPFDocument(fis); 
            WordExtractor extractor = new WordExtractor(doc);  
            outPut = extractor.getText(); 
            System.out.println(outPut);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.replace(".doc", ".txt")));
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
