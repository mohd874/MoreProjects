package com.me.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable{

    @Id @GeneratedValue @Column(name="id")
    private Long id;
    
    @Column(name="student_id")
    private String studentId;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(mappedBy="student")
    private Set<Course> courses = new HashSet<Course>();
    
    public Student(){
        
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;
        final Student other = (Student)obj;
        if(!this.studentId.equals(other.studentId))return false;
        
        return true;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course){
        courses.add(course);
        course.setStudent(this);
    }
}
