package sceneFactory;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created by elad on 22/08/2017.
 */
public class CalendarManagement implements Initializable {
   Stage mainWindow;
   Scene mainScene;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainWindow = new Stage();
        mainWindow.setTitle("ניהול לוח זnנים");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(35);




        VBox vBox= new VBox();
        vBox.getChildren().addAll(hBox);
        mainScene=new Scene(vBox);
        mainWindow.setScene(mainScene);

    }
}
