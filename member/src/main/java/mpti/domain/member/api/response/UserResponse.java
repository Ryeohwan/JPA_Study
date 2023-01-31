package mpti.domain.member.api.response;


import lombok.Builder;
import lombok.Getter;
import mpti.domain.member.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class UserResponse {
    // 회원가입했을 때 담아서 갈 response
    UUID id;
    String name;
    String email;
    int age;
    String gender;
    String phone;
    String address;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    public UserResponse() {
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
