package sample.principal;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;

import java.io.IOException;
import java.util.*;

public class Principal {
    @FXML
    ComboBox comboTutorial;
    @FXML
    VBox Tutos;

    ObservableList<String> items = FXCollections.observableArrayList();
    String[] TutorialesBasicos = {"Tutorial Rostro", "Tutorial Manos", "Tutorial Nariz", "Tutorial Boca","Tutorial Onjetos",
    "Tutorial ojos", "Tutorial Sombras","Materiales Basicos","Dibujar Rostros 3/4"};

    Random random= new Random();

    Label[] arrayLabel= null;
    @FXML Label Label;

    @FXML protected void initialize(){

items.addAll("Basico","Medio","Avanzado");
        comboTutorial.setItems(items);


    }

    public void generar(ActionEvent event){
        int aleatorio = random.nextInt(8);
        if (comboTutorial.getSelectionModel().getSelectedIndex()==0){
           Label.setText(TutorialesBasicos[aleatorio]);

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
}
