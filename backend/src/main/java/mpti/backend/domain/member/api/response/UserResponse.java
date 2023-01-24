package mpti.backend.domain.member.api.response;


import java.time.LocalDateTime;

public class UserResponse {
    // 회원가입했을 때 담아서 갈 response

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
