package com.kevin.mirs.entity;

/**
 * Created by 昊 on 2016/11/7.
 */
public class UserRecommendedFriends {
    private Integer id;
    private Integer uid;
    private Integer rfid;

    public UserRecommendedFriends(Integer id, Integer uid, Integer rfid) {
        this.id = id;
        this.uid = uid;
        this.rfid = rfid;
    }

    public int getId() {
        return id;
    }

    public int getUid() {
        return uid;
    }

    public int getRfid() {
        return rfid;
    }

    @Override
    public String toString() {
        return "UserRecommendedFriends{" +
                "id=" + id +
                ", uid=" + uid +
                ", rfid=" + rfid +
                '}';
    }
}
