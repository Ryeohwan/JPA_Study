package mpti.backend.domain.trainer.api.request;

import lombok.Getter;
import mpti.backend.domain.trainer.entity.Role;

import java.time.LocalDateTime;

@Getter
public class TrainerRequest {
    String name;
    String email;
    String password;
    int age;
    String gender;
    String phone;
    String address;
    Role role;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
