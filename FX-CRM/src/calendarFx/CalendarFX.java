package calendarFx;

import com.calendarfx.view.DayView;
import com.calendarfx.view.page.MonthPage;
import javafx.fxml.FXML;

/**
 * Created by elad on 30/08/2017.
 */
public class CalendarFX {
    @FXML
    DayView dayView= new DayView();

    @FXML
    MonthPage  monthPage = new MonthPage();

    public void dayPickClick(){
        System.out.println(monthPage.getDate().toString());
    }
}
