package com.github.alextheracer1.ritterturnier;

import javafx.scene.control.Alert;

public class WrongInputsAlert {
    Alert alert = new Alert(Alert.AlertType.ERROR);


    WrongInputsAlert(String title, String contentMessage) {
        alert.setTitle(title);
        alert.setContentText(contentMessage);
        alert.showAndWait();
    }
}

