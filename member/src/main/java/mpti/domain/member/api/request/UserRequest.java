package mpti.domain.member.api.request;

import lombok.Getter;
import mpti.domain.member.entity.Role;

import java.time.LocalDateTime;

@Getter
public class UserRequest {
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
