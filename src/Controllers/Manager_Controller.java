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

import java.util.HashMap;
import java.util.HashSet;

public class Manager_Controller extends Controller{
    private Empleado employee = null;
    private Empleado manager = null;
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
    @FXML
    void addEmployee(ActionEvent event){
        try{
            if(this.addEmp_ADD.getText().equals(""))throw new Exception("");
            if(this.addEmp_BDay.getText().equals(""))throw new Exception("");
            if(this.addEmp_Code.getText().equals(""))throw new Exception("");
            if(this.addEmp_Email.getText().equals(""))throw new Exception("");
            if(this.addEmp_FirstName.getText().equals(""))throw new Exception("");
            if(this.addEmp_Phone.getText().equals(""))throw new Exception("");
            if(this.addEmp_PID.getText().equals(""))throw new Exception("");
            if(this.addEmp_LastName.getText().equals(""))throw new Exception("");

            banco.crearEmpleado(
                    this.addEmp_FirstName.getText(),
                    this.addEmp_LastName.getText(),
                    this.addEmp_PID.getText(),
                    this.addEmp_ADD.getText(),
                    this.addEmp_Phone.getText(),
                    this.addEmp_Email.getText(),
                    this.addEmp_BDay.getText(),
                    this.addEmp_Code.getText(),
                    4000000);

            banco.getEmpleado(this.addEmp_Code.getText()).setManager(this.addEmp_Man.isSelected());

            FileManager.writeFile(this.banco);

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        } catch (Exception ignored) {}
        finally {
            this.addEmp_FirstName.setText("");
            this.addEmp_LastName.setText("");
            this.addEmp_PID.setText("");
            this.addEmp_ADD.setText("");
            this.addEmp_Phone.setText("");
            this.addEmp_Email.setText("");
            this.addEmp_BDay.setText("");
            this.addEmp_Code.setText("");
            this.addEmp_Man.setSelected(false);
        }
    }
    @FXML void saveEmployee(ActionEvent event){
        try{
            if(employee==null)throw new Exception("");
            banco.actualizarEmpleado(
                    employee.getCodigo(),
                    employee.getCedula(),
                    this.editEmp_FirstName.getText(),
                    this.editEmp_LastName.getText(),
                    this.editEmp_ADD.getText(),
                    this.editEmp_Phone.getText(),
                    this.editEmp_Email.getText(),
                    this.editCl_BDay.getText(),
                    this.employee.getSalario(),
                    this.employee.getClientes());
            banco.obtenerEmpleado(employee.getCodigo(), employee.getCedula()).setManager(this.editEmp_Man.isSelected());

            FileManager.writeFile(this.banco);

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        }catch(Exception ignored){}
        finally {
            this.editEmp_FirstName.setText("");
            this.editEmp_LastName.setText("");
            this.editEmp_PID.setText("");
            this.editEmp_ADD.setText("");
            this.editEmp_Phone.setText("");
            this.editEmp_Email.setText("");
            this.editEmp_BDay.setText("");
            this.editEmp_Code.setText("");
            this.editEmp_Man.setSelected(false);
        }
    }
    @FXML void removeEmployee(ActionEvent event){
        try{
            if(employee== null) throw new Exception("");
            banco.eliminarEmpleado(employee.getCodigo(), employee.getCedula());

            FileManager.writeFile(this.banco);

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        } catch (Exception ignored) {} finally {
            resetEmployeeEditValues();
        }
    }
    @FXML void srchEmployee(ActionEvent event){
        try {
            if(manager.getCodigo().equals(this.editEmp_Code.getText())) throw new Exception("");
            this.employee = banco.obtenerEmpleado(this.editEmp_Code.getText(), this.editEmp_PID.getText());
            this.editEmp_FirstName.setText(employee.getNombre());
            this.editEmp_LastName.setText(employee.getApellido());
            this.editEmp_BDay.setText(employee.getFechaNacimiento());
            this.editEmp_ADD.setText(employee.getDireccion());
            this.editEmp_Phone.setText(employee.getTelefono());
            this.editEmp_Email.setText(employee.getCorreo());
            this.editEmp_Man.setSelected(employee.isManager());
        }catch (Exception ignored){resetClientEditValues();
        }
    }
    @FXML void addClient(ActionEvent event){
        try{
            if(this.addCl_ADD.getText().equals(""))throw new Exception("");
            if(this.addCl_BDay.getText().equals(""))throw new Exception("");
            if(this.addCl_Email.getText().equals(""))throw new Exception("");
            if(this.addCl_FirstName.getText().equals(""))throw new Exception("");
            if(this.addCl_Phone.getText().equals(""))throw new Exception("");
            if(this.addCl_ID.getText().equals(""))throw new Exception("");
            if(this.addCl_LastName.getText().equals(""))throw new Exception("");
            if(this.addCl_EmpCode.getText().equals(""))throw new Exception("");

            banco.crearCliente(
                    this.addCl_FirstName.getText(),
                    this.addCl_LastName.getText(),
                    this.addCl_ID.getText(),
                    this.addCl_ADD.getText(),
                    this.addCl_Phone.getText(),
                    this.addCl_Email.getText(),
                    this.addCl_BDay.getText(),
                    banco.getEmpleado(this.addCl_EmpCode.getText()));

            FileManager.writeFile(this.banco);
            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        } catch (Exception ignored) {}
        finally {
            this.addCl_FirstName.setText("");
            this.addCl_LastName.setText("");
            this.addCl_ID.setText("");
            this.addCl_ADD.setText("");
            this.addCl_Phone.setText("");
            this.addCl_Email.setText("");
            this.addCl_BDay.setText("");
            this.addCl_EmpCode.setText("");
        }
    }
    @FXML void saveClient(ActionEvent event){
        try{
            if(client==null)throw new Exception("");
            HashSet<Cliente> auxH = banco.getEmpleado(this.editCl_EmpCode.getText()).getClientes();
            if(!auxH.contains(client)) {
                auxH.add(client);
                banco.getEmpleado(this.editCl_Code.getText()).setClientes(auxH);
            }
            banco.actualizarCliente(
                    client.getCedula(),
                    this.editCl_FirstName.getText(),
                    this.editCl_LastName.getText(),
                    this.editCl_ADD.getText(),
                    this.editCl_Phone.getText(),
                    this.editCl_Email.getText(),
                    this.editCl_BDay.getText(),
                    this.banco.getEmpleado(this.editCl_EmpCode.getText()));


            banco.getEmpleado(this.editCl_Code.getText()).getClientes().add(banco.getCliente(client.getCedula()));
            FileManager.writeFile(this.banco);

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        }catch(Exception ignored){}
        finally {
            this.editCl_FirstName.setText("");
            this.editCl_LastName.setText("");
            this.editCl_Code.setText("");
            this.editCl_ADD.setText("");
            this.editCl_Phone.setText("");
            this.editCl_Email.setText("");
            this.editCl_BDay.setText("");
        }
    }
    @FXML void removeClient(ActionEvent event){
        try{
            if(client== null) throw new Exception("");
            banco.eliminarCliente(client.getCedula());

            FileManager.writeFile(this.banco);

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        } catch (Exception ignored) {} finally {
            resetClientEditValues();
        }
    }
    @FXML void srchClient(ActionEvent event){
        try {
            this.client = banco.obtenerCliente(this.editCl_Code.getText());
            this.editCl_FirstName.setText(client.getNombre());
            this.editCl_LastName.setText(client.getApellido());
            this.editCl_BDay.setText(client.getFechaNacimiento());
            this.editCl_ADD.setText(client.getDireccion());
            this.editCl_Phone.setText(client.getTelefono());
            this.editCl_Email.setText(client.getCorreo());
            this.editCl_EmpCode.setText("Linked employee code: "+client.getEmpleadoAsociado().getCodigo());
        }catch (Exception ignored){
            resetClientEditValues();
        }
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
            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
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

            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
        } catch (Exception ignored) {} finally {
            resetAccountEditValues();
        }
    }
    @FXML private void updateInfo(ActionEvent event) {
        try{
            String item = this.optionBox.getSelectionModel().getSelectedItem().toString();
            String info = this.infoField.getText();
            String pswd = this.passwordField.getText();

            if(this.manager.getPassword().equals(pswd)){
                switch (item) {
                    case "First Name" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),info, null, null, null, null, null, null, null);
                    case "Last Name" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),null, info, null, null, null, null, null, null);
                    case "Address" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),null, null, info, null, null, null, null, null);
                    case "Phone" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),null, null, null, info, null, null, null, null);
                    case "Email" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),null, null, null, null, info, null, null, null);
                    case "Birth Day" -> this.banco.actualizarEmpleado(manager.getCodigo(),manager.getCedula(),null, null, null, null, null, info, null, null);
                    case "ID" -> this.banco.getCliente(manager.getCodigo()).setCedula(info);
                    case "Password" -> this.banco.getEmpleado(manager.getCodigo()).setPassword(info);
                    case "Employee ID" -> this.banco.getEmpleado(manager.getCodigo()).setCodigo(info);
                    default -> throw new Exception("");
                }
            }
            FileManager.writeFile(this.banco);
            this.setManager(banco.obtenerEmpleado(manager.getCodigo(), manager.getCedula()));
            this.infoField.setText("");
            this.passwordField.setText("");
        } catch (Exception ignored) {

        }

    }
    public void setManager(Empleado manager) {
        this.manager = manager;
        setManagerInfo();
    }

    private void setManagerInfo() {
        this.empName.setText(manager.getNombre()+" "+manager.getApellido());
        this.empID.setText("Manager: "+manager.getCedula());
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

        this.employeeManager.setCellValueFactory(new PropertyValueFactory<String, Empleado>("manager"));

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
        this.clientEmployee.setCellValueFactory(new PropertyValueFactory<>("employee"));

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

    private void resetEmployeeEditValues() {
        this.editEmp_Code.setText("");
        this.editEmp_PID.setText("");
        this.editEmp_FirstName.setText("");
        this.editEmp_LastName.setText("");
        this.editEmp_BDay.setText("");
        this.editEmp_ADD.setText("");
        this.editEmp_Phone.setText("");
        this.editEmp_Email.setText("");
        this.editEmp_Man.setSelected(false);
        employee=null;
    }
    private void resetClientEditValues() {
        this.editCl_Code.setText("");
        this.editCl_FirstName.setText("");
        this.editCl_LastName.setText("");
        this.editCl_BDay.setText("");
        this.editCl_ADD.setText("");
        this.editCl_Phone.setText("");
        this.editCl_Email.setText("");
        client=null;
    }
    private void resetAccountEditValues() {
        this.removeAC_ID.setText("");
        this.removeAc_Name.setText("");
        this.removeAc_LastName.setText("");
        this.removeAC_Type.setText("");
        this.removeAc_Number.setText("");
        account=null;
    }
    @FXML private TextField addCl_EmpCode;
    @FXML private TextField editCl_EmpCode;
    @FXML private ComboBox optionBox;
    @FXML private TextField infoField;
    @FXML private PasswordField passwordField;
    @FXML private TextField addAcc_Number;
    @FXML private TableView<Empleado> employees;
    @FXML private TableColumn<String, Empleado> employeeCode;
    @FXML private TableColumn<String, Empleado> employeePID;
    @FXML private TableColumn<String, Empleado> employeeManager;
    @FXML private TableColumn<String, Empleado> employeeName;
    @FXML private TableColumn<String, Empleado> employeeBDay;
    @FXML private TableColumn<String, Empleado> employeeAdd;
    @FXML private TableColumn<String, Empleado> employeePhone;
    @FXML private TableColumn<String, Empleado> employeeEmail;
    @FXML private TextField addEmp_Code;
    @FXML private TextField addEmp_PID;
    @FXML private TextField addEmp_FirstName;
    @FXML private TextField addEmp_LastName;
    @FXML private TextField addEmp_BDay;
    @FXML private TextField addEmp_ADD;
    @FXML private TextField addEmp_Phone;
    @FXML private TextField addEmp_Email;
    @FXML private TextField editEmp_Code;
    @FXML private TextField editEmp_PID;
    @FXML private TextField editEmp_FirstName;
    @FXML private TextField editEmp_LastName;
    @FXML private TextField editEmp_BDay;
    @FXML private TextField editEmp_ADD;
    @FXML private TextField editEmp_Phone;
    @FXML private TextField editEmp_Email;
    @FXML private TableView<Cliente> clients;
    @FXML private TableColumn<String, Cliente> clientEmployee;
    @FXML private TableColumn<String, Cliente> clientID;
    @FXML private TableColumn<String, Cliente> clientName;
    @FXML private TableColumn<String, Cliente> clientBDay;
    @FXML private TableColumn<String, Cliente> clientAdd;
    @FXML private TableColumn<String, Cliente> clientPhone;
    @FXML private TableColumn<String, Cliente> clientEmail;
    @FXML private TextField addCl_ID;
    @FXML private TextField addCl_FirstName;
    @FXML private TextField addCl_LastName;
    @FXML private TextField addCl_BDay;
    @FXML private TextField addCl_ADD;
    @FXML private TextField addCl_Phone;
    @FXML private TextField addCl_Email;
    @FXML private TextField editCl_Code;
    @FXML private TextField editCl_FirstName;
    @FXML private TextField editCl_LastName;
    @FXML private TextField editCl_BDay;
    @FXML private TextField editCl_ADD;
    @FXML private TextField editCl_Phone;
    @FXML private TextField editCl_Email;
    @FXML private TableView<Cuenta_SimpleProperty> accounts;
    @FXML private TableColumn<String, Cuenta_SimpleProperty> acc_PID;
    @FXML private TableColumn<String, Cuenta_SimpleProperty> acc_Name;
    @FXML private TableColumn<String, Cuenta_SimpleProperty> acc_Number;
    @FXML private TableColumn<String, Cuenta_SimpleProperty> acc_Type;
    @FXML private TableColumn<String, Cuenta_SimpleProperty> acc_Balance;
    @FXML private TextField addAcc_ID;
    @FXML private TextField addAc_Name;
    @FXML private TextField addAc_LastName;
    @FXML private ComboBox addAc_Type;
    @FXML private TextField removeAC_ID;
    @FXML private TextField removeAc_Name;
    @FXML private TextField removeAc_LastName;
    @FXML private TextField removeAc_Number;
    @FXML private TextField removeAC_Type;
    @FXML private Text empName;
    @FXML private Text empID;
    @FXML private Text empAdd;
    @FXML private Text empPhone;
    @FXML private Text empMail;
    @FXML private Text empBDay;
    @FXML private Text empCode;
    @FXML private CheckBox addEmp_Man;
    @FXML private CheckBox editEmp_Man;
}
