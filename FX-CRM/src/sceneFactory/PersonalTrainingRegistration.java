package sceneFactory;

import dataStorage.DataStorage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.DataTransfer;
import sample.Main;
import supervision.AlertBox;
import users.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by elad on 14/08/2017.
 */
public class PersonalTrainingRegistration implements Initializable {



    private static Stage newClientWindow =null;
    private ObservableList<Client> clientList;
    private static StringProperty stringProperty;


    @FXML
    Button addButtom ;
    @FXML
    TableView<Client> personTableView;
    @FXML
    TableColumn<Client,String> nameColumn;
    @FXML
    TableColumn<Client,String> idColumn ;
    @FXML
    TableColumn<Client,String> phoneColumn;
    @FXML
    TableColumn<Client,String> addressColumn;
    @FXML
    TableColumn<Client,String> ageColumn;
    @FXML
    TableColumn<Client,String>  invoiceNumberColumn;
    @FXML
    TableColumn<Client,Boolean> asAgreementColumn;

    private Stage mainWindow = null ;

    private Scene mainScene=null;
    private boolean flag =false;



    public PersonalTrainingRegistration() {

        clientList = FXCollections.observableArrayList();
        stringProperty= new SimpleStringProperty(this,"stringProperty","");
        mainWindow = new Stage();
        mainWindow.setTitle("test");


        //name column
        nameColumn =new  TableColumn<>("שם מלא :");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("name"));
        //id column
        idColumn =new  TableColumn<>("תעודת זהות :");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        // phone column
        phoneColumn =new  TableColumn<>("טלפון :");
        phoneColumn.setMinWidth(100);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        //address column
        addressColumn =new  TableColumn<>("כתובת:");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        //age column
        ageColumn =new  TableColumn<>("תאריך לידה:");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        //invoiceNumber column
        invoiceNumberColumn =new  TableColumn<>("מספר קבלה:");
        invoiceNumberColumn.setMinWidth(100);
        invoiceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        //asAgreement column
        asAgreementColumn =new  TableColumn<>("הסכם:");
        asAgreementColumn.setMinWidth(100);
        asAgreementColumn.setCellValueFactory(new PropertyValueFactory<>("asAgreement"));

        personTableView= new TableView<>();
        personTableView.setItems(clientList);
        personTableView.getColumns().addAll(nameColumn,idColumn,phoneColumn,addressColumn,ageColumn,
                invoiceNumberColumn,asAgreementColumn);

        // buttom init
        Button addButtom =new Button("הוסף");
        addButtom.setOnAction(event -> {addButtomClick();});
        Button cancelButtom =new Button("ביטול");
        cancelButtom.setOnAction(event -> {cancelButtomClick();});
        Button deleteButtom =new Button("הסר");
        deleteButtom.setOnAction(event -> {deleteButtomClick();});
        Button endlButtom =new Button("סיום");
        endlButtom.setOnAction(event -> {finishButtomClick();});

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(35);
        hBox.getChildren().addAll(addButtom,deleteButtom,cancelButtom,endlButtom);
        VBox vBox= new VBox();
        vBox.getChildren().addAll(personTableView,hBox);
        mainScene = new Scene(vBox);

       // mainWindow.setScene(mainScene);
        //mainWindow.show();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientList = FXCollections.observableArrayList();
        stringProperty= new SimpleStringProperty(this,"stringProperty","");
        mainWindow = new Stage();
        mainWindow.setTitle("test");

