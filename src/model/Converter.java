package model;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class Converter {

    private final File fileToConvert;

    public Converter(File fileToConvert) throws InvalidFileExtention, FileNotFoundException {

        if(!fileToConvert.exists()) throw new FileNotFoundException();
        if(!isFileExtensionValid(fileToConvert)) throw new InvalidFileExtention("invalid extension");
        this.fileToConvert = fileToConvert;
    }

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

    public File getFileToConvert() { return fileToConvert; }
}
