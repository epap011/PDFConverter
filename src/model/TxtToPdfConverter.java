package model;

import java.io.*;
import java.net.URL;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.swing.*;

public class TxtToPdfConverter extends Converter {

    private final BufferedReader fileToConvertReader;
    private PdfWriter writer;
    private PdfDocument convertedPdfFile;
    private Document document;

    public TxtToPdfConverter(File file2Convert) throws FileNotFoundException {
        super(file2Convert);
        fileToConvertReader = new BufferedReader(new FileReader(file2Convert));

        writer = new PdfWriter("/home/ep327/Dev/Java/PDFConverter/test/test.pdf"); //temp
        convertedPdfFile = new PdfDocument(writer);
        document = new Document(convertedPdfFile);
    }

    public void convert() {

        Paragraph para1 = new Paragraph("PDF Creation :)");

        convertedPdfFile.addNewPage();
        document.add(para1);
        document.close();
    }
}