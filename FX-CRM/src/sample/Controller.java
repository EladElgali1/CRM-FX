package sample;

public class Controller {
    DataTransfer data;



    public void newClientClick(){
        data =DataTransfer.getInstance();
        data.setAction("choosePlan");
        Main.setStringProperty("choosePlan");

    }

    public void calendarManagementClick(){
       /* data =DataTransfer.getInstance();
        data.setAction("calendarManagement");
        */
        Main.setStringProperty("calendar");
    }

}
