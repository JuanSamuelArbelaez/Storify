package Controllers;

import Banco.FileManager;
import Persona.*;
import Persona.Empleado.*;
import Cuentas.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Manager_Controller extends Controller{
    private Empleado employee;
    private Empleado manager;
    private Cliente client;
    private Cuenta account;

    @FXML
    void goBack(ActionEvent event){
        try{
            loader = new FXMLLoader(getClass().getResource("Home_View.fxml"));
            root = loader.load();
            FileManager.writeFile(banco);

            Home_Controller homeController = loader.getController();
            homeController.setBanco();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Home");
            stage.show();
        }catch (Exception e){}
    }
    @FXML
    void addEmployee(ActionEvent event){

    }
    @FXML
    void saveEmployee(ActionEvent event){

    }
    @FXML
    void removeEmployee(ActionEvent event){

    }
    @FXML
    void srchEmployee(ActionEvent event){

    }
    @FXML
    void addClient(ActionEvent event){

    }
    @FXML
    void saveClient(ActionEvent event){

    }
    @FXML
    void removeClient(ActionEvent event){

    }
    @FXML
    void srchClient(ActionEvent event){

    }
    @FXML
    void addAccount(ActionEvent event){

    }
    @FXML
    void srchAccount(ActionEvent event){

    }
    @FXML
    void removeAccount(ActionEvent event){

    }
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
    private TableView clients;
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
    private TableView accounts;
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
    @FXML
    private Text empBDay;
    @FXML
    private Text empCode;
    public void setManager(Empleado manager) {
        this.manager = manager;
        setManagerInfo();
    }

    private void setManagerInfo() {
        this.empName.setText(manager.getNombre()+" "+manager.getApellido());
        this.empID.setText(manager.getCedula());
        this.empMail.setText(manager.getCorreo());
        this.empAdd.setText(manager.getDireccion());
        this.empCode.setText(manager.getCodigo());
        this.empBDay.setText(manager.getFechaNacimiento());
        this.empPhone.setText(manager.getTelefono());
        setEmployeeDisplay();
        setClientDisplay();
        setAccountDisplay();
    }
    private void setEmployeeDisplay() {
        this.employeeCode.setCellValueFactory(new PropertyValueFactory<String, Empleado>("codigo"));

        this.employeeName.setCellValueFactory(new PropertyValueFactory<String, Empleado>("nombreCompleto"));

        this.employeeAdd.setCellValueFactory(new PropertyValueFactory<String, Empleado>("direccion"));

        this.employeePID.setCellValueFactory(new PropertyValueFactory<String, Empleado>("cedula"));

        this.employeeBDay.setCellValueFactory(new PropertyValueFactory<String, Empleado>("fechaNacimiento"));

        this.employeeEmail.setCellValueFactory(new PropertyValueFactory<String, Empleado>("correo"));

        this.employeePhone.setCellValueFactory(new PropertyValueFactory<String, Empleado>("telefono"));
        employees.getItems().clear();
        for(Empleado empleado:this.banco.getListaEmpleados()){
            this.employees.getItems().add(empleado);
        }
    }
    private void setClientDisplay() {
        this.clientID.setCellValueFactory(new PropertyValueFactory<String, Cliente>("cedula"));

        this.clientName.setCellValueFactory(new PropertyValueFactory<String, Cliente>("nombreCompleto"));

        this.clientAdd.setCellValueFactory(new PropertyValueFactory<String, Cliente>("direccion"));

        this.clientEmail.setCellValueFactory(new PropertyValueFactory<String, Cliente>("correo"));

        this.clientBDay.setCellValueFactory(new PropertyValueFactory<String, Cliente>("fechaNacimiento"));

        this.clientPhone.setCellValueFactory(new PropertyValueFactory<String, Cliente>("telefono"));
        clients.getItems().clear();
        for(Cliente cliente:this.banco.getListaClientes()){
            this.clients.getItems().add(cliente);
        }
    }
    private void setAccountDisplay() {
        this.acc_Balance.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("saldo"));

        this.acc_Name.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("nombre"));

        this.acc_Number.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("numeroCuenta"));

        this.acc_PID.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("id"));

        this.acc_Type.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("tipo"));

        this.accounts.getItems().clear();

        this.banco.getListaCuentas().forEach((k, v) -> {
            this.accounts.getItems().add(new Cuenta_SimpleProperty(v));
        });
    }
}
