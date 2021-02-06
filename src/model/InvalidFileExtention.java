package model;

public class InvalidFileExtention extends RuntimeException {
    public InvalidFileExtention(String message) {
        super(message);
    }
}
