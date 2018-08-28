package asia.embla.service;

import asia.embla.exception.ItemNotFoundException;
import asia.embla.model.dto.UserDTO;
import asia.embla.model.entity.User;
import asia.embla.repository.UserRepository;
import asia.embla.validation.DataValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static asia.embla.common.Constant.USER_NOT_EXISTS;

/**
 * Created by tharsan on 8/23/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DataValidationService validationService;

    @Override
    public UserDTO create(UserDTO userDTO) {
        validationService.validateName(userDTO.getName());
        validationService.validateAge(userDTO.getAge());
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        repository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO get(int id) {
        User user = repository.findOne(id);
        if(user == null){
            throw new ItemNotFoundException(USER_NOT_EXISTS);
        }
        return getUser(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = repository.findOne(userDTO.getId());
        if(user == null){
            throw new ItemNotFoundException(USER_NOT_EXISTS);
        }
        user.setName(user.getName());
        user.setAge(userDTO.getAge());
        repository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO delete(int id) {
        User user = repository.findOne(id);
        if(user == null){
            throw new ItemNotFoundException(USER_NOT_EXISTS);
        }
        UserDTO userDTO = get(id);
        repository.delete(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = repository.findAll();
        return getUsers(users);
    }

    private UserDTO getUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        return userDTO;
    }

    private List<UserDTO> getUsers(List<User> users){
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users){
            userDTOs.add(getUser(user));
        }
        return userDTOs;
    }
}
