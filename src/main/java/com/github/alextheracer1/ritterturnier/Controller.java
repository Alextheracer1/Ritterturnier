package com.github.alextheracer1.ritterturnier;

import com.github.alextheracer1.ritterturnier.Members.Ritter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button addItem;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ChoiceBox<String> weaponChoiceBox;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField reputationTextField;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TextField levelOfTrainingTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> memberList = new ArrayList<>();
        memberList.add("Ritter");
        memberList.add("Knappe");
        choiceBox.setItems(FXCollections.observableArrayList(memberList));

        ArrayList<String> weaponList = new ArrayList<>();
        weaponList.add("Keule");
        weaponList.add("Schwert");
        weaponList.add("Lanze");
        weaponChoiceBox.setItems(FXCollections.observableArrayList(weaponList));

        levelOfTrainingTextField.setOpacity(0);
        reputationTextField.setOpacity(0);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {

                nameTextField.setText("");
                mobileNumberTextField.setText("");
                levelOfTrainingTextField.setText("");
                reputationTextField.setText("");

                //System.out.println(memberList.get(new_value.intValue()) + " selected");
                if (Objects.equals(memberList.get(new_value.intValue()), "Ritter") || Objects.equals(memberList.get(new_value.intValue()), "Knappe")) {
                    nameTextField.setDisable(false);
                    mobileNumberTextField.setDisable(false);
                    if (Objects.equals(memberList.get(new_value.intValue()), "Ritter")){
                        reputationTextField.setDisable(false);
                        levelOfTrainingTextField.setDisable(true);
                        levelOfTrainingTextField.setOpacity(0);
                        reputationTextField.setOpacity(1);
                    } else if (Objects.equals(memberList.get(new_value.intValue()),"Knappe")){
                        levelOfTrainingTextField.setDisable(false);
                        reputationTextField.setDisable(true);
                        reputationTextField.setOpacity(0);
                        levelOfTrainingTextField.setOpacity(1);
                    }
                }
                nameTextField.setText("");
                mobileNumberTextField.setText("");
                levelOfTrainingTextField.setText("");
                reputationTextField.setText("");
            }
        });
    }


    public void prozessSelection() {
        String selected = choiceBox.getSelectionModel().getSelectedItem();
        String name = nameTextField.getText();
        String reputation = reputationTextField.getText();
        String mobileNumber = mobileNumberTextField.getText();
        String levelOfTraining = levelOfTrainingTextField.getText();



        if (Objects.equals(selected, "Ritter")){
            System.out.println("Name: " + name + "\nselected type: " + selected + "\nReputation Name: " + reputation + "\nMobile Number: " + mobileNumber);
            // Ritter ritter = new Ritter(name, 0020202, reputation);
        } else {
            System.out.println("Name: " + name + "\nselected type: " + selected + "\nMobile Number: " + mobileNumber + "\nLevel of Training: " + levelOfTraining);
        }
        nameTextField.setText("");
        mobileNumberTextField.setText("");
        levelOfTrainingTextField.setText("");
        reputationTextField.setText("");
    }
}