package sample.login;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.Main;
import sample.models.Conexion;
import sample.principal.Principal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private Conexion conexion;
    @FXML
    StackPane stackPane;
    @FXML
    AnchorPane anchorPane;
    @FXML
    TextField user,pass;

    String[] ArrayUsuarios= {"Rigo","admin"};
    @FXML protected void initialize(){
        conexion=new Conexion();
    }
    public void reg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../registrar/registrar.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);

    }

    public void log(ActionEvent event) throws IOException, SQLException {
        String email = user.getText();
        String passw = pass.getText();
        ResultSet resultSet = conexion.consultar("select * from users where email='"+email+"' and password='"+passw+"'");

        System.out.println("select * from users where email="+email+" and password="+passw+"");
        int cont=0;
        if (resultSet!=null){

            while (resultSet.next()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("BIENVENIDO");
                alert.setContentText("Bienvenido "+resultSet.getObject("name"));
                alert.show();
                Principal.user=resultSet.getObject("name").toString();
                cont++;
                //System.out.println(resultSet.getObject("name"));
                //System.out.println(resultSet.getObject("email"));
            }
        }
        if (cont==0){
            System.out.println("SIN REGISTROS");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Credenciales no validas");
            alert.show();
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
        }

        /*if ((user.getText().equals("Rigo")) && (pass.getText().equals("admin"))) {

        }else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.setTitle("Incorrecto");
            alert.show();
        }*/

    }
}
