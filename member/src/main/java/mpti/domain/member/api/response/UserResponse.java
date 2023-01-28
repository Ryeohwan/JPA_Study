package mpti.domain.member.api.response;


import lombok.Builder;
import lombok.Getter;
import mpti.domain.member.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    // 회원가입했을 때 담아서 갈 response
    Long id;
    String name;
    String email;
    int age;
    String gender;
    String phone;
    String address;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    @Builder
    public UserResponse(String name, String email, int age, String gender, String phone, String address, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .age(age)
                .gender(gender)
                .phone(phone)
                .address(address)
                .createAt(createAt)
                .updateAt(updateAt).build();
    }

}
