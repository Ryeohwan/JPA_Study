package mpti.domain.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import mpti.domain.member.entity.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;


@Data
@Getter
public class UserDto {
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
    public UserDto(String email, String name, String password, int age, String gender, String phone, String address, Role role, int ticket, LocalDateTime createAt, LocalDateTime updateAt) {
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
