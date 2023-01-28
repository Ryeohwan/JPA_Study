package mpti.domain.member.api.request;


import lombok.Getter;
import mpti.domain.member.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class UserRequest {
    // 회원가입했을 때 담아서 갈 response
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
    String name;
    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    String password;
    int age;
    String gender;
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})")
    String phone;
    String address;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    public UserRequest(String name, String email, String password, int age, String gender, String phone, String address, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .age(age)
                .phone(phone)
                .address(address)
                .createAt(createAt)
                .updateAt(updateAt).build();
    }
}
