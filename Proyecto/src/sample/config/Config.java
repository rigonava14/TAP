package sample.config;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sample.Main;
import sample.models.Conexion;
import sample.principal.Principal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Config {
    @FXML
    JFXTextField cambiar,contra,mail;
    Conexion conexion;
    public static String n;
    @FXML protected void  initialize(){
       cambiar.setText(n);
        conexion = new Conexion();
    }
    public void aplicar() throws SQLException, IOException {
        String i = cambiar.getText();
        String us = Principal.user;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CAMBIAR NOMBRE");
        alert.setContentText("¿Desea Cambiar el Nombre de Usuario? Al hacerlo tendra que iniciar sesion de nuevo");
        Optional<ButtonType> resultado=alert.showAndWait();
        if (resultado.get()==ButtonType.OK){
            conexion.insmodel("UPDATE users SET name='"+i+"' WHERE name = '"+us+"'");
            Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        }
    }
    public void eliminar() throws IOException {
        String i = contra.getText();
        String a = mail.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ELIMINAR CUENTA");
        alert.setContentText("¿Desea Eliminar Su cuenta? ");
        Optional<ButtonType> resultado=alert.showAndWait();
        if (resultado.get()==ButtonType.OK){
            conexion.insmodel("DELETE FROM users WHERE email = '"+a+"'");
            Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        }
    }
    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
}
