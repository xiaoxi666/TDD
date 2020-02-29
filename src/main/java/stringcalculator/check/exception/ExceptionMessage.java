package stringcalculator.check.exception;

public class ExceptionMessage {
    private String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static ExceptionMessage valueOf(String message) {
        return new ExceptionMessage(message);
    }
}
