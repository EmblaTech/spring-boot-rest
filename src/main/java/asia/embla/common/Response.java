package asia.embla.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tharsan on 8/23/18.
 */
public class Response {
    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Object data;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
