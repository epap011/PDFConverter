package model;

import java.io.*;
import java.util.Scanner;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * The class TxtToPdfConverter implements an application that converts
 * a .txt file to a .pdf.
 */
public class TxtToPdfConverter extends Converter {

    /**
     * PreConditions : The file must exist and the extension must be .txt
     * PostConditions: The converting file has been initialized
     * @param fileToConvert the .txt file
     */
    public TxtToPdfConverter(File fileToConvert) throws FileNotFoundException {
        super(fileToConvert);
    }

    /**
     * PreConditions : The converting file's extension must be .txt
     * PostConditions: A new .pdf file has been created
     */
    public void convert() {

        PdfWriter pdfWriter;
        PdfDocument convertedPdfFile;
        BufferedReader txtFileReader = null;
        Document document            = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter .pdf file full-path: ");

        try {
            txtFileReader       = new BufferedReader(new FileReader(getFileToConvert()));
            pdfWriter           = new PdfWriter(sc.next());
            convertedPdfFile    = new PdfDocument(pdfWriter);
            document            = new Document(convertedPdfFile);

            convertedPdfFile.addNewPage();

            Paragraph paragraph = new Paragraph();
            String line;
            while((line = txtFileReader.readLine()) != null) paragraph.add(line + "\n");

            document.add(paragraph);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {

            try{
                if(txtFileReader != null) txtFileReader.close();
                if(document != null) document.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}