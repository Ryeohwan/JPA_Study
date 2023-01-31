package mpti.domain.member.api.request;


import lombok.Getter;
import mpti.domain.member.entity.Ptlog;
import mpti.domain.member.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class UserRequest {
    // 회원가입할 때 담아갈 dto
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
    Ptlog ptlog;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    public UserRequest() {
    }

    public UserRequest(String name, String email, String password, int age, String gender, String phone, String address, Ptlog ptlog, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.ptlog = ptlog;
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
                .ptlog(ptlog)
                .createAt(createAt)
                .updateAt(updateAt).build();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPtlog(Ptlog ptlog) {
        this.ptlog = ptlog;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
