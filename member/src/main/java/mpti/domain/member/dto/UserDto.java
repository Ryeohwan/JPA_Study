package mpti.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mpti.domain.member.entity.Role;

import java.time.LocalDateTime;


@Getter
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String password;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @Builder
    public UserDto(String email, String name, String password, int age, String gender, String phone, String address,  LocalDateTime createAt, LocalDateTime updateAt) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
