package sample.login;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.Main;

import java.io.IOException;

public class Login {

    @FXML
    StackPane stackPane;
    @FXML
    AnchorPane anchorPane;
    @FXML
    TextField user,pass;

    String[] ArrayUsuarios= {"Rigo","admin"};
    @FXML protected void initialize(){

    }
    public void reg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../registrar/registrar.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);

    }
    public void log(ActionEvent event) throws IOException {

        if ((user.getText().equals("Rigo")) && (pass.getText().equals("admin"))) {
            Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        }else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.setTitle("Incorrecto");
            alert.show();
        }

    }
}
