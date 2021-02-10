package model;

import java.io.*;

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
    public TxtToPdfConverter(File fileToConvert) {
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

        try {
            txtFileReader    = new BufferedReader(new FileReader(getFileToConvert()));
            pdfWriter        = new PdfWriter("C:\\Users\\bill0\\desktop\\Dev\\Java_stuff\\PDFConverter\\test_files\\new_test.pdf");
            convertedPdfFile = new PdfDocument(pdfWriter);
            document         = new Document(convertedPdfFile);

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