package com.harsh.studentcourseregistration.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName, lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String gender;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private Integer admissionYear;

    @Column(nullable = false)
    private Integer semester;

    @Column(nullable = false)
    private Double cgpa;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();
    public Student()
    {

    }

    public Student(String firstName, String lastName, String email, String phoneNumber, String department, LocalDate dateOfBirth, String gender, String rollNumber, Integer admissionYear, Integer semester, Double cgpa) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.admissionYear = admissionYear;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return """
            ----------------------------------------
            Student ID      : %d
            Name            : %s %s
            Email           : %s
            Phone Number    : %s
            Department      : %s
            Date of Birth   : %s
            Gender          : %s
            Roll Number     : %s
            Admission Year  : %d
            Semester        : %d
            CGPA            : %.2f
            ----------------------------------------
            """.formatted(
                id,
                firstName,
                lastName,
                email,
                phoneNumber,
                department,
                dateOfBirth,
                gender,
                rollNumber,
                admissionYear,
                semester,
                cgpa
        );
    }
}
