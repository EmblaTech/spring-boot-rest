package asia.embla.validation;

import asia.embla.exception.InvalidDataException;
import org.springframework.stereotype.Service;

import static asia.embla.common.Constant.INVALID_AGE;
import static asia.embla.common.Constant.INVALID_NAME;

/**
 * Created by tharsan on 8/23/18.
 */
@Service
public class DataValidationService {
    public void validateAge(int age){
        if(age <= 0 || age > 100){
            throw new InvalidDataException(INVALID_AGE);
        }
    }

    public void validateName(String name){
        if(name == null || name.isEmpty()){
            throw new InvalidDataException(INVALID_NAME);
        }
    }
}
