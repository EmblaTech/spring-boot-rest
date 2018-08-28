package asia.embla.exception;

/**
 * Created by tharsan on 8/23/18.
 */
public class InvalidDataException extends CustomException {

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Exception exception) {
        super(message, exception);
    }
}
