package com.karthi.model;

import java.time.LocalDate;

public class Student {
    private String name;
    private Integer className;
    private Character section;
    private LocalDate dob;
    private Integer roll_no;

    public Student(String name, Integer className, Character section, LocalDate dob, Integer roll_no) {
        this.name = name;
        this.className = className;
        this.section = section;
        this.dob = dob;
        this.roll_no = roll_no;
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

    public void setRoll_no(Integer roll_no) {
        this.roll_no = roll_no;
    }

    public Integer getRoll_no() {
        return roll_no;
    }

    public boolean equals(Student student) {
        if (this == student){
            return true;
        }
        return name.equals(student.getName()) &&
                className.equals(student.getClassName()) &&
                section.equals(student.getSection()) &&
                dob.equals(student.getDob()) &&
                roll_no.equals(student.getRoll_no());
    }
}
