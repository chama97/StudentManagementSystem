package controller;

import db.DbConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController implements StudentService{

    @Override
    public boolean saveStudent(Student s) throws SQLException, ClassNotFoundException {
        Connection con= DbConnection.getInstance().getConnection();
        String query="INSERT INTO Student VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,s.getStudent_Id());
        stm.setObject(2,s.getStudent_name());
        stm.setObject(3,s.getEmail());
        stm.setObject(4,s.getContact());
        stm.setObject(5,s.getAddress());
        stm.setObject(6,s.getNic());
        return stm.executeUpdate()>0;
    }

    @Override
    public ArrayList<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Student");
        ResultSet rst = stm.executeQuery();
        ArrayList<Student> students = new ArrayList<>();
        while (rst.next()) {
            students.add(new Student(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return students;
    }

    @Override
    public Student getStudent(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Student WHERE student_id=?");
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Student(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        if (DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM Student WHERE student_id='"+id+"'").executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student s) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE Student SET student_name=?, email=?, contact=?, address=?, nic=?  WHERE student_id=?");
        stm.setObject(1,s.getStudent_name());
        stm.setObject(2,s.getEmail());
        stm.setObject(3,s.getEmail());
        stm.setObject(4,s.getContact());
        stm.setObject(5,s.getAddress());
        stm.setObject(6,s.getNic());
        stm.setObject(1,s.getStudent_Id());
        return stm.executeUpdate()>0;
    }
}
