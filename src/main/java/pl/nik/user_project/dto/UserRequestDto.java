package pl.nik.user_project.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 1. ВАЛИДАЦИЯ имеется репозиторий хранения юзеров (имя пароль имейл). Добавляю валидацию для юзера
// *** в помфайле включаю валидацию *** добавляю аннотации над полями *** влючаю @Valid для post запроса

// 2. ОШИБКА. В системе запрещены имена Николай. Если при Get запросе findUsers() найдется такое имя - будет ошибка
// *** создаю ошибку NoNikalajException *** создаю глобальный обработчик ошибок @ControllerAdvice
// *** создаю @Exceptionhandler для моей ошибки, который возвращает ResponseEntity и статус запроса.
// все отработало
@Data
public class UserRequestDto {

    @Size(min = 3, max = 20)
    @JsonProperty
    private String userName;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Пароль должен содержать хотя бы одну цифру, одну строчную и одну заглавную букву," +
                    " один из специальных символов @#$%^&+=!, и быть не менее 8 символов в длину.")
    @JsonProperty
    private String password;
    @JsonProperty
    @Email
    private String email;

    @JsonCreator
    public UserRequestDto(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public UserRequestDto() {
    }
}


