package sample;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Hilo extends Thread {
    private Pane progressBar;
    private Label label;
    private TextField textField;
    public Hilo(Label label, Pane progressBar,TextField textField){
        this.label=label;
        this.progressBar=progressBar;
        this.textField=textField;
    }
    int progreso=0;
    int a = 100;
    int cont;
    int menos = 20;

    @Override
    public void run() {
        while (true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        int peso = Integer.parseInt(textField.getText());
                        progreso=progreso+10;
                        int porcentaje = (progreso*100)/peso;
                        int i=progreso;
                        if (i==a){
                            progreso=progreso-20;
                            a=a+100;
                        }
                        String pr = String.valueOf(porcentaje);
                        Controller.por=porcentaje;
                        label.setText(pr);
                        int barra=(porcentaje*400)/100;
                        progressBar.setPrefWidth(barra);
                        if (Integer.parseInt(label.getText())>=100) {
                            Controller.hilo.stop();
                            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("El archivo se ha subido");
                            alert.show();
                        }

                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
