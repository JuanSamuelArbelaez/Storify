package Controllers;

import Banco.FileManager;
import Cuentas.Cuenta;
import Persona.Cliente;
import Transaccion.Transaccion_SimpleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Account_Controller extends Controller {
    private Cuenta cuenta;
    @FXML private Text accountID;
    @FXML private Text accountType;
    @FXML private Text accountHolder;
    @FXML private Text clientID;
    @FXML private Text clientEMail;
    @FXML private TableView<Transaccion_SimpleProperty> transactions;
    @FXML private TableColumn<String, Transaccion_SimpleProperty> transactionDate;
    @FXML private TableColumn<String, Transaccion_SimpleProperty> transactionType;
    @FXML private TableColumn<String, Transaccion_SimpleProperty> transactionAmount;

    @FXML private void goToTransactions(ActionEvent event){
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Transactions_View.fxml"));
            root = loader.load();
            FileManager.writeFile(banco);
            Cliente cliente = this.cuenta.getClienteAsociado();

            Transactions_Controller transactionsController = loader.getController();
            transactionsController.setBanco();
            transactionsController.setCuenta(cuenta);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Transactions");
            stage.show();
        } catch (Exception ignored) {}
    }
    @FXML private void goBack(ActionEvent event){
        try{
            loader = new FXMLLoader(getClass().getResource("Client_View.fxml"));
            root = loader.load();
            FileManager.writeFile(banco);

            Cliente cliente = this.cuenta.getClienteAsociado();
            Client_Controller clientController = loader.getController();
            clientController.setBanco();
            clientController.setCliente(cliente);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client");
            stage.show();
        }catch (Exception ignored){}
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
        setTransactionDisplay();
    }
    private void setTransactionDisplay() {
        this.transactionType.setCellValueFactory(new PropertyValueFactory<String, Transaccion_SimpleProperty>("type"));

        this.transactionDate.setCellValueFactory(new PropertyValueFactory<String, Transaccion_SimpleProperty>("date"));

        this.transactionAmount.setCellValueFactory(new PropertyValueFactory<String, Transaccion_SimpleProperty>("amount"));
        this.transactions.getItems().clear();
        this.cuenta.getListaTransacciones().forEach((k, v) -> {
            this.transactions.getItems().add(new Transaccion_SimpleProperty(k, v.getTipo(),v.getValor()));
        });
    }
}
