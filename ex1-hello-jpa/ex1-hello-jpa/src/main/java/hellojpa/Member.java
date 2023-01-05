package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    // jpa 는 동적으로 생성해내야 한다. 기본 생성자가 없으면 빨간 줄 뜬다.

    @Id
    private Long id;
    private String name;

    public Member (Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Member(){

    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
