package asia.embla.exception;

/**
 * Created by tharsan on 8/23/18.
 */
public class ItemNotFoundException extends CustomException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}
