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
   
    private Calendar calendar = Calendar.getInstance();
    public Button sunWeek1 = new Button();
    public Button monWeek1 = new Button();
    public Button tueWeek1 = new Button();
    public Button wedWeek1 = new Button();
    public Button thuWeek1 = new Button();
    public Button friWeek1 = new Button();
    public Button satWeek1 = new Button();
    public Button sunWeek2 = new Button();
    public Button monWeek2 = new Button();
    public Button tueWeek2 = new Button();
    public Button wedWeek2 = new Button();
    public Button thuWeek2 = new Button();
    public Button friWeek2 = new Button();
    public Button satWeek2 = new Button();
    public Button satWeek3 = new Button();
    public Button friWeek3 = new Button();
    public Button thuWeek3 = new Button();
    public Button wedWeek3 = new Button();
    public Button tueWeek3 = new Button();
    public Button monWeek3 = new Button();
    public Button sunWeek3 = new Button();
    public Button sunWeek4 = new Button();
    public Button monWeek4 = new Button();
    public Button tueWeek4 = new Button();
    public Button wedWeek4 = new Button();
    public Button thuWeek4 = new Button();
    public Button friWeek4 = new Button();
    public Button satWeek4 = new Button();
    public Button satWeek5 = new Button();
    public Button friWeek5 = new Button();
    public Button thuWeek5 = new Button();
    public Button wedWeek5 = new Button();
    public Button tueWeek5 = new Button();
    public Button monWeek5 = new Button();
    public Button sunWeek5 = new Button();
    public Button satWeek6 = new Button();
    public Button friWeek6 = new Button();
    public Button thuWeek6 = new Button();
    public Button wedWeek6 = new Button();
    public Button tueWeek6 = new Button();
    public Button monWeek6 = new Button();
    public Button sunWeek6 = new Button();
    public Button nextYearLabel;
    public Label yearLabel = new Label();
    public Button previousYearLabel;
    public Button previousMonthLabel1;
    public Label monthLabel = new Label();
    public Button nextMonthLabel1;
    public Label sundayLabel = new Label();
    public Label mondayLabel = new Label();
    public Label tuesdayLabel = new Label();
    public Label wednesdayLabel = new Label();
    public Label thursdayLabel = new Label();
    public Label fridayLabel = new Label();
    public Label saturdayLabel = new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage mainWindow = new Stage();
        mainWindow.setTitle("ניהול לוח זnנים");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(35);
        for (int i=1;i<7;++i){
            for (int z=1;z<8;++z){
                Tooltip tooltip = new Tooltip();
                getDay(i,z).setTooltip(tooltip);
            }
        }


        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox);
        Scene mainScene = new Scene(vBox);
        mainWindow.setScene(mainScene);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        sundayLabel.setAlignment(Pos.CENTER);
        mondayLabel.setAlignment(Pos.CENTER);
        tuesdayLabel.setAlignment(Pos.CENTER);
        wednesdayLabel.setAlignment(Pos.CENTER);
        thursdayLabel.setAlignment(Pos.CENTER);
        fridayLabel.setAlignment(Pos.CENTER);
        saturdayLabel.setAlignment(Pos.CENTER);
        getDay(2,2).setText("hello");
        ThisMonth(day);
        //initializing buttons click
        for(int  i=1;i<7;++i) {
            for (int z=1;z<8;++z) {
                final int tempi = i;
                final int tempz = z;
                getDay(i, z).setOnAction(event -> {
                });
            }
        }
    }

    private void updateSchedule() {
        for(int  i=1;i<7;++i) {
            for (int z=1;z<8;++z) {
                Object plans = null;
                Date date = new Date();
                if(calendar.getTime().before(date))
                    getDay(i, z).getTooltip().setText("תוכניות שהיו ליום זה:");
                else
                    getDay(i, z).getTooltip().setText("תוכניות שיהיו ליום זה:");
                getDay(i, z).getTooltip().setText(getDay(i, z).getTooltip().getText() + "\n\n");
                if (plans == null) {
                    getDay(i,z).getTooltip().setText(getDay(i, z).getTooltip().getText() + "אין תוכניות");

                }
            }
        }
    }

   /* public Date getCalendarDate() {
        return calendarDate;
    }*/

    public void previousMonth() {
        clrCalendar();
        calendar.add(Calendar.MONTH,-1);
        Date date = new Date();
        if(date.getMonth()==calendar.get(Calendar.MONTH)&&date.getYear() + 1900==calendar.get(Calendar.YEAR)){
            //Back to current month
            calendar.setTime(date);
            ThisMonth(calendar.get(Calendar.DAY_OF_MONTH));
            return;
        }
        boolean past = calendar.getTime().before(date);
        updateCalendar(past);
    }

    public void nextMonth() {
        clrCalendar();
        calendar.add(Calendar.MONTH,1);
        Date date = new Date();
        if(date.getMonth()==calendar.get(Calendar.MONTH)&&date.getYear() + 1900==calendar.get(Calendar.YEAR)){
            //Back to current month
            calendar.setTime(date);
            ThisMonth(calendar.get(Calendar.DAY_OF_MONTH));
            return;
        }
        boolean past = calendar.getTime().before(date);
        updateCalendar( past);
    }

    public void previousYear(){
        clrCalendar();
        calendar.add(Calendar.YEAR, -1);
        Date date = new Date();
        if(date.getMonth()==calendar.get(Calendar.MONTH)&&date.getYear() + 1900==calendar.get(Calendar.YEAR)){
            //Back to current month
            calendar.setTime(date);
            ThisMonth(calendar.get(Calendar.DAY_OF_MONTH));
            return;
        }
        boolean past = calendar.getTime().before(date);
        updateCalendar(past);
    }

    public void nextYear(){
        clrCalendar();
        calendar.add(Calendar.YEAR, 1);
        Date date = new Date();
        if(date.getMonth()==calendar.get(Calendar.MONTH)&&date.getYear() + 1900==calendar.get(Calendar.YEAR)){
            //Back to current month
            calendar.setTime(date);
            ThisMonth(calendar.get(Calendar.DAY_OF_MONTH));
            return;
        }
        boolean past = calendar.getTime().before(date);
        updateCalendar(past);
    }

    private void updateCalendar(boolean past) {
        boolean firstTime = true;
        yearLabel.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        yearLabel.setFont(new Font("Ariel", 18));
        monthLabel.setText(monthName(calendar.get(Calendar.MONTH)));
        monthLabel.setFont(new Font("Ariel", 16));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        while (calendar.get(Calendar.DAY_OF_MONTH) < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            if (firstTime) {
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                firstTime = false;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setFont(Font.font("System", 14));
            if(!past)
                getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setTextFill(Color.GREEN);
            else
                getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setTextFill(Color.RED);
        }
        updateSchedule();
    }

    private void ThisMonth(int day) {
        yearLabel.setText(String.valueOf(calendar.get(Calendar.YEAR)));
        yearLabel.setFont(new Font("Ariel", 18));
        monthLabel.setText(monthName(calendar.get(Calendar.MONTH)));
        monthLabel.setFont(new Font("Ariel", 16));
        getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setFont(Font.font("System", FontWeight.BOLD, 14));
        getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setTextFill(Color.BLUE);
        getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setAlignment(Pos.CENTER);
        while (calendar.get(Calendar.DAY_OF_MONTH) > calendar.getActualMinimum(Calendar.DAY_OF_MONTH)) {
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setFont(Font.font("System", FontWeight.BOLD, 14));
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setTextFill(Color.RED);
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setAlignment(Pos.CENTER);
        }
        calendar.set(Calendar.DAY_OF_MONTH,day);
        while (calendar.get(Calendar.DAY_OF_MONTH) < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            calendar.add(Calendar.DAY_OF_MONTH,1);
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setFont(Font.font("System", 14));
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setTextFill(Color.GREEN);
            getDay(calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.DAY_OF_WEEK)).setAlignment(Pos.CENTER);
        }
        updateSchedule();
    }

    public String monthName(int month) {
        /**
         * return the name of the month in hebrew range 0-11 else null
         */
        String months[] = {"ינואר","פברואר","מרץ","אפריל","מאי","יוני","יולי","אוגוסט","ספטמבר","אוקטובר","נובמבר","דצמבר"};
        if (0<=month && month<12) {
            return months[month];
        }
        return "חודש";
    }

    public Button getDay(int week, int day) {
        /** return the specific button by week and day
         * range 1<=week<=6  1<=day<=7
         */
        week--;
        day--;
        Button week1[] = {sunWeek1, monWeek1, tueWeek1, wedWeek1, thuWeek1, friWeek1, satWeek1};
        Button week2[] = {sunWeek2, monWeek2, tueWeek2, wedWeek2, thuWeek2, friWeek2, satWeek2};
        Button week3[] = {sunWeek3, monWeek3, tueWeek3, wedWeek3, thuWeek3, friWeek3, satWeek3};
        Button week4[] = {sunWeek4, monWeek4, tueWeek4, wedWeek4, thuWeek4, friWeek4, satWeek4};
        Button week5[] = {sunWeek5, monWeek5, tueWeek5, wedWeek5, thuWeek5, friWeek5, satWeek5};
        Button week6[] = {sunWeek6, monWeek6, tueWeek6, wedWeek6, thuWeek6, friWeek6, satWeek6};
        Button month[][] = {week1, week2, week3, week4, week5, week6};
        if (0<=week && week<6 && 0<=day && day<7) {
            return month[week][day];
        }
        return null;
    }

    public void clrCalendar(){
        for(int i=1;i<7;++i) {
            for (int z=1;z<8;++z)
                getDay(i,z).setText("");
        }
    }

}
