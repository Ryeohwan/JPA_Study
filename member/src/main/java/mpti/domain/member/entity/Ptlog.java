package mpti.domain.member.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
// fk 있는 주인
public class Ptlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ptlog_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String memo; // 일단 날짜랑 트레이너

    @Column(columnDefinition = "integer default 0")
    private int core,chest, shoulder, biceps, triceps,back,legs,aerobic;


    public void setUser(User user) {
        this.user = user;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setCore(int core) {
        if(core > 0) this.core = core;
    }

    public void setChest(int chest) {
        if(chest > 0) this.chest = chest;
    }

    public void setShoulder(int shoulder) {
        if(shoulder > 0) this.shoulder = shoulder;
    }

    public void setBiceps(int biceps) {
        if(biceps > 0) this.biceps = biceps;
    }

    public void setTriceps(int triceps) {
        if(triceps > 0) this.triceps = triceps;
    }

    public void setBack(int back) {
        if(back > 0) this.back = back;
    }

    public void setLegs(int legs) {
        if(legs > 0) this.legs = legs;
    }

    public void setAerobic(int aerobic) {
        if(aerobic > 0) this.aerobic = aerobic;
    }

    public Ptlog() {
    }

    @Builder
    public Ptlog(Long id, User user, String memo, int core, int chest, int shoulder, int biceps, int triceps, int back, int legs, int aerobic) {
        this.id = id;
        this.user = user;
        this.memo = memo;
        this.core = core;
        this.chest = chest;
        this.shoulder = shoulder;
        this.biceps = biceps;
        this.triceps = triceps;
        this.back = back;
        this.legs = legs;
        this.aerobic = aerobic;
    }
}
