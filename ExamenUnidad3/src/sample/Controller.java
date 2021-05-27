package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    Label estatus,porcentaje;
    @FXML
    Pane bar;
    @FXML
    TextField txtPeso;
    public static Hilo hilo;
    public static int por;
    @FXML protected void initialize(){
        hilo= new Hilo(porcentaje,bar,txtPeso);

    }


    public void start(){
        if (txtPeso.getText().equals("")){
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Favor de ingresar el peso");
            alert.show();
        }else {

            hilo.start();
            if (por>=100)hilo.stop();
            Stop();
        }

    }
    public  void Stop(){
        if (bar.getPrefWidth()>=300){
            hilo.stop();
        }
        System.out.println(bar.getPrefWidth());
    }

}
