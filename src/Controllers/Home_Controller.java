package Controllers;

import Banco.*;
import Persona.Cliente;
import Persona.Empleado.Empleado;
import Persona.Empleado.Gerente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Home_Controller extends Controller {
    @FXML TextField client_ID_Field;
    @FXML TextField emp_ID_Field;
    @FXML PasswordField client_Password_Field;
    @FXML private PasswordField emp_Code_Field;
    @FXML private PasswordField emp_Password_Field;
    @FXML
    public void loginCliente(ActionEvent event) {
        try {
            loader = new FXMLLoader(getClass().getResource("Client_View.fxml"));
            root = loader.load();
            FileManager.writeFile(banco);

            Cliente cliente = banco.obtenerCliente(client_ID_Field.getText());
            if (!cliente.getPassword().equals(client_Password_Field.getText())) throw new Exception("");

            Client_Controller clientController = loader.getController();
            clientController.setBanco();
            clientController.setCliente(cliente);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Client");
            stage.show();
        } catch (Exception e) {
            this.client_ID_Field.setText("");
            this.client_Password_Field.setText("");
        }
    }
    @FXML public void loginEmpleado(ActionEvent actionEvent) {
        try {
            Empleado empleado = banco.obtenerEmpleado(emp_Code_Field.getText(), emp_ID_Field.getText());
            if(!empleado.getPassword().equals(emp_Password_Field.getText()))throw new Exception("");
            FileManager.writeFile(banco);
            if(empleado.isManager()){
                loader = new FXMLLoader(getClass().getResource("Manager_View.fxml"));
                root = loader.load();

                Manager_Controller managerController = loader.getController();
                managerController.setBanco();
                managerController.setManager(empleado);
            }
            else {
                loader = new FXMLLoader(getClass().getResource("Employee_View.fxml"));
                root = loader.load();

                Employee_Controller employeeController = loader.getController();
                employeeController.setBanco();
                employeeController.setEmployee(empleado);
            }


            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Employee");
            stage.show();

        } catch (Exception e) {
            this.emp_Code_Field.setText("");
            this.emp_ID_Field.setText("");
            this.emp_Password_Field.setText("");
        }
    }
}
