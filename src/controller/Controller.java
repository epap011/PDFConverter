package controller;

import model.TxtToPdfConverter;

import java.io.File;

public class Controller {

    public Controller() { }

    public void convertFile(File fileToConvert) {
        TxtToPdfConverter txtToPdfConverter = new TxtToPdfConverter(fileToConvert);
        txtToPdfConverter.setFileToConvert(fileToConvert);
        txtToPdfConverter.convert();
    }
}
