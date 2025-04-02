package pt.sample.global;

import pt.sample.logic.AppRunnable;

import java.util.HashMap;
import java.util.Map;

public class TEST {
    private static TEST instance;

    private final Map<String, AppRunnable> runnableMap = new HashMap<String, AppRunnable>();

    private TEST() {
    }

    public static TEST getInstance() {
        if (instance == null) {
            instance = new TEST();
        }
        return instance;
    }

    public Map<String, AppRunnable> getRunnableMap() {
        return runnableMap;
    }
}
