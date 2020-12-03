package com.karthi.model;

import java.time.LocalDate;

public class Student {
    private String name;
    private Integer className;
    private Character section;
    private LocalDate dob;
    private Integer rollNo;

    public Student(String name, Integer className, Character section, LocalDate dob, Integer rollNo) {
        this.name = name;
        this.className = className;
        this.section = section;
        this.dob = dob;
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setClassName(Integer className) {
        this.className = className;
    }

    public Integer getClassName() {
        return className;
    }

    public void setSection(Character section) {
        this.section = section;
    }

    public Character getSection() {
        return section;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public boolean equals(Student student) {
        if (this == student){
            return true;
        }
        return name.equals(student.getName()) &&
                className.equals(student.getClassName()) &&
                section.equals(student.getSection()) &&
                dob.equals(student.getDob()) &&
                rollNo.equals(student.getRollNo());
    }
}
