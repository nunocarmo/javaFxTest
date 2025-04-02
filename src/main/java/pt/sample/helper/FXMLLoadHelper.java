package pt.sample.helper;

import javafx.fxml.FXMLLoader;
import pt.sample.MainApp;
import pt.sample.constant.FXMLFile;

import java.io.IOException;

public class FXMLLoadHelper {

    public static FXMLLoader getLoader(FXMLFile file) {
           return new FXMLLoader(MainApp.class.getClassLoader().getResource(file.getPath()));
    }
}
