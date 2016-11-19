package com.kevin.mirs.entity;


public class UserRecommendedMovies {
    private int id;
    private int uid;
    private int rmid;
    private float rmv;

    UserRecommendedMovies(){}
    public UserRecommendedMovies(Integer id, Integer uid, Integer rmid, Float rmv) {
        this.id = id;
        this.uid = uid;
        this.rmid = rmid;
        this.rmv = rmv;
    }

    public int getId() { return id; }

    public int getUid() {
        return uid;
    }

    public int getRmid() {
        return rmid;
    }

    public float getRmv() {
        return rmv;
    }

    @Override
    public String toString() {
        return "UserRecommendedMovies{" +
                "uid=" + uid +
                ", rmid=" + rmid +
                ", rmv=" + rmv +
                '}';
    }
}
