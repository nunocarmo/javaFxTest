package pt.sample.controller.secondary;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import pt.sample.global.TEST;
import pt.sample.logic.TimerRunner;

public class SecondaryViewModel {
    private final StringProperty timer = new SimpleStringProperty("");

    public SecondaryViewModel() {
        TEST.getInstance().getRunnableMap().put("TimerRunner", new TimerRunner(timer));
    }


    public String getTimer() {
        return timer.get();
    }

    public StringProperty timerProperty() {
        return timer;
    }
}
