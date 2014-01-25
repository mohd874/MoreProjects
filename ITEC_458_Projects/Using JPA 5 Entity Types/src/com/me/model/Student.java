package com.me.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="students")
public class Student implements Serializable{

    @Id @GeneratedValue @Column(name="id")
    private Long id;
    
    @Column(name="student_id")
    private String studentId;
    
    @Column(name="name")
    private String name;
    
    @org.hibernate.annotations.CollectionOfElements
    @JoinTable(
        name="student_course",
        joinColumns=@JoinColumn(name="id")
    )
    private Set<StudentCourse> studentCourses = new HashSet<StudentCourse>();

    public Student() {
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    
    @Override
    public int hashCode(){
        return studentId.hashCode();
    }
    
    
}
