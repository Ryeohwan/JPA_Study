package mpti.domain.member.api.response;

import mpti.domain.member.entity.User;

public class PtlogResponse {
    private String memo;
    private User user;

    private int core,chest, shoulder, biceps, triceps,back,legs,aerobic;

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public void setBiceps(int biceps) {
        this.biceps = biceps;
    }

    public void setTriceps(int triceps) {
        this.triceps = triceps;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setAerobic(int aerobic) {
        this.aerobic = aerobic;
    }
}
