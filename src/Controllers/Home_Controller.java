package Controllers;

import Banco.*;
import Persona.*;
import Persona.Empleado.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Home_Controller {
    private static Banco banco = new Banco();
    @FXML private TextField client_ID_Field;
    @FXML private TextField emp_ID_Field;
    @FXML private PasswordField client_Password_Field;
    @FXML private PasswordField emp_Code_Field;
    @FXML private PasswordField emp_Password_Field;
    @FXML public void loginCliente(ActionEvent actionEvent) {
        client_ID_Field.getText();
        try {
            Cliente cliente = banco.obtenerCliente(client_ID_Field.getText());
            if(cliente.getPassword().equals(client_Password_Field.getText())) throw new Exception("");
                //ClientView
        } catch (Exception e) {
            this.client_ID_Field.setText("ID");
            this.client_Password_Field.setText("Password");
        }
    }
    @FXML public void loginEmpleado(ActionEvent actionEvent) {
        client_ID_Field.getText();
        try {
            Empleado empleado = banco.obtenerEmpleado(emp_Code_Field.getText(), emp_ID_Field.getText());
            if(!empleado.getPassword().equals(emp_Password_Field.getText()))throw new Exception("");
            if(empleado.isManager()){
                //ManagerView
            }
            else{
                //EmpleyeeView
            }

        } catch (Exception e) {
            this.emp_Code_Field.setText("Employee Code");
            this.emp_ID_Field.setText("ID");
            this.emp_Password_Field.setText("Password");
        }
    }
    public static Banco getBanco(){
        return banco;    }
}
