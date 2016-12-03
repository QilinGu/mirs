package com.kevin.mirs.vo;


import java.sql.Timestamp;

public class UserProfile {

    private Integer id;
    private String username;
    private String email;
    private String bio;
    private String location;
    private String university;
    private String major;

    public UserProfile() {
    }

    public UserProfile(Integer id, String username, String email, String bio, String location, String university, String major) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.location = location;
        this.university = university;
        this.major = major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
