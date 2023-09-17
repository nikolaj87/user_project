package pl.nik.user_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime lastVisitTime;


    public User() {
    }

    public User(int id, String userName, String password, String email, LocalDateTime createDate, LocalDateTime lastVisitTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.lastVisitTime = lastVisitTime;
    }
}
