package org.elite.mini.bean;

public class Comment {
    private Integer id;

    private Integer microblogId;

    private String detail;

    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMicroblogId() {
        return microblogId;
    }

    public void setMicroblogId(Integer microblogId) {
        this.microblogId = microblogId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}