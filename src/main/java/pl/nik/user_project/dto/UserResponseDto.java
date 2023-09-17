package pl.nik.user_project.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    @JsonProperty
    private int id;

    @JsonProperty
    private String userName;

    @JsonProperty
    private String email;

    @JsonProperty
    private LocalDateTime createDate;

    @JsonProperty
    private LocalDateTime lastVisitTime;

    @JsonCreator
    public UserResponseDto(int id, String userName, String email, LocalDateTime createDate, LocalDateTime lastVisitTime) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.createDate = createDate;
        this.lastVisitTime = lastVisitTime;
    }

    public UserResponseDto() {
    }
}

