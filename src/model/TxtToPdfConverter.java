package model;

import java.io.*;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.swing.*;

public class TxtToPdfConverter extends Converter {

    public TxtToPdfConverter(File file2Convert) throws FileNotFoundException {
        super(file2Convert);
    }

    public void convert() {

        BufferedReader txtFileReader = null;
        PdfWriter pdfWriter          = null;
        PdfDocument convertedPdfFile = null;
        Document document            = null;

        try {
            txtFileReader       = new BufferedReader(new FileReader(getFileToConvert()));
            pdfWriter           = new PdfWriter("/home/ep327/Dev/Java/PDFConverter/test_files/test.pdf"); //temp
            convertedPdfFile    = new PdfDocument(pdfWriter);
            document            = new Document(convertedPdfFile);

            convertedPdfFile.addNewPage();

            Paragraph parag = new Paragraph();
            String line;
            while((line = txtFileReader.readLine()) != null) parag.add(line + "\n");

            document.add(parag);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {

            try{
                txtFileReader.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            document.close();
        }
    }
}