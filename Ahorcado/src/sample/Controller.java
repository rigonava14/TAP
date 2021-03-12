package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML
    HBox contenedor;
    @FXML
    AnchorPane padre;
    String[] palabras= {"LAPIZ","PLUMA","CUADERNO","BOCINAS","LIBRO","ENCENDEDOR"};
    TextField[] arrayTxt=null;
    int cont1=0;
    int cont2=0;

    @FXML  protected void initialize(){
        Random random= new Random();
        int aleatorio= random.nextInt(5);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt= new TextField[palabra.length()];
        int ayuda=1;//estas son las letras de ayuda

        for (int x=0;x<palabra.length();x++){
            arrayTxt[x]= new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    TextField textField=(TextField) keyEvent.getTarget();
                    String[] nombre= textField.getId().split("-");

                    if (nombre[2].equals(textField.getText().toLowerCase())){
                        cont1++;
                        textField.setEditable(false);
                        if (cont1 == palabra.length()){
                            System.out.println(palabra.length());
                            System.out.println(cont1);
                            Alert alert= new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Has ganado el juego");
                            alert.show();
                        }
                        System.out.println("Correcto"+textField.getId());
                    }else{
                        cont2++;
                        System.out.println("Incorrecto"+textField.getId());
                        textField.setText("");
                        System.out.println(cont2);
                        if (cont2 == 1) {
                            pintarCabeza();}
                        else if (cont2==2){
                            pintarCuerpo();
                        }else if (cont2==3){
                            pintarManoDer();
                        }else if (cont2==4){
                            manoIzquierda();
                        }else if (cont2==5){
                            pintarPieDer();
                        }else if (cont2==6){
                            pintarPieIzq();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Has perdido el juego:(");
                            alert.show();
                        }

                    }

                }
            });
            contenedor.getChildren().add(arrayTxt[x]);
        }
    }
    public void pintarCabeza(){
        ImageView cabeza= new ImageView("sample/img/cabeza.png");
        cabeza.setFitHeight(70);
        cabeza.setFitWidth(70);
        cabeza.setLayoutX(215);
        cabeza.setLayoutY(200);
        padre.getChildren().add(cabeza);
    }
    public void manoIzquierda(){
        ImageView manoIzq= new ImageView("sample/img/mano izq.png");
        manoIzq.setFitHeight(70);
        manoIzq.setFitWidth(70);
        manoIzq.setLayoutX(180);
        manoIzq.setLayoutY(280);
        padre.getChildren().add(manoIzq);
    }
    public void pintarPieIzq(){
        ImageView pieIzq= new ImageView("sample/img/mano izq.png");
        pieIzq.setFitHeight(70);
        pieIzq.setFitWidth(70);
        pieIzq.setLayoutX(180);
        pieIzq.setLayoutY(335);
        padre.getChildren().add(pieIzq);
    }
    public void pintarManoDer(){
        ImageView manoDer= new ImageView("sample/img/derecha.png");
        manoDer.setFitHeight(70);
        manoDer.setFitWidth(70);
        manoDer.setLayoutX(255);
        manoDer.setLayoutY(280);
        padre.getChildren().add(manoDer);
    }
    public void pintarPieDer(){
        ImageView pieDer= new ImageView("sample/img/derecha.png");
        pieDer.setFitHeight(70);
        pieDer.setFitWidth(70);
        pieDer.setLayoutX(255);
        pieDer.setLayoutY(335);
        padre.getChildren().add(pieDer);
    }
    public void pintarCuerpo(){
        ImageView cuerpo= new ImageView("sample/img/mano der.png");
        cuerpo.setFitHeight(70);
        cuerpo.setFitWidth(5);
        cuerpo.setLayoutX(250);
        cuerpo.setLayoutY(270);
        padre.getChildren().add(cuerpo);
    }
}
