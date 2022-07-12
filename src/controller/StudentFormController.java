package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentFormController {
    public AnchorPane studentFID;
    public JFXTextField txtId;
    public JFXTextField txtMail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public JFXTextField txtSearch;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colMail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize() {
        try {
            colId.setCellValueFactory(new PropertyValueFactory<>("student_Id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
            colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

            setStudentsToTable(new StudentController().getAllStudents());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setStudentsToTable(ArrayList<Student> customers) {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(
                    new StudentTM(e.getStudent_Id(),e.getStudent_name(),e.getEmail(),e.getContact(),e.getAddress(),e.getNic()));
        });
        tblStudent.setItems(obList);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Student student = new Student(
                txtId.getText(),
                txtName.getText(),
                txtMail.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtNic.getText()
        );
        if(new StudentController().saveStudent(student)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        }else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }
}
