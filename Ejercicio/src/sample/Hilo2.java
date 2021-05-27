package sample;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.Random;


public class Hilo2 extends Thread{
    private ImageView[] imageView;
    private int r;
    public Hilo2(ImageView[] imageView, int r){
        this.imageView=imageView;
        this.r = r;
    }
    @Override
    public void run() {
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<r; i++){
                        Random random = new Random();
                        int u = random.nextInt(10);
                        imageView[i].setLayoutY(imageView[i].getLayoutY()-u);
                    }
                }
            });
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
