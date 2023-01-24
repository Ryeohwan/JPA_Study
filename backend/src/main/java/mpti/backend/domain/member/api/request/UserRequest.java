package mpti.backend.domain.member.api.request;

import lombok.Getter;

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
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
