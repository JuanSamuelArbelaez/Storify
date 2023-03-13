package Controllers;
import Banco.FileManager;
import Cuentas.Cuenta;
import Persona.Cliente;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.fxml.*;
import javafx.stage.Stage;

public class Transactions_Controller extends Controller {
    private Cuenta cuenta;
    @FXML
    private Text accountID;
    @FXML
    private Text accountType;
    @FXML
    private Text accountHolder;
    @FXML
    private Text clientID;
    @FXML
    private Text clientEMail;
    @FXML
    private TextField amountField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox optionBox;
    @FXML
    private String withdraw;
    @FXML
    private String deposit;

    @FXML
    private void goBack(ActionEvent actionEvent) {
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Account_View.fxml"));
            root = loader.load();

            FileManager.writeFile(banco);
            Account_Controller accountController = loader.getController();
            accountController.setBanco();
            accountController.setCuenta(cuenta);

            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Account");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void createTransaction(ActionEvent event) {
        try {
            String item = this.optionBox.getSelectionModel().getSelectedItem().toString();
            String amount = this.amountField.getText();
            String pswd = this.passwordField.getText();
            Cliente cliente = this.cuenta.getClienteAsociado();
            if (cliente.getPassword().equals(pswd)) {
                switch (item) {
                    case "Withdraw" ->
                            this.banco.realizarRetiroCuenta(Double.parseDouble(amount), cuenta.getNumeroCuenta());
                    case "Deposit" ->
                            this.banco.depositarDineroCuenta(Double.parseDouble(amount), cuenta.getNumeroCuenta());
                    default -> throw new Exception("");
                }
            }
            this.cuenta = banco.getCuenta(cuenta.getNumeroCuenta());
            goBack(event);
        } catch (Exception e) {
            this.amountField.setText("");
            this.passwordField.setText("");
        }
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        setInfo();
    }
    public void setInfo(){
        this.accountID.setText(this.cuenta.getNumeroCuenta());
        this.accountType.setText(this.cuenta.getTipo());
        this.accountHolder.setText(this.cuenta.getClienteAsociado().getNombre());
        this.clientID.setText(this.cuenta.getClienteAsociado().getCedula());
        this.clientEMail.setText(this.cuenta.getClienteAsociado().getCorreo());
    }
}
