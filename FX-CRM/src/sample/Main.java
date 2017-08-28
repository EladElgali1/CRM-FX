package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sceneFactory.PersonalTrainingRegistration;
import sceneFactory.SceneFactory;

public class Main extends Application {
    private static StringProperty stringProperty;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("CRM");
        primaryStage.setScene(new Scene(root, 800 ,500));

        DataTransfer data =DataTransfer.getInstance();
        stringProperty= new SimpleStringProperty(this,"stringProperty","");
        stringProperty.addListener((v,oldValue,newValuw)->{
            SceneFactory sceneFactory = new SceneFactory();
            Scene scene = sceneFactory.createScene(data.getAction());
            if (scene != null) {
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                System.out.println("scene is null");
            }

        });
        primaryStage.show();
    }

    public static void setStringProperty(String action){
        stringProperty.setValue(action);
    }



}
