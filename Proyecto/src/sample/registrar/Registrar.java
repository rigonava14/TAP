package sample.registrar;

import com.jfoenix.controls.JFXTextField;
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
import sample.models.Conexion;

import java.io.IOException;

public class Registrar {
    @FXML
    StackPane stackPane;
    @FXML
    AnchorPane anchorPane;
@FXML
JFXTextField user,contra,correo,apellido;

Conexion conexion;

@FXML protected void initialize(){
    conexion = new Conexion();
}
    public void reg(ActionEvent event){
        if (!user.getText().trim().equals("")&& !contra.getText().trim().equals("") &&
                !correo.getText().trim().equals("") && !apellido.getText().trim().equals("")){
            String n = user.getText();
            String a = apellido.getText();
            String c = correo.getText();
            String p = contra.getText();
            String i = "IMG.jpg";
            String l ="0";
            conexion.insmodel("INSERT INTO users(name, last_name, email, password, img_profile, level) VALUES ('"+n+"'," +
                    "'"+a+"','"+c+"','"+p+"','"+i+"','"+l+"')");
            user.setText("");
            contra.setText("");
            correo.setText("");
            apellido.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrado Exitosamente");
            alert.setContentText("Has sido registrado");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Favor de llenar todos los campos");
            alert.setTitle("Campos Vacios");
            alert.show();
        }
    }
    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
