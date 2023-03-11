package Controllers;
import Persona.*;
import Persona.Empleado.*;
import Cuentas.*;
import Banco.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Client_Controller extends Controller{
    private Cliente cliente;
    @FXML private Text clientName;
    @FXML private Text clientID;
    @FXML private Text clientAddress;
    @FXML private Text clientPhone;
    @FXML private Text clientEMail;
    @FXML private Text clientBDate;
    @FXML private Text clientEmployeeName;
    @FXML private Text clientEmployeeEMail;
    @FXML private TableView accounts;
    @FXML private TableColumn accountNumber;
    @FXML private TableColumn accountType;
    @FXML private TableColumn accountSaldo;
    @FXML private ComboBox optionBox;
    @FXML private TextField infoField;
    @FXML private PasswordField passwordField;

    @FXML private void goBack(ActionEvent actionEvent) {
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Home_View.fxml"));
            root = loader.load();

            FileManager.writeFile(banco);
            Home_Controller homeController = loader.getController();
            homeController.setBanco();


            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Home");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML private void showAccount(ActionEvent event){
        try{
            Cuenta_SimpleProperty cuentaAux = (Cuenta_SimpleProperty) this.accounts.getSelectionModel().getSelectedItem();
            if(cuentaAux == null)throw new Exception("");

            Cuenta cuenta = this.cliente.getListaCuentasCliente().get(cuentaAux.getNumeroCuenta());

            loader = new FXMLLoader(getClass().getResource("Account_View.fxml"));
            root = loader.load();
            FileManager.writeFile(banco);
            Account_Controller accountController = loader.getController();
            accountController.setBanco();
            accountController.setCuenta(cuenta);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Account");
            stage.show();
        } catch (Exception e) {
        }
    }
    @FXML private void updateInfo(ActionEvent event) {
        try{
            String item = this.optionBox.getSelectionModel().getSelectedItem().toString();
            String info = this.infoField.getText();
            String pswd = this.passwordField.getText();

            if(this.cliente.getPassword().equals(pswd)){
                switch(item) {
                    case "Address":
                        this.banco.obtenerCliente(this.cliente.getCedula()).setDireccion(info);
                        break;

                    case "Phone":
                        this.banco.obtenerCliente(this.cliente.getCedula()).setTelefono(info);
                        break;

                    case "Email":
                        this.banco.obtenerCliente(this.cliente.getCedula()).setCorreo(info);
                        break;
                }
            }
            setCliente(this.banco.obtenerCliente(this.cliente.getCedula()));
            this.infoField.setText("");
            this.passwordField.setText("");
            setInfo();
        } catch (Exception e) {
        }

    }
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        setInfo();
        setCuentas();
    }
    public void setInfo(){
        this.clientName.setText(cliente.getNombre()+" "+cliente.getApellido());
        this.clientID.setText(cliente.getCedula());
        this.clientAddress.setText(cliente.getDireccion());
        this.clientPhone.setText(cliente.getTelefono());
        this.clientEMail.setText(cliente.getCorreo());
        this.clientBDate.setText(cliente.getFechaNacimiento());
        if(cliente.getEmpleadoAsociado() != null){
            Empleado em= cliente.getEmpleadoAsociado();
            this.clientEmployeeName.setText("Linked Employee: "+em.getNombre());
            this.clientEmployeeEMail.setText(em.getCorreo());
        }else {
            this.clientEmployeeName.setText("No Linked Employee");
            this.clientEmployeeEMail.setText("");
        }
    }
    public void setCuentas() {
        this.accountNumber.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("numeroCuenta"));

        this.accountType.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("tipo"));

        this.accountSaldo.setCellValueFactory(new PropertyValueFactory<String, Cuenta_SimpleProperty>("saldo"));
        setLista();
    }

    private void setLista() {
        this.accounts.getItems().clear();
        this.cliente.getListaCuentasCliente().forEach((k, v) -> {
            this.accounts.getItems().add(new Cuenta_SimpleProperty(k,v.getSaldo(), v.getTipo()));
        });
    }
}
