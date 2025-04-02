package pt.sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppModel {
    private final StringProperty globalMessage = new SimpleStringProperty("Hello World");

    public String getGlobalMessage() {
        return globalMessage.get();
    }

    public StringProperty globalMessageProperty() {
        return globalMessage;
    }
}
