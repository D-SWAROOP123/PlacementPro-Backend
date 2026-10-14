
package com.placementpro.placementprobackend.model;

public class StudentProfileResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String studentId;
    private String course;

    public StudentProfileResponse(
            Long id,
            String name,
            String email,
            String phone,
            String studentId,
            String course) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentId = studentId;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }
}
