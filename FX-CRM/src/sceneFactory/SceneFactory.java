package sceneFactory;


import calendarFx.CalendarFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


/**
 * Created by elad on 10/08/2017.
 */
public class SceneFactory {

     private Scene scene;


     public Scene createScene(String type){

         if(type.equals("newClient")){
             NewClient newClient =new NewClient();
             Parent root = null;
             try {
                 root = FXMLLoader.load(newClient.getClass().getResource("newClient.fxml"));
             } catch (IOException e) {
                 e.printStackTrace();
             }


             scene=new Scene(root,800,500);
             return  scene;
         }
         if(type.equals("choosePlan")){
             ChoosePlan choosePlan =new ChoosePlan();
             Parent root = null;
             try {
                 root = FXMLLoader.load(choosePlan.getClass().getResource("choosePlan.fxml"));
             } catch (IOException e) {
                 e.printStackTrace();
             }


             scene=new Scene(root,800,500);
             return  scene;
         }
         if(type.equals("personalTrainingRegistration")){
             PersonalTrainingRegistration choosePlan =new PersonalTrainingRegistration();
             return  choosePlan.getMainScene();
         }
         if(type.equals("calendarManagement")){

             CalendarFX calendar =new CalendarFX();
             Parent root = null;
             try {
                 root = FXMLLoader.load(calendar.getClass().getResource("calendarFx.fxml"));
             } catch (IOException e) {
                 e.printStackTrace();
             }


             scene=new Scene(root,800,500);

             return  scene;



         }


         return null;


     }
}
