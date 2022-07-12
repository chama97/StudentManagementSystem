package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;
import view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
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

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
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
            refreshStudent();
        }else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (new StudentController().deleteStudent(txtId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
            refreshStudent();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        Student student= new Student(
                txtId.getText(),txtName.getText(),txtMail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText()

        );
        if (new StudentController().updateStudent(student)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated Student..").show();
            refreshStudent();
        }
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String searchId = txtSearch.getText();

        Student student= new StudentController().getStudent(searchId);
        if (student==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(student);
        }
    }

    void setData(Student s){
        txtId.setText(s.getStudent_Id());
        txtName.setText(s.getStudent_name());
        txtMail.setText(s.getEmail());
        txtContact.setText(s.getContact());
        txtAddress.setText(s.getAddress());
        txtNic.setText(s.getNic());
    }

    public void btnRefreshOnAction(ActionEvent actionEvent) throws IOException {
        refreshStudent();
    }

    public void refreshStudent() throws IOException {
        URL resource  = (getClass().getResource("../view/StudentForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFID.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
