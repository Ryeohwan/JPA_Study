package mpti.backend.domain.member.entity;

import javax.persistence.*;

@Entity
// fk 있는 주인
public class Ptlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ptlog_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String memo;

    private int core,chest, shoulder, biceps, triceps,back,legs,aerobic;
}
