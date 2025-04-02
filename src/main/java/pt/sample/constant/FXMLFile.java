package pt.sample.constant;

public enum FXMLFile {
    MAIN_APP("fxml/FXMLApp.fxml"),
    SECONDARY_VIEW("fxml/secondary/FXMLSecondaryView.fxml"),
    ;

    private final String path;

    FXMLFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
