package com.app.dao;

import com.app.model.Student;
import com.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, course, age, mobile, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getCourse());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getMobile());
            stmt.setString(5, student.getEmail());
            stmt.executeUpdate();
        }
    }
}
