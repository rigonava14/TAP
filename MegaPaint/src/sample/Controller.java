package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    Canvas lienzo;
    @FXML
    ColorPicker colorPicker;
    Color colorPincel= Color.BLACK;
    GraphicsContext context;
    @FXML
    Slider slider;
    @FXML
    ComboBox comboOpciones;

    @FXML protected void initialize(){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                pintarDibujos(t1.intValue());
            }
        });
        comboOpciones.getItems().addAll("Cuadricula", "Ajedrez","Estrella","Estrella doble");
        context= lienzo.getGraphicsContext2D();
        context.setFill(Color.BLUE);
    }
    public void pintarDibujos(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(colorPincel);
        if (comboOpciones.getSelectionModel().getSelectedIndex()==0){
            //cuadricula
            for (int x=0;x<valor;x++){
                int divisiones=(int)(lienzo.getWidth()/valor);
                context.strokeLine(0,divisiones*x,lienzo.getWidth(),divisiones*x);
                context.strokeLine(divisiones*x,0,divisiones*x,lienzo.getHeight());

            }
        }else if (comboOpciones.getSelectionModel().getSelectedIndex()==1){
            //Ajedrez
            //context.fillRect(0,0, lienzo.getWidth(), lienzo.getHeight());
            int separacion=2*valor;
            for (int x=0;x<lienzo.getWidth();x+=separacion){
                for (int y =0;y<=lienzo.getWidth();y+=separacion)
                //context.clearRect(x,y,valor,valor);
                    context.fillRect(x,y,valor,valor);
            }
            for (int x=valor;x<=lienzo.getWidth();x+=separacion){
                for (int y = valor;y<=lienzo.getWidth();y+=separacion){
                    //context.clearRect(x,y,valor,valor);
                    context.fillRect(x,y,valor,valor);
                }
            }
        }else if (comboOpciones.getSelectionModel().getSelectedIndex()==2){
            int mitadAlto=(int)(lienzo.getHeight())/2;
            int mitadAncho=(int)(lienzo.getWidth())/2;
            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getHeight(),mitadAlto);
            int divisiones =mitadAncho/valor;
            for (int x=1;x<valor+1;x++){
                context.strokeLine(mitadAncho,divisiones*x,mitadAlto+(divisiones*x),mitadAlto);
            }
            for (int x=1;x<valor+1;x++){
                context.strokeLine(mitadAncho,lienzo.getWidth()- (divisiones*x),mitadAlto-(divisiones*x),mitadAlto);
            }
            for (int x=1;x<valor+1;x++){
                context.strokeLine(mitadAlto,divisiones*x,mitadAncho-(divisiones*x),mitadAlto);
            }
            for (int x=1;x<valor+1;x++){
                context.strokeLine(mitadAlto,lienzo.getHeight()-(divisiones*x),mitadAlto+(divisiones*x),mitadAlto);
            }
        }else if (comboOpciones.getSelectionModel().getSelectedIndex()==3){

        }
    }
    public void borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
    }
    public void cambiarColor(ActionEvent event){
        colorPincel=colorPicker.getValue();
    }
    public void arrastrar(MouseEvent event){
        context.setFill(colorPincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }
}
