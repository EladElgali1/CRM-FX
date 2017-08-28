package sceneFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import sample.DataTransfer;
import sample.Main;
import supervision.AlertBox;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by elad on 11/08/2017.
 */
public class ChoosePlan implements Initializable {


    Map<String, String> dataDictionary = new HashMap<String, String>();

    @FXML
    ComboBox<String> typePlanComboBox = new ComboBox<>();
    @FXML
    ComboBox<String> amountComboBox = new ComboBox<>();
    @FXML
    Button continuedButtom =new Button();

    @FXML
    CheckBox sundayCheckBox =new CheckBox();
    @FXML
    CheckBox mondayCheckBox =new CheckBox();
    @FXML
    CheckBox tuesdayCheckBox =new CheckBox();
    @FXML
    CheckBox wednesdayCheckBox =new CheckBox();
    @FXML
    CheckBox thursdayCheckBox =new CheckBox();
    @FXML
    CheckBox fridayCheckBox =new CheckBox();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typePlanComboBox.getItems().addAll(
                "זוגי/אישי",
                "קבוצתי"
        );
        typePlanComboBox.setPromptText("סוג תוכנית :");

        amountComboBox.getItems().addAll(
                "8",
                "12"
        );
        amountComboBox.setPromptText("כמות :");

    }




    public void continuedButtomClick(){

        if(typePlanComboBox.getValue()==null||amountComboBox.getValue()==null){
            AlertBox.disply("שגיאה","אנא מלא את כל השדות");
            return;
        }
        //check box input to dictionary
        dataDictionary.put("sunday", String.valueOf(sundayCheckBox.isSelected()));
        dataDictionary.put("monday", String.valueOf(mondayCheckBox.isSelected()));
        dataDictionary.put("tuesday", String.valueOf(tuesdayCheckBox.isSelected()));
        dataDictionary.put("wednesday", String.valueOf(wednesdayCheckBox.isSelected()));
        dataDictionary.put("thursday", String.valueOf(thursdayCheckBox.isSelected()));
        dataDictionary.put("friday", String.valueOf(fridayCheckBox.isSelected()));
      //combo box input to dictionary
        dataDictionary.put("typePlan", typePlanComboBox.getValue());
        dataDictionary.put("amount", amountComboBox.getValue());

        if(typePlanComboBox.getValue().equals("זוגי/אישי")){
            System.out.println("זוגי");
            DataTransfer data = DataTransfer.getInstance();
            data.setAction("personalTrainingRegistration");
                Main.setStringProperty("personalTrainingRegistration");

        }
        if (typePlanComboBox.getValue().equals("קבוצתי")){
            System.out.println("קבוצתי");
        }



        System.out.println(dataDictionary.get("amount"));



    }

}
