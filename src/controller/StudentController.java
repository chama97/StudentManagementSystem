package controller;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController implements StudentService{
    @Override
    public boolean saveStudent(Student s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Student getStudent(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateStudent(Student c) throws SQLException, ClassNotFoundException {
        return false;
    }
}
