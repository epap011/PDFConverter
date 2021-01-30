package model;

import java.io.InputStream;

public abstract class Converter {

    private final InputStream fileToConvert;

    public Converter(InputStream fileToConvert) {
        this.fileToConvert = fileToConvert;
    }

    private InputStream getFileToConvert() { return fileToConvert; }
}
