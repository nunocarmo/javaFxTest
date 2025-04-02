package pt.sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pt.sample.constant.FXMLFile;
import pt.sample.controller.secondary.FXMLSecondaryViewController;
import pt.sample.controller.secondary.SecondaryViewModel;
import pt.sample.helper.FXMLLoadHelper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLAppController extends AnchorPane implements Initializable {
    @FXML
    private Label messageLabel;
    @FXML
    private TextField messageInput;
    @FXML
    private Button updateButton;
    @FXML
    private VBox secondaryViewContainer;

    private FXMLSecondaryViewController secondaryView;

    private final AppModel model;

    public FXMLAppController(AppModel model) {
        this.model = model;
        try {
            FXMLLoader loader = FXMLLoadHelper.getLoader(FXMLFile.MAIN_APP);
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        secondaryView = new FXMLSecondaryViewController(model, new SecondaryViewModel());
        secondaryViewContainer.getChildren().add(secondaryView);
        updateButton.setOnAction(event -> {
            String newMessage = messageInput.getText();
            if (newMessage != null && !newMessage.isEmpty()) {
                model.globalMessageProperty().set(newMessage);
                messageInput.clear();
            }
        });
    }

}
