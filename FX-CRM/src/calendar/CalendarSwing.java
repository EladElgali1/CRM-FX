package calendar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by elad on 30/08/2017.
 */
public class CalendarSwing extends JFrame implements Initializable{


    @FXML
    Button addButtom ;
    @FXML
    TableView<Week> tableView;
    @FXML
    TableColumn<Week,String> SundayColumn;
    @FXML
    TableColumn<Week,String> MondayColumn;
    @FXML
    TableColumn<Week,String> TuesdayColumn ;
    @FXML
    TableColumn<Week,String> WednesdayColumn;
    @FXML
    TableColumn<Week,String> ThursdayColumn;
    @FXML
    TableColumn<Week,String> FridayColumn;
    @FXML
    TableColumn<Week,String>  SaturdayColumn;

    private Calendar cal = new GregorianCalendar();


    private Stage mainWindow = null ;
    private Scene mainScene=null;
    private boolean flag =false;


    private static Stage newClientWindow =null;
    private ObservableList<Week> eventsList;
    private static StringProperty stringProperty;
    private Calendar gregorianCalendar;

    public CalendarSwing() {
        gregorianCalendar= new GregorianCalendar();
    }


    public void init(){
       eventsList = FXCollections.observableArrayList();
       stringProperty= new SimpleStringProperty(this,"stringProperty","");
       mainWindow = new Stage();
       mainWindow.setTitle("test");

       //name column
        SundayColumn =new TableColumn<>("ראשון");
        SundayColumn.setMinWidth(100);
        SundayColumn.setCellValueFactory(new PropertyValueFactory<>("sunday"));
       //id column
        MondayColumn =new  TableColumn<>("שני");
        MondayColumn.setMinWidth(100);
        MondayColumn.setCellValueFactory(new PropertyValueFactory<>("monday"));
       // phone column
        TuesdayColumn =new  TableColumn<>("שלישי");
        TuesdayColumn.setMinWidth(100);
        TuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
       //address column
        WednesdayColumn =new  TableColumn<>("רביעי");
        WednesdayColumn.setMinWidth(100);
        WednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
       //age column
        ThursdayColumn =new  TableColumn<>("חמישי");
        ThursdayColumn.setMinWidth(100);
        ThursdayColumn.setCellValueFactory(new PropertyValueFactory<>("thursday"));
       //invoiceNumber column
        FridayColumn =new  TableColumn<>("שישי");
        FridayColumn.setMinWidth(100);
        FridayColumn.setCellValueFactory(new PropertyValueFactory<>("friday"));
       //asAgreement column
        SaturdayColumn =new  TableColumn<>("שבת");
        SaturdayColumn.setMinWidth(100);
        SaturdayColumn.setCellValueFactory(new PropertyValueFactory<>("saturday"));

        tableView= new TableView<>();
        tableView.setItems(eventsList);
        tableView.getColumns().addAll(SundayColumn,MondayColumn,TuesdayColumn,WednesdayColumn,ThursdayColumn,
                FridayColumn,SaturdayColumn);
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
       vBox.getChildren().addAll(tableView,hBox);
       mainScene = new Scene(vBox);

       mainWindow.setScene(mainScene);
       mainWindow.show();

   }

    private void addButtomClick() {


    }

    public int getNumberOfDayInMouth(int month,int year){
        int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if(month==Calendar.FEBRUARY){
            if((year%100==0&&year%400==0)||(year%4==0&&year%100!=0)){
                return 29;
            }
        }
        return DAYS_IN_MONTH[month];
    }


    public int getTheFirstDayOfTheMouth(int month,int year){

        Calendar cal = new GregorianCalendar();
        cal.set(month,year,1);
        return cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);

    }



    private void CreateMouth(int month,int year){
        final String[] DAYS_OF_WEEK_LONG_NAMES = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        String currentMonth;
        Week []week= new Week[5];
        int []temp= new int[7];
        int firstDay=getTheFirstDayOfTheMouth(month,year);
        temp[firstDay]=1;
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 7; j++) {
                temp[j]=firstDay;
                if(firstDay==7){
                    firstDay=1;
                }
            }
           // week[i]=new Week(,,,,,,,)
        }


       if(cal.get(Calendar.MONTH)==1){
           for (int i=0;i<5;i++){
              // cal.get(Calendar.Day)
           }
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //init();



    }
}
