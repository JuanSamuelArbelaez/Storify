package Controllers;

import Banco.FileManager;
import Cuentas.Cuenta;
import Persona.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Account_Controller extends Controller {
    private Cuenta cuenta;
    @FXML
    private Text accountID;
    @FXML
    private Text clientName;
    @FXML
    private Text clientAddress;
    @FXML
    private Text clientPhone;
    @FXML
    private Text clientEMail;
    @FXML
    private Text clientBDate;
    @FXML
    private Text clientEmployeeName;
    @FXML
    private Text clientEmployeeEMail;
    @FXML
    private TableView accounts1;
    @FXML
    private TableColumn accountNumber1;
    @FXML
    private TableColumn accountType1;

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
        } catch (Exception e) {
        }
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
