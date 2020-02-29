package com.lbhz.core.bean.auto;

public class RecordBean {
    private Integer id;

    private String studentId;

    private String screenshot;

    private Integer timeLenth;

    private Integer weekNum;

    public RecordBean(Integer id, String studentId, String screenshot, Integer timeLenth, Integer weekNum) {
        this.id = id;
        this.studentId = studentId;
        this.screenshot = screenshot;
        this.timeLenth = timeLenth;
        this.weekNum = weekNum;
    }

    public RecordBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot == null ? null : screenshot.trim();
    }

    public Integer getTimeLenth() {
        return timeLenth;
    }

    public void setTimeLenth(Integer timeLenth) {
        this.timeLenth = timeLenth;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }
}