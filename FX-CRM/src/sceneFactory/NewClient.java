package sceneFactory;

import com.sun.deploy.util.SessionState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.DataTransfer;
import supervision.AlertBox;
import users.Client;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by elad on 11/08/2017.
 */
public class NewClient implements Initializable {

    @FXML
    TextField name;
    @FXML
    TextField id;
    @FXML
    TextField phone;
    @FXML
    TextField address;
    @FXML
    TextField invoiceNumber;
    @FXML
    CheckBox asAgreement;
    @FXML
    CheckBox asMedicalcCertificate;
    @FXML
    TextField dateOfBirth;
    @FXML
    Button okButtom;
    @FXML
    Button cancelButtom;




    DataTransfer data= DataTransfer.getInstance();



    public NewClient() {


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        asAgreement=new CheckBox();
        asMedicalcCertificate = new CheckBox();
    }


    public void okButtomClick(){
        Client newClient=addClient();
        try{
            Double.parseDouble(newClient.getId());
        }catch (NumberFormatException e){
            AlertBox.disply("שגיאה","תעודת זהות חייב להכיל ספרות בלבד");
        }
        try{
            Double.parseDouble(newClient.getPhone());
        }catch (NumberFormatException e){
            AlertBox.disply("שגיאה","מספר טלפון חייב להכיל ספרות בלבד");
            return;
        }
        if(newClient.getId().length()!= 9){
            AlertBox.disply("שגיאה","תעודת זהות באורך לא חוקי");
            return;
        }

        if(checkPerson(newClient)){
            data.setClient(newClient);
            PersonalTrainingRegistration.setStringProperty(id.getText());
        }else{
            AlertBox.disply("שגיאה","הזנה כפולה");
            return;
        }

    }

    public void cancelButtomclick(){
        PersonalTrainingRegistration.getNewClientWindow().close();


    }

    private boolean checkPerson(Client newClient) {
        for(int i=0;i<data.getClientList().size();i++){
            if(newClient.getId().equals(data.getClientList().get(i).getId())){
                return false;
            }
        }
        return true;

    }


    public Client addClient(){
        DataTransfer data=DataTransfer.getInstance();
        Client client = new Client();
        client.setName(name.getText());
        client.setId(id.getText());
        client.setPhone(phone.getText());
        client.setAddress(address.getText());
        client.setAge(dateOfBirth.getText());
        client.setInvoiceNumber(invoiceNumber.getText());
        client.setAsAgreement(asAgreement.isSelected());
        client.setAsMedicalcCertificate(asMedicalcCertificate.isSelected());
        //client.setBandNumber();

        return  new Client( name.getText(),  id.getText(), phone.getText(),  address.getText(),
                dateOfBirth.getPromptText(), invoiceNumber.getText(),  asAgreement.isSelected());



    }


}
