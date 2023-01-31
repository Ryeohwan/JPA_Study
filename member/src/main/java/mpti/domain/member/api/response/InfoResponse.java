package mpti.domain.member.api.response;


import lombok.Getter;
import mpti.domain.member.entity.Ptlog;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class InfoResponse {
    // 회원가입했을 때 담아서 갈 response
    UUID id;
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
    String name;
    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    String email;
    int age;
    String gender;
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})")
    String phone;
    String address;
    Ptlog ptlog;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
