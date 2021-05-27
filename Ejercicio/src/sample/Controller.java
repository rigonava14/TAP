package sample;

import javafx.animation.ParallelTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Controller {
    @FXML
    Button btn1,btn2;
    @FXML
    AnchorPane padre;
    @FXML
    ImageView img;
    Hilo1 h1;
    Hilo2 h2;
    public  void no(){
        if(h1 != null) h1.stop(); h1=null;
        Random random = new Random();
        int rx = random.nextInt(450);
        int ry = random.nextInt(450);
        h1 =new Hilo1(btn2, rx,ry);
        h1.start();
    }
    public void  si(){

        Random random = new Random();
        int r = random.nextInt(100);
        ImageView[] img=new ImageView[r];
        for (int i=0; i<r; i++){
            img[i] = new ImageView(new Image("./sample/corazon.png"));
            img[i].setFitWidth(32);
            img[i].setFitHeight(32);
            img[i].setLayoutY(500);
            img[i].setLayoutX(random.nextInt(500));
            padre.getChildren().add(img[i]);
        }
        if(h2 != null) h2.stop(); h2=null;
        h2 = new Hilo2(img,r);
        h2.start();
    }
}
