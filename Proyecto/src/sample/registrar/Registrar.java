package sample.registrar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.Main;

import java.io.IOException;

public class Registrar {
    @FXML
    StackPane stackPane;
    @FXML
    AnchorPane anchorPane;
@FXML
    TextField user,contra,correo;


    public void reg(ActionEvent event){

    }
    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
