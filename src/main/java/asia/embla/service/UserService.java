package asia.embla.service;

import asia.embla.model.dto.UserDTO;

import java.util.List;

/**
 * Created by tharsan on 8/23/18.
 */
public interface UserService {
    UserDTO create(UserDTO userDTO);
    UserDTO get(int id);
    UserDTO update(UserDTO userDTO);
    UserDTO delete(int id);
    List<UserDTO> getAll();
}
