package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Label lb1,lb2,lb3,lb4;
    @FXML Button btn;
    Hilo h1,h2,h3,h4;


    public void generar(){
        int primer= Integer.parseInt(lb1.getText());
        int segundo= Integer.parseInt(lb2.getText());
        int tercer= Integer.parseInt(lb3.getText());
        int cuarto= Integer.parseInt(lb4.getText());
        if (btn.getText().equals("Generar")) {
            h1=new Hilo(lb1);
            h2=new Hilo(lb2);
            h3=new Hilo(lb3);
            h4=new Hilo(lb4);
            h1.start();
            h2.start();
            h3.start();
            h4.start();
            btn.setText("Detener");

        }else{
            btn.setText("Generar");
            h1.stop();
            if(segundo!=primer & segundo!=tercer & segundo!=cuarto ){
                h2.stop();
            }
            if(tercer!=segundo & tercer!=primer & tercer!=cuarto){
                h3.stop();
            }
            if(cuarto!=tercer & cuarto!=segundo & cuarto!=primer){
                h4.stop();
            }

        }
        // los numeros se repiten y ya intente de muchas cosas xd
        //me doy 

    }
}
