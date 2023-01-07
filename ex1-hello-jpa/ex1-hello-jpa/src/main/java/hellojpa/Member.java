package hellojpa;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name")  // db 컬럼명은 name으로 들어가는 것
    private String username;


    private Integer age;
    @Enumerated(EnumType.STRING)  // 자바 enum타입 근데 db는 enum이 없다.
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)  // 날짜 타입
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob  // varchar 넘는 큰 값이 오면 (문자면 clob )
    private String description;

    public Member(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }
}