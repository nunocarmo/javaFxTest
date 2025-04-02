package pt.sample.logic;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;

import java.util.concurrent.TimeUnit;

public class TimerRunner implements Runnable,AppRunnable {
    private final StringProperty timer;
    private boolean isRunning;

    public TimerRunner(StringProperty timer) {
        this.timer = timer;
        this.isRunning = true;
        Thread t = new Thread(this, "TimerRunner");
        t.start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            String strTimer = formatElapsedTime(elapsedTime);
            Platform.runLater(() -> timer.set(strTimer));
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ignore) {
                isRunning = false;
            }

        }
    }

    private String formatElapsedTime(long elapsedTime) {
        long milliseconds = elapsedTime % 1000;
        long seconds = (elapsedTime / 1000) % 60;
        long minutes = (elapsedTime / (1000 * 60)) % 60;
        long hours = (elapsedTime / (1000 * 60 * 60));

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }

    public void stop(){
        isRunning = false;
    }
}
