package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML
    HBox contenedor;
    @FXML
    AnchorPane padre;
    String[] palabras= {"LAPIZ","PLUMA","CUADERNO","BOCINAS","LIBRO","ENCENDEDOR"};
    @FXML  protected void initialize(){
        Random random= new Random();
        int aleatorio= random.nextInt(5);
        String palabra = palabras[aleatorio];
        System.out.println(palabra);
        int ayuda=1;//estas son las letras de ayuda
        pintarCuerpo();
        for (int x=0;x<palabra.length();x++){
            TextField txt1= new TextField();
            txt1.setPrefWidth(50);
            txt1.setPrefHeight(50);
            contenedor.getChildren().add(txt1);
        }
    }
    public void pintarCuerpo(){
        ImageView cabeza= new ImageView("sample/img/cabeza.png");
        cabeza.setFitHeight(70);
        cabeza.setFitWidth(70);
        cabeza.setLayoutX(215);
        cabeza.setLayoutY(200);

        ImageView cuerpo= new ImageView("sample/img/mano der.png");
        cuerpo.setFitHeight(70);
        cuerpo.setFitWidth(5);
        cuerpo.setLayoutX(250);
        cuerpo.setLayoutY(270);

        ImageView manoIzq= new ImageView("sample/img/mano izq.png");
        manoIzq.setFitHeight(70);
        manoIzq.setFitWidth(70);
        manoIzq.setLayoutX(180);
        manoIzq.setLayoutY(280);

        ImageView pieIzq= new ImageView("sample/img/mano izq.png");
        pieIzq.setFitHeight(70);
        pieIzq.setFitWidth(70);
        pieIzq.setLayoutX(180);
        pieIzq.setLayoutY(335);

        ImageView manoDer= new ImageView("sample/img/derecha.png");
        manoDer.setFitHeight(70);
        manoDer.setFitWidth(70);
        manoDer.setLayoutX(255);
        manoDer.setLayoutY(280);

        ImageView pieDer= new ImageView("sample/img/derecha.png");
        pieDer.setFitHeight(70);
        pieDer.setFitWidth(70);
        pieDer.setLayoutX(255);
        pieDer.setLayoutY(335);

        padre.getChildren().addAll(cabeza,cuerpo,manoIzq,pieIzq,manoDer,pieDer);

    }
}
