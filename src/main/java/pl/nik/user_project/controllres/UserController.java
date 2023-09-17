package pl.nik.user_project.controllres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nik.user_project.dto.UserRequestDto;
import pl.nik.user_project.dto.UserResponseDto;
import pl.nik.user_project.exception_layer.exceptions.NoNikalajException;
import pl.nik.user_project.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void createUser(@Valid @RequestBody UserRequestDto user) {
        service.createUser(user);
    }

    @GetMapping
    public List<UserResponseDto> findUsers() {
        List<UserResponseDto> allUsers = service.findAllUsers();
        if (allUsers.stream().anyMatch(el -> el.getUserName().equals("Nikalaj"))) {
            throw new NoNikalajException("ошибка в имени!");
        }
        return allUsers;
    }

    @GetMapping("/{id}")
    public UserResponseDto findUserByID(@PathVariable Integer id) {
        return service.findUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserResponseDto findUserByID(UserRequestDto user, @PathVariable Integer id) {
        return service.updateUser(user, id);
    }

    @ExceptionHandler(ArithmeticException.class)
    public void exHandler () {

    }
}
