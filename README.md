# 🎓 Student Course Registration System

A console-based Java application built using **Hibernate ORM**, **PostgreSQL**, and **Maven** to manage students, courses, and enrollments. The project demonstrates CRUD operations, object-relational mapping (ORM), and many-to-many relationships using Hibernate.

---

## 🚀 Features

### 👨‍🎓 Student Management
- Add Student
- View Student by ID
- Update Student Details
- Delete Student
- View All Students

### 📚 Course Management
- Add Course
- View Course by ID
- Update Course Details
- Delete Course
- View All Courses

### 📝 Enrollment Management
- Enroll a Student in a Course
- Unenroll a Student from a Course
- View Courses Enrolled by a Student
- View Students Enrolled in a Course

### ✅ Additional Features
- Input Validation
- Console-based Menu System
- Hibernate ORM Integration
- PostgreSQL Database
- DAO Design Pattern
- Many-to-Many Mapping

---

## 🛠️ Tech Stack

- **Java**
- **Hibernate ORM**
- **PostgreSQL**
- **Maven**
- **JPA Annotations**

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.harsh.studentcourseregistration
│   │       ├── app
│   │       │   └── Main.java
│   │       ├── config
│   │       │   └── HibernateUtil.java
│   │       ├── dao
│   │       │   ├── StudentDAO.java
│   │       │   └── CourseDAO.java
│   │       └── entity
│   │           ├── Student.java
│   │           └── Course.java
│   └── resources
│       └── hibernate.cfg.xml
```

---

## 🗄️ Database Schema

### Student

| Field | Type |
|-------|------|
| id | Long |
| firstName | String |
| lastName | String |
| email | String |
| phoneNumber | String |
| department | String |
| dateOfBirth | LocalDate |
| gender | String |
| rollNumber | String |
| admissionYear | Integer |
| semester | Integer |
| cgpa | Double |

---

### Course

| Field | Type |
|-------|------|
| id | Long |
| courseCode | String |
| courseName | String |
| credits | Integer |
| department | String |
| semester | Integer |
| maxCapacity | Integer |
| instructor | String |
| courseFee | Double |

---

### Relationship

```
Student
    ▲
    │
Many-to-Many
    │
    ▼
Course
```

Hibernate automatically manages the join table used for student-course enrollments.

---

## ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/student-course-registration.git
```

### 2. Configure PostgreSQL

Create a PostgreSQL database:

```
student_course_db
```

Update the database credentials in:

```
hibernate.cfg.xml
```

```xml
<property name="hibernate.connection.url">
jdbc:postgresql://localhost:5432/student_course_db
</property>

<property name="hibernate.connection.username">
your_username
</property>

<property name="hibernate.connection.password">
your_password
</property>
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run

Run:

```
Main.java
```

---

## 📖 Concepts Demonstrated

- Hibernate SessionFactory
- Hibernate Session
- Transactions
- CRUD Operations
- DAO Pattern
- Entity Mapping
- Many-to-Many Relationship
- HQL Queries
- Input Validation
- Maven Dependency Management
- PostgreSQL Integration

---

## 🎯 Future Improvements

- Spring Boot Integration
- REST APIs
- Spring Data JPA
- Authentication & Authorization
- Course Capacity Validation
- Search & Filter Features
- Unit Testing with JUnit
- Logging Framework

---

## 👨‍💻 Author

**Harsh Kumar**

GitHub: https://github.com/harshsync

---

## 📄 License

This project is developed for educational purposes.