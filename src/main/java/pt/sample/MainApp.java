package pt.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.sample.controller.FXMLAppController;
import pt.sample.controller.AppModel;
import pt.sample.global.TEST;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(new FXMLAppController(new AppModel()), 800, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        TEST.getInstance().getRunnableMap().forEach((key, value) -> value.stop());
        super.stop();
    }
}
