package pt.sample.controller.secondary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import pt.sample.constant.FXMLFile;
import pt.sample.controller.AppModel;
import pt.sample.helper.FXMLLoadHelper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSecondaryViewController extends AnchorPane implements Initializable {
    @FXML
    private Label secondaryLabel;
    @FXML
    private Label lblTime;

    private final AppModel model;
    private final SecondaryViewModel secondaryViewModel;

    public FXMLSecondaryViewController(AppModel model, SecondaryViewModel secondaryViewModel) {
        this.model = model;
        this.secondaryViewModel = secondaryViewModel;
        try {
            FXMLLoader loader = FXMLLoadHelper.getLoader(FXMLFile.SECONDARY_VIEW);
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        secondaryLabel.textProperty().bind(model.globalMessageProperty());
        lblTime.textProperty().bind(secondaryViewModel.timerProperty());
    }
}