       //name column
        nameColumn =new  TableColumn<>("שם מלא :");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("name"));
        //id column
        idColumn =new  TableColumn<>("תעודת זהות :");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        // phone column
        phoneColumn =new  TableColumn<>("טלפון :");
        phoneColumn.setMinWidth(100);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        //address column
        addressColumn =new  TableColumn<>("כתובת:");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        //age column
        ageColumn =new  TableColumn<>("תאריך לידה:");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
         //invoiceNumber column
        invoiceNumberColumn =new  TableColumn<>("מספר קבלה:");
        invoiceNumberColumn.setMinWidth(100);
        invoiceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        //asAgreement column
        asAgreementColumn =new  TableColumn<>("הסכם:");
        asAgreementColumn.setMinWidth(100);
        asAgreementColumn.setCellValueFactory(new PropertyValueFactory<>("asAgreement"));

        personTableView= new TableView<>();
        personTableView.setItems(clientList);
        personTableView.getColumns().addAll(nameColumn,idColumn,phoneColumn,addressColumn,ageColumn,
                invoiceNumberColumn,asAgreementColumn);
        Button addButtom =new Button("הוסף");
        addButtom.setOnAction(event -> {addButtomClick();});
        Button cancelButtom =new Button("ביטול");
        Button deleteButtom =new Button("הסר");
        Button endlButtom =new Button("סיום");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addButtom,deleteButtom,cancelButtom,endlButtom);
        VBox vBox= new VBox();
        vBox.getChildren().addAll(personTableView,hBox);
        mainScene = new Scene(vBox);

        mainWindow.setScene(mainScene);
        mainWindow.show();


    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }




    public static void setStringProperty(String value){
      if(stringProperty.get().equals(value)){
            return;
        }

        stringProperty.set(value);
    }

    public void addButtomClick(){
        newClientWindow = new Stage();
        Scene scene=null;
        flag=true;
        newClientWindow.initModality(Modality.APPLICATION_MODAL);
        NewClient newClient =new NewClient();
        Parent root = null;
        try {
            root = FXMLLoader.load(newClient.getClass().getResource("newClient.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            scene = new Scene(root, 600, 350);
        }catch (NullPointerException e){
            System.out.println("some Error:");
            e.printStackTrace();
        }

        if(scene !=null) {
            newClientWindow.setScene(scene);
            newClientWindow.show();
        }else{
            System.out.println("ERROR:scene is null");
        }
        DataTransfer data =DataTransfer.getInstance();
        data.setClientList(clientList);
        actionLisner();
    }

    public void cancelButtomClick(){
        DataTransfer data ;
        data =DataTransfer.getInstance();
        data.setAction("choosePlan");
        Main.setStringProperty("choosePlan");
    }

    public void deleteButtomClick(){
        ObservableList<Client> allClients,selectedItem;
        allClients = personTableView.getItems();
        selectedItem=personTableView.getSelectionModel().getSelectedItems();
        selectedItem.forEach(allClients::remove);

    }

    public void finishButtomClick(){
        DataStorage dataStorage = new DataStorage();
        String [] data=new String[clientList.size()];
        if(data!=null) {
            for (int i = 0; i < clientList.size(); i++) {
                data[i] = clientList.get(i).toString()+"\n";
            }
        }

        if(dataStorage.dataToFile("setNewClietToPersonalTraining", data)){
            System.out.println("done!");
        }else{
            System.out.println("something worng");
        }
    }



    public void actionLisner(){
        stringProperty.addListener((v,oldValue,newValue)->{
            DataTransfer data = DataTransfer.getInstance();
            if(data.getAction().equals("closeThisWindow")){
                newClientWindow.close();
                return;
            }
            if (data.getClient() != null) {
                if(flag) {
                    clientList.add(data.getClient());
                    flag=false;
                    newClientWindow.close();
                }

            } else {
                AlertBox.disply("שגיאה בהזנת לקוח", "הזנת לקוח אל אימון פרטי/זוגי לא הצליחה נסה שוב");
            }



        });
    }


    public ObservableList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ObservableList<Client> clientList) {
        this.clientList = clientList;
    }

    public static Stage getNewClientWindow() {
        return newClientWindow;
    }

    public static void setNewClientWindow(Stage newClientWindow) {
        PersonalTrainingRegistration.newClientWindow = newClientWindow;
    }

}
