package model;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The abstract class Converter implements an application that converts
 * a legitimate file to a pdf and the opposite.
 */
public abstract class Converter {

    private final File fileToConvert;

    /**
     * PreConditions : The file must exist and the extension must be valid
     * PostConditions: The converting file has been initialized
     * @param fileToConvert the converting file to a pdf
     */
    public Converter(File fileToConvert) throws InvalidFileExtention, FileNotFoundException {

        if(!fileToConvert.exists()) throw new FileNotFoundException();
        if(!isFileExtensionValid(fileToConvert)) throw new InvalidFileExtention("invalid extension");
        this.fileToConvert = fileToConvert;
    }

    /**
     * PreConditions : The converting file's extension must be legitimate
     * PostConditions: A new .pdf file has been created
     */
    public abstract void convert();

    /**
     * PostConditions: Returns false if file's extension is invalid , otherwise true
     */
    public boolean isFileExtensionValid(File file) {

        ToConvertFileExtension[] allToConvertFileExtensions = ToConvertFileExtension.values();
        String nameOfFile = file.getName();
        String extensionOfFile = null;

        for(int i = 0; i < nameOfFile.length(); i++) {
            if(nameOfFile.charAt(i) == '.') {
                extensionOfFile = nameOfFile.substring(i+1);
                break;
            }
        }

        for(ToConvertFileExtension ext : allToConvertFileExtensions) {
            if(ext.toString().equals(extensionOfFile)) {
                return true;
            }
        }
        return false;
    }

    /**
     * PostCondition: The converting file has been returned
     */
    public File getFileToConvert() { return fileToConvert; }
}
