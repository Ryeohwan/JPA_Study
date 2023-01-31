package mpti.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Ptlog ptlog = new Ptlog();

    @Column(unique = true)
    private String email;

    private Role role;
    @JsonIgnore
    // 하면 이거 json 으로 파싱할 때 비밀번호 정보는 주지 않는다고 한다.
    @Column(nullable = false)
    private String password;
    private int age;
    private String gender;
    private String phone;
    private String address;
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public User() {
    }


    public void setEmail(String email) {
        if(email != null) this.email = email;
    }

    public void setName(String name) {
        if(name != null) this.name = name;
    }
    public void setPassword(String password) {
        if(password != null) this.password = password;
    }

    public void setAge(int age) {
        if(age != 0) this.age = age;
    }

    public void setGender(String gender) {
        if(gender != null)this.gender = gender;
    }

    public void setPhone(String phone) {
        if(phone != null) this.phone = phone;
    }

    public void setAddress(String address) {
        if(address != null) this.address = address;
    }

    public void setCreateAt(LocalDateTime createAt) {
        if(createAt != null) this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        if(updateAt != null) this.updateAt = updateAt;
    }

    public void setPtlog(Ptlog ptlog) {
        if(ptlog != null){
            this.ptlog = ptlog;
        }
    }


    @Builder
    public User(UUID id, String name, Ptlog ptlog, String email, Role role, String password, int age, String gender, String phone, String address, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.ptlog = ptlog;
        this.email = email;
        this.role = role;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }


}
