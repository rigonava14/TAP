package sample.principal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.config.Config;
import sample.models.Conexion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Principal {

    @FXML
    JFXComboBox comboTutorial,cmbCat;
    @FXML
    VBox Tutos;
    @FXML
    JFXListView listaTuto;

    ObservableList<String> items = FXCollections.observableArrayList();
    String[] TutorialesBasicos = {"Tutorial Rostro", "Tutorial Manos", "Tutorial Nariz", "Tutorial Boca","Tutorial Objetos",
    "Tutorial ojos", "Tutorial Sombras","Materiales Basicos","Dibujar Rostros 3/4"};

    Random random= new Random();

    Label[] arrayLabel= null;
    @FXML Label Label,usuario;
    @FXML JFXComboBox tipo;
    @FXML JFXTextField nombre,tecnica,txtEd;
    Conexion conexion;
    @FXML
    JFXButton eliminar,editar;
    public static String user;
    @FXML protected void initialize() throws SQLException {
        conexion= new Conexion();
        items.addAll("Basico","Intermedio","Avanzado");
        comboTutorial.setItems(items);
        tipo.setItems(items);

        System.out.println(user);
        ResultSet resultSet=conexion.consultar("SELECT * FROM users WHERE name='"+user+"'");
        if (resultSet!=null){
            while(resultSet.next()){
                System.out.println(resultSet.getObject("name"));
                usuario.setText(resultSet.getObject("name").toString());
                Config.n=resultSet.getObject("name").toString();
            }
        }
    }

    public void generar(ActionEvent event) throws SQLException {
        listaTuto.getItems().clear();
        if (comboTutorial.getSelectionModel().getSelectedItem().equals("Basico")){
            ResultSet res = conexion.consultar("SELECT nombre FROM basicos");
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }
        if (comboTutorial.getSelectionModel().getSelectedItem().equals("Intermedio")){
            ResultSet res = conexion.consultar("SELECT nombre FROM intermedio");
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }
        if (comboTutorial.getSelectionModel().getSelectedItem().equals("Avanzado")){
            ResultSet res = conexion.consultar("SELECT nombre FROM avanzados");
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }
    }
    public  void mostrar() throws SQLException {

    }
    public void insertar(ActionEvent event) throws SQLException {
        String t=tecnica.getText();
        String n = nombre.getText();
        String tp=tipo.getSelectionModel().toString().toLowerCase();

        if (tipo.getSelectionModel().getSelectedItem().equals("Basico")){
            conexion.insmodel("INSERT INTO basicos(nombre, tecnica) VALUES ('"+n+"','"+t+"')");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Insertado Exitosamente");
            alert.show();
            ResultSet res = conexion.consultar("SELECT nombre FROM basicos");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }
        }else if (tipo.getSelectionModel().getSelectedItem().equals("Intermedio")){
            conexion.insmodel("INSERT INTO intermedio(nombre, tecnica) VALUES ('"+n+"','"+t+"')");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Insertado Exitosamente");
            alert.show();
            ResultSet res = conexion.consultar("SELECT nombre FROM intermedio");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }
        }else  if (tipo.getSelectionModel().getSelectedItem().equals("Avanzado")){
            conexion.insmodel("INSERT INTO avanzados(nombre, tecnica) VALUES ('"+n+"','"+t+"')");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Insertado Exitosamente");
            alert.show();
            ResultSet res = conexion.consultar("SELECT nombre FROM avanzados");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }
        }

    }
    public void cate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../category/category.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void config(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../config/config.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void cerrar (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login/login.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void eliminar() throws SQLException {
        String i = listaTuto.getSelectionModel().getSelectedItem().toString();

        if (comboTutorial.getSelectionModel().getSelectedItem().equals("Basico")){
            System.out.println(i);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea eliminar Registro?");
            alert.setTitle("ELIMINAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("DELETE FROM basicos WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM basicos");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }else if (comboTutorial.getSelectionModel().getSelectedItem().equals("Intermedio")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea eliminar Registro?");
            alert.setTitle("ELIMINAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("DELETE FROM intermedio WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM intermedio");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }else  if (comboTutorial.getSelectionModel().getSelectedItem().equals("Avanzado")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea eliminar Registro?");
            alert.setTitle("ELIMINAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("DELETE FROM avanzados WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM avanzados");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }

        }
    }
    public void editar() throws SQLException {
        String i = listaTuto.getSelectionModel().getSelectedItem().toString();
        String a = txtEd.getText();
        if (comboTutorial.getSelectionModel().getSelectedItem().equals("Basico")){
            System.out.println(i);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea Editar Registro?");
            alert.setTitle("EDITAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("UPDATE basicos SET nombre ='"+a+"' WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM basicos");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }else if (comboTutorial.getSelectionModel().getSelectedItem().equals("Intermedio")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea editar Registro?");
            alert.setTitle("EDITAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("UPDATE intermedio SET nombre ='"+a+"' WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM intermedio");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }


        }else  if (comboTutorial.getSelectionModel().getSelectedItem().equals("Avanzado")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("¿Desea editar Registro?");
            alert.setTitle("EDITAR REGISTRO");
            Optional<ButtonType> resultado =alert.showAndWait();
            if (resultado.get()==ButtonType.OK){
                conexion.insmodel("UPDATE avanzados SET nombre ='"+a+"' WHERE nombre='"+i+"'");
            }
            ResultSet res = conexion.consultar("SELECT nombre FROM avanzados");
            listaTuto.getItems().clear();
            if (res!=null){
                while (res.next()){
                    listaTuto.getItems().addAll(res.getObject("nombre").toString());
                }
            }

        }
    }
}
