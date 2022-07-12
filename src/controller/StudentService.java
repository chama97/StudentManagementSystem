package controller;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentService {
    boolean saveStudent(Student s) throws SQLException, ClassNotFoundException;
    ArrayList<Student> getAllStudents() throws SQLException, ClassNotFoundException;
    Student getStudent(String id) throws SQLException, ClassNotFoundException;
    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
    boolean updateStudent(Student c) throws SQLException, ClassNotFoundException;
}
