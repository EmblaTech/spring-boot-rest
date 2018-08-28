package asia.embla.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tharsan on 8/23/18.
 */
public class UserDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;
}
