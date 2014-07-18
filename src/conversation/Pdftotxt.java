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
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author Sena
 */
class Pdftotxt {
    
	public static String convertPDFFileToTXTFile(String fileName) {
            PDFParser parser = null;
            PDDocument pdDoc = null;
            COSDocument cosDoc = null;
            PDFTextStripper pdfStripper;

            String parsedText = null;
            File file = new File(fileName);
            try 
            {
                parser = new PDFParser(new FileInputStream(file));
                parser.parse();
                cosDoc = parser.getDocument();
                pdfStripper = new PDFTextStripper();
                pdDoc = new PDDocument(cosDoc);
                parsedText = pdfStripper.getText(pdDoc);
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName.replace(".pdf", ".txt")));
                writer.write(parsedText);
                writer.newLine();
                writer.close();
                 System.out.println("donusturme basarili");
            } 
            catch (Exception e) {
                e.printStackTrace();
            try {
                 if (cosDoc != null)
                    cosDoc.close();
                 if (pdDoc != null)
                    pdDoc.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }
          }
            return parsedText;
        }
      
}
