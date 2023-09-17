package pl.nik.user_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nik.user_project.converter.UserConverters;
import pl.nik.user_project.dto.UserRequestDto;
import pl.nik.user_project.dto.UserResponseDto;
import pl.nik.user_project.entity.User;
import pl.nik.user_project.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserConverters converter;

    @Autowired
    public UserService(UserRepository repository, UserConverters converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public void createUser(UserRequestDto user) {
        User entity = new User(0, user.getUserName(), user.getPassword(), user.getEmail(),
                LocalDateTime.now(), LocalDateTime.now());
        repository.save(entity);
    }

    public List<UserResponseDto> findAllUsers() {

        return new ArrayList<>((Collection) repository.findAll()).stream()
                .map(el -> converter.userEntityToResponseConverter((User) el))
                .toList();
    }

    public UserResponseDto findUserById(Integer id) {
        return converter.userEntityToResponseConverter(repository.findById(id)
                .orElse(null));
    }

    public UserResponseDto updateUser(UserRequestDto user, Integer id) {
        Optional<User> optionalUser = repository.findById(id);
        User updateUser;
        if (optionalUser.isPresent()) {
            updateUser = optionalUser.get();
            updateUser.setUserName(user.getUserName());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmail(user.getEmail());
            repository.save(updateUser);
            return converter.userEntityToResponseConverter(updateUser);
        }
        return null;
    }

}
