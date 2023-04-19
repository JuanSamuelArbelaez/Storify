package Controllers.Login;


import Controllers.Controller;
import Model.Assets.Admin.Admin;
import Model.Assets.User.User;
import Model.Structures.HashMap.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login_Controller extends Controller {
    @FXML TextField UserName_Field;
    @FXML PasswordField Password_Field;

    @FXML public void login(ActionEvent event) {
        HashMap<String, User> map = this.storify.getUsers();

        Admin admin = this.storify.getAdmin();
        boolean isAdmin = admin.getUsername().equals(UserName_Field.getText());
        if(isAdmin) {
            if(admin.getPassword().equals(Password_Field.getText())){
                //Ventana admin
            }else {
                refreshCells();
                return;
            }
        }

        if(!map.containsKey(UserName_Field.getText())) {
            refreshCells();
            return;
        }

        User user = map.get(UserName_Field.getText());
        if(!user.getPassword().equals(Password_Field.getText())) {
            refreshCells();
            return;
        }

        //Ventana usuario
    }

    private void refreshCells() {
        this.UserName_Field.setText("");
        this.Password_Field.setText("");
    }
}