package calendar;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 * Created by elad on 31/08/2017.
 */
public class Week {
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;

    public Week(String sunday, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }
}
