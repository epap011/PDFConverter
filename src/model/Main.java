package model;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter .txt file full-path: ");
        File file2convert = new File(sc.next()); //temp
        TxtToPdfConverter converter;

        try{
            converter = new TxtToPdfConverter(file2convert);
            converter.convert();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
}
