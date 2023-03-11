package Controllers;
import Persona.*;
import Banco.*;
import Persona.Empleado.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML
    private void goBack(ActionEvent actionEvent) {
        try{
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Home_View.fxml"));
            root = loader.load();

            Home_Controller homeController = loader.getController();
            homeController.setBanco(banco);


            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Home");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            this.clientEmployeeName.setText(em.getNombre()+" "+cliente.getEmpleadoAsociado().getApellido());
            this.clientEmployeeEMail.setText(em.getCorreo());
        }
    }
    public void setCuentas(){
    }
}
