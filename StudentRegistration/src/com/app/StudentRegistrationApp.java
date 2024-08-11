package com.app;

import com.app.dao.StudentDAO;
import com.app.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter course:");
        String course = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter mobile number:");
        String mobile = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
        student.setAge(age);
        student.setMobile(mobile);
        student.setEmail(email);

        try {
            studentDAO.addStudent(student);
            System.out.println("Student registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error registering student: " + e.getMessage());
        }

        scanner.close();
    }
}
