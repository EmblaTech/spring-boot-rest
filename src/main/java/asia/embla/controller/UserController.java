package asia.embla.controller;

import asia.embla.common.Response;
import asia.embla.model.dto.UserDTO;
import asia.embla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static asia.embla.common.Constant.*;

/**
 * Created by tharsan on 8/23/18.
 */
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Response create(@RequestBody UserDTO userDTO){
        service.create(userDTO);
        return new Response(0, CREATE_SUCCESS.replace("{1}", userDTO.getName()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable(name = "id") int id){
        UserDTO user = service.get(id);
        return new Response(0, SUCCESS, user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Response update(@RequestBody UserDTO userDTO){
        service.update(userDTO);
        return new Response(0, UPDATE_SUCCESS.replace("{1}", userDTO.getName()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable(name = "id") int id){
        UserDTO userDTO = service.delete(id);
        return new Response(0, DELETE_SUCCESS.replace("{1}", userDTO.getName()));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response getAll(){
        List<UserDTO> users = service.getAll();
        return new Response(0, SUCCESS, users);
    }
}
