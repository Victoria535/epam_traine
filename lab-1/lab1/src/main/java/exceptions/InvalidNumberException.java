package exceptions;

public class InvalidNumberException extends CustomException {
    public int number;

    public InvalidNumberException(String message, int number) {
        super(message);
        this.number = number;
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
