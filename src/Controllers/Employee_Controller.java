package Controllers;

import Banco.*;
import Cuentas.Cuenta;
import Cuentas.CuentaAhorro;
import Cuentas.CuentaCorriente;
import Cuentas.Cuenta_SimpleProperty;
import Persona.Cliente;
import Persona.Empleado.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Employee_Controller extends Controller{
    private Empleado employee = null;
    private Cliente client = null;
    private Cuenta account = null;

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
        }catch (Exception ignored){}
    }
    @FXML void addAccount(ActionEvent event){
        try{
            Cliente cliente = banco.getCliente(this.addAcc_ID.getText());
            if(!cliente.getNombre().equals(this.addAc_Name.getText()))throw new Exception("");
            if(!cliente.getApellido().equals(this.addAc_LastName.getText())) throw new Exception("");
            switch(this.addAc_Type.getSelectionModel().getSelectedItem().toString()){
                case "Ahorros": banco.addCuenta(new CuentaAhorro(this.addAcc_Number.getText(), 0, null, cliente));
                case "Corriente": banco.addCuenta(new CuentaCorriente(this.addAcc_Number.getText(), 0, null, cliente));
            }
            FileManager.writeFile(this.banco);
            this.setEmployee(banco.obtenerEmpleado(employee.getCodigo(), employee.getCedula()));
        } catch (Exception ignored) {
        } finally {
            this.addAcc_ID.setText("");
            this.addAc_LastName.setText("");
            this.addAc_Name.setText("");
            this.addAcc_Number.setText("");
        }
    }
    @FXML void srchAccount(ActionEvent event){
        try{
            account = banco.getCuenta(this.removeAc_Number.getText());
            this.removeAC_Type.setText(account.getTipo());
            this.removeAc_Name.setText(account.getClienteAsociado().getNombre());
            this.removeAc_LastName.setText(account.getClienteAsociado().getApellido());
            this.removeAC_ID.setText(account.getClienteAsociado().getCedula());
        } catch (Exception ignored) {
            this.resetAccountEditValues();
        }
    }
    @FXML void removeAccount(ActionEvent event){
        try{
            if(account== null) throw new Exception("");
            banco.eliminarCuenta(account);

            FileManager.writeFile(this.banco);

            this.setEmployee(banco.obtenerEmpleado(employee.getCodigo(), employee.getCedula()));
        } catch (Exception ignored) {} finally {
            resetAccountEditValues();
        }
    }
    @FXML private void updateInfo(ActionEvent event) {
        try{
            String item = this.optionBox.getSelectionModel().getSelectedItem().toString();
            String info = this.infoField.getText();
            String pswd = this.passwordField.getText();

            if(this.employee.getPassword().equals(pswd)){
                switch (item) {
                    case "First Name" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),info, null, null, null, null, null, null, null);
                    case "Last Name" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),null, info, null, null, null, null, null, null);
                    case "Address" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),null, null, info, null, null, null, null, null);
                    case "Phone" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),null, null, null, info, null, null, null, null);
                    case "Email" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),null, null, null, null, info, null, null, null);
                    case "Birth Day" -> this.banco.actualizarEmpleado(employee.getCodigo(),employee.getCedula(),null, null, null, null, null, info, null, null);
                    case "ID" -> this.banco.getCliente(employee.getCodigo()).setCedula(info);
                    case "Password" -> this.banco.getEmpleado(employee.getCodigo()).setPassword(info);
                    case "Employee ID" -> this.banco.getEmpleado(employee.getCodigo()).setCodigo(info);
                    default -> throw new Exception("");
                }
            }
            FileManager.writeFile(this.banco);
            this.setEmployee(banco.obtenerEmpleado(employee.getCodigo(), employee.getCedula()));
            this.infoField.setText("");
            this.passwordField.setText("");
        } catch (Exception ignored) {
        }
    }
    public void setEmployee(Empleado manager) {
        this.employee= manager;
        setManagerInfo();
    }

    private void setManagerInfo() {
        this.empName.setText(employee.getNombre()+" "+employee.getApellido());
        this.empID.setText("Manager: "+employee.getCedula());
        this.empMail.setText(employee.getCorreo());
        this.empAdd.setText(employee.getDireccion());
        this.empCode.setText(employee.getCodigo());
        this.empBDay.setText(employee.getFechaNacimiento());
        this.empPhone.setText(employee.getTelefono());
        setClientDisplay();
        setAccountDisplay();
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

        banco.getListaCuentas().forEach((k, v) -> {this.accounts.getItems().add(new Cuenta_SimpleProperty(v));});
    }
    private void resetAccountEditValues() {
        this.removeAC_ID.setText("");
        this.removeAc_Name.setText("");
        this.removeAc_LastName.setText("");
        this.removeAC_Type.setText("");
        this.removeAc_Number.setText("");
        account=null;
    }
    @FXML
    private TableView<Cliente> clients;
    @FXML
    private TableColumn<String, Cliente> clientID;
    @FXML
    private TableColumn<String, Cliente> clientName;
    @FXML
    private TableColumn<String, Cliente> clientBDay;
    @FXML
    private TableColumn<String, Cliente> clientAdd;
    @FXML
    private TableColumn<String, Cliente> clientPhone;
    @FXML
    private TableColumn<String, Cliente> clientEmail;
    @FXML
    private TableView<Cuenta_SimpleProperty> accounts;
    @FXML
    private TableColumn<String, Cuenta_SimpleProperty> acc_PID;
    @FXML
    private TableColumn<String, Cuenta_SimpleProperty> acc_Name;
    @FXML
    private TableColumn<String, Cuenta_SimpleProperty> acc_Number;
    @FXML
    private TableColumn<String, Cuenta_SimpleProperty> acc_Type;
    @FXML
    private TableColumn<String, Cuenta_SimpleProperty> acc_Balance;
    @FXML
    private TextField addAcc_ID;
    @FXML
    private TextField addAc_Name;
    @FXML
    private TextField addAc_LastName;
    @FXML
    private ComboBox addAc_Type;
    @FXML
    private String ahorros;
    @FXML
    private String corriente;
    @FXML
    private TextField addAcc_Number;
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
    private TextField infoField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox optionBox;
    @FXML
    private String firstName;
    @FXML
    private String lastName;
    @FXML
    private String bDay;
    @FXML
    private String address1;
    @FXML
    private String phone1;
    @FXML
    private String email1;
    @FXML
    private String employeeID;
    @FXML
    private String iD;
    @FXML
    private String password;
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
}
