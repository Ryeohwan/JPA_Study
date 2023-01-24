package mpti.backend.domain.trainer.api.response;

import mpti.backend.domain.trainer.entity.Role;

import java.time.LocalDateTime;

public class TrainerResponse {
    // 회원가입했을 때 담아서 갈 response

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
