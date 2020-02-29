package com.lbhz.core.bean.auto;

public class StudentName {
    private String id;

    private String name;

    private String club;

    private String major;

    public StudentName(String id, String name, String club, String major) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.major = major;
    }

    public StudentName() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club == null ? null : club.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }
}