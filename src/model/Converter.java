package model;

import java.io.File;

public abstract class Converter {

    private final File fileToConvert;

    public Converter(File fileToConvert) { this.fileToConvert = fileToConvert; }

    /**
     * PreConditions: The fileToConvert must be a .txt file
     * PostConditions: A new .pdf file has been created
     */
    public abstract void convert();

    /**
     * Returns false if the file extension of this file is not valid, otherwise true
     */
    public boolean isFileExtensionValid(File file) {

        ToConvertFileExtension[] allToConvertFileExtensions = ToConvertFileExtension.values();
        String nameOfFile = file.getName();

        for(ToConvertFileExtension ext : allToConvertFileExtensions) {
            if(ext.toString().equals(nameOfFile)) return true;
        }
        return false;
    }

    private File getFileToConvert() { return fileToConvert; }
}
