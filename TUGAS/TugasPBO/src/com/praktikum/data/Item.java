package com.praktikum.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private final StringProperty itemName;
    private final StringProperty description;
    private final StringProperty location;
    private final StringProperty status;

    public Item(String itemName, String description, String location) {
        this.itemName = new SimpleStringProperty(itemName);
        this.description = new SimpleStringProperty(description);
        this.location = new SimpleStringProperty(location);
        this.status = new SimpleStringProperty("Reported");
    }

    // Property Getters
    public StringProperty nameProperty() {
        return itemName;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty locationProperty() {
        return location;
    }

    public StringProperty statusProperty() {
        return status;
    }

    // Normal Getters
    public String getItemName() {
        return itemName.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getLocation() {
        return location.get();
    }

    public String getStatus() {
        return status.get();
    }

    // Setters
    public void setStatus(String status) {
        this.status.set(status);
    }
}
