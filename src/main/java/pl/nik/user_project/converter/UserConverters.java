package pl.nik.user_project.converter;

import org.springframework.stereotype.Component;
import pl.nik.user_project.dto.UserResponseDto;
import pl.nik.user_project.entity.User;

@Component
public class UserConverters {
    public UserResponseDto userEntityToResponseConverter(User user) {
        return new UserResponseDto(
                user.getId(), user.getUserName(), user.getEmail(),
                user.getCreateDate(), user.getLastVisitTime()
        );
    }
}
