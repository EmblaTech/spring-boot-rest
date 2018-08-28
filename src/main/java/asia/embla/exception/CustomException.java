package asia.embla.exception;

/**
 * Created by tharsan on 8/23/18.
 */
public class CustomException extends RuntimeException {
    private String message;
    private Exception exception;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(String message, Exception exception) {
        super(message);
        this.message = message;
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
