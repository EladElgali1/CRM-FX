package supervision;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;


/**
 * Created by elad on 13/08/2017.
 */
public class AlertBox {

    public static void disply(String title ,String text){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);


        Label label =new Label();
        label.setText(text);

        Button closeButtom = new Button("Close");
        closeButtom.setOnAction(e->{
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButtom);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();



    }
}
