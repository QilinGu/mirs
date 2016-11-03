package com.kevin.mirs.entity;


public class Friend {

    Integer id;
    Integer uid;
    Integer ufid;

    public Friend(Integer id, Integer uid, Integer ufid) {
        this.id = id;
        this.uid = uid;
        this.ufid = ufid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUfid() {
        return ufid;
    }

    public void setUfid(Integer ufid) {
        this.ufid = ufid;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", uid=" + uid +
                ", ufid=" + ufid +
                '}';
    }
}
