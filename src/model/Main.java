package model;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file2convert = new File("/home/ep327/Dev/Java/PDFConverter/test/test.txt"); //temp
        TxtToPdfConverter converter;

        try{
            converter = new TxtToPdfConverter(file2convert);
            converter.convert();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "File not Found!");
            System.exit(0);
        }
    }
}
