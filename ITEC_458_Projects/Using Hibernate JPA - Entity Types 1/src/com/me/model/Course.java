package com.me.model;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {

    @Id @GeneratedValue @Column(name="course_id")
    private Long id;
    
    @Column(name="code", nullable=false)
    private String code;
    
    @Column(name="title")
    private String title;
    
    @ManyToOne
    @JoinColumn(name="id")
    private Student student;

    public Course() {
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
    
    @Override
    public int hashCode() {
        return getCode().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;
        final Course other = (Course)obj;
        if(!this.code.equals(other.code))return false;
        
        return true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
