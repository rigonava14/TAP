package sample.category;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import sample.Main;

import java.io.IOException;

public class Category {

    @FXML
    HBox padre;
    String[] categorias={"Oleo","Acuarela","Grafito","Carboncillo","Pastel seco","Acrilico","Escultura"};

    @FXML protected void initialize(){
        cat();
    }
    public void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }
    public void cat(){

        Button[] categoria = new Button[6];

        Button Oleo = new Button("Oleo");
        Oleo.setPrefHeight(50);
        Oleo.setPrefWidth(100);
        Oleo.setStyle("-fx-background-color: #8E9AAF;");
        Oleo.setStyle(" -fx-background-radius: 50px;");
        Oleo.setFont(new Font("Forte",12));
        padre.getChildren().add(Oleo);

        Button acuarela = new Button("Acuarela");
        acuarela.setPrefHeight(50);
        acuarela.setPrefWidth(100);
        acuarela.setStyle("-fx-background-color: #8E9AAF;");
        acuarela.setStyle(" -fx-background-radius: 50px;");
        acuarela.setFont(new Font("Forte",12));
        padre.getChildren().add(acuarela);

        Button grafito = new Button("Grafito");
        grafito.setPrefHeight(50);
        grafito.setPrefWidth(100);
        grafito.setStyle("-fx-background-color: #8E9AAF;");
        grafito.setStyle(" -fx-background-radius: 50px;");
        grafito.setFont(new Font("Forte",12));
        padre.getChildren().add(grafito);

        Button carboncillo = new Button("Carboncillo");
        carboncillo.setPrefHeight(50);
        carboncillo.setPrefWidth(100);
        carboncillo.setStyle("-fx-background-color: #8E9AAF;");
        carboncillo.setStyle(" -fx-background-radius: 50px;");
        carboncillo.setFont(new Font("Forte",12));
        padre.getChildren().add(carboncillo);

        Button acrilico = new Button("Acrilico");
        acrilico.setPrefHeight(50);
        acrilico.setPrefWidth(100);
        acrilico.setStyle("-fx-background-color: #8E9AAF;");
        acrilico.setStyle(" -fx-background-radius: 50px;");
        acrilico.setFont(new Font("Forte",12));
        padre.getChildren().add(acrilico);

    }
}
