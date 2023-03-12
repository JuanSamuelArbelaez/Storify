package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class Manager_Controller extends Controller{
    @FXML
    private TableView employees;
    @FXML
    private TableColumn employeeCode;
    @FXML
    private TableColumn employeePID;
    @FXML
    private TableColumn employeeName;
    @FXML
    private TableColumn employeeBDay;
    @FXML
    private TableColumn employeeAdd;
    @FXML
    private TableColumn employeePhone;
    @FXML
    private TableColumn employeeEmail;
    @FXML
    private TextField addEmp_Code;
    @FXML
    private TextField addEmp_PID;
    @FXML
    private TextField addEmp_FirstName;
    @FXML
    private TextField addEmp_LastName;
    @FXML
    private TextField addEmp_BDay;
    @FXML
    private TextField addEmp_ADD;
    @FXML
    private TextField addEmp_Phone;
    @FXML
    private TextField addEmp_Email;
    @FXML
    private TextField editEmp_Code;
    @FXML
    private TextField editEmp_PID;
    @FXML
    private TextField editEmp_FirstName;
    @FXML
    private TextField editEmp_LastName;
    @FXML
    private TextField editEmp_BDay;
    @FXML
    private TextField editEmp_ADD;
    @FXML
    private TextField editEmp_Phone;
    @FXML
    private TextField editEmp_Email;
    @FXML
    private TableView employees1;
    @FXML
    private TableColumn clientID;
    @FXML
    private TableColumn clientName;
    @FXML
    private TableColumn clientBDay;
    @FXML
    private TableColumn clientAdd;
    @FXML
    private TableColumn clientPhone;
    @FXML
    private TableColumn clientEmail;
    @FXML
    private TextField addCl_ID;
    @FXML
    private TextField addCl_FirstName;
    @FXML
    private TextField addCl_LastName;
    @FXML
    private TextField addCl_BDay;
    @FXML
    private TextField addCl_ADD;
    @FXML
    private TextField addCl_Phone;
    @FXML
    private TextField addCl_Email;
    @FXML
    private TextField editCl_Code;
    @FXML
    private TextField editCl_FirstName;
    @FXML
    private TextField editCl_LastName;
    @FXML
    private TextField editCl_BDay;
    @FXML
    private TextField editCl_ADD;
    @FXML
    private TextField editCl_Phone;
    @FXML
    private TextField editCl_Email;
    @FXML
    private TableView employees11;
    @FXML
    private TableColumn acc_PID;
    @FXML
    private TableColumn acc_Name;
    @FXML
    private TableColumn acc_Number;
    @FXML
    private TableColumn acc_Type;
    @FXML
    private TableColumn acc_Balance;
    @FXML
    private TextField addAcc_ID;
    @FXML
    private TextField addAc_Name;
    @FXML
    private TextField addAc_LastName;
    @FXML
    private ComboBox addAc_Type;
    @FXML
    private String address;
    @FXML
    private String phone;
    @FXML
    private String email;
    @FXML
    private TextField removeAC_ID;
    @FXML
    private TextField removeAc_Name;
    @FXML
    private TextField removeAc_LastName;
    @FXML
    private TextField removeAc_Number;
    @FXML
    private TextField removeAC_Type;
    @FXML
    private Text empName;
    @FXML
    private Text empID;
    @FXML
    private Text empAdd;
    @FXML
    private Text empPhone;
    @FXML
    private Text empMail;

    @FXML void goBack(ActionEvent event){

    }
    @FXML void addEmployee(ActionEvent event){

    }
    @FXML void saveEmployee(ActionEvent event){

    }
    @FXML void removeEmployee(ActionEvent event){

    }
    @FXML void srchEmployee(ActionEvent event){

    }
    @FXML void addClient(ActionEvent event){

    }
    @FXML void saveClient(ActionEvent event){

    }
    @FXML void removeClient(ActionEvent event){

    }
    @FXML void srchClient(ActionEvent event){

    }
    @FXML void addAccount(ActionEvent event){

    }
    @FXML void srchAccount(ActionEvent event){

    }
    @FXML void removeAccount(ActionEvent event){

    }
}
