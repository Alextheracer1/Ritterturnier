package com.github.alextheracer1.ritterturnier;

import com.github.alextheracer1.ritterturnier.Members.Knappe;
import com.github.alextheracer1.ritterturnier.Members.Ritter;
import com.github.alextheracer1.ritterturnier.Weapons.Keule;
import com.github.alextheracer1.ritterturnier.Weapons.Lanze;
import com.github.alextheracer1.ritterturnier.Weapons.Schwert;
import com.github.alextheracer1.ritterturnier.Weapons.Weapon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private int ritterID = 1;
    private int knappeID = 1;
    private MemberList memberList = new MemberList();
    private boolean disable = true;
    private Schwert schwert;
    private Lanze lanze;
    private Keule keule;
    private Weapon weapon;


    @FXML
    private Button addItem;

    @FXML
    private MenuItem menuItem;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ListView listViewRitter;
    @FXML
    private ListView listViewKnappe;
    @FXML
    private ListView listViewRitterWithKnappe;

    @FXML
    private Label weaponLabel;
    @FXML
    private Label weaponSubCategoryLabel;

    @FXML
    private ChoiceBox<String> characterChoiceBox;

    @FXML
    private ChoiceBox<String> weaponChoiceBox;

    @FXML
    private ChoiceBox<String> weaponSubCategoryChoiceBox;

    @FXML
    private TextField idTextFieldRitterKnappe;


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
        characterChoiceBox.setItems(FXCollections.observableArrayList(memberList));

        ArrayList<String> weaponList = new ArrayList<>();
        weaponList.add("Keule");
        weaponList.add("Schwert");
        weaponList.add("Lanze");
        weaponChoiceBox.setItems(FXCollections.observableArrayList(weaponList));

        levelOfTrainingTextField.setOpacity(0);
        idTextFieldRitterKnappe.setOpacity(0);
        idTextFieldRitterKnappe.setDisable(true);
        reputationTextField.setOpacity(0);
        mobileNumberTextField.setOpacity(0);
        weaponLabel.setOpacity(0);
        weaponSubCategoryLabel.setOpacity(0);
        weaponChoiceBox.setDisable(true);
        weaponChoiceBox.setOpacity(0);
        checkBox.setOpacity(0);
        checkBox.setDisable(true);
        weaponSubCategoryChoiceBox.setOpacity(0);               // For later use still in the code
        weaponSubCategoryChoiceBox.setDisable(true);            // For later use still in the code
        weaponChoiceBox.setOpacity(0);
        weaponChoiceBox.setDisable(true);

        characterChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                clearTextFields();
                setInputTextField(memberList, new_value);
                clearTextFields();
            }
        });
    }

    public void enableRitterKnappeInput() {
        if (disable) {
            idTextFieldRitterKnappe.setOpacity(1);
            idTextFieldRitterKnappe.setDisable(!disable);
            disable = false;
        } else {
            idTextFieldRitterKnappe.setOpacity(0);
            idTextFieldRitterKnappe.setDisable(!disable);
            disable = true;
        }

    }

    public void addKnappeToRitter(Ritter ritter) {
        String id = idTextFieldRitterKnappe.getText();

        if (!id.matches("\\d*")) {
            id = id.replaceAll("[^\\d]", "");
        }

        if (!disable) {
            if (id.equals("")) {
                new WrongInputsAlert("Keine Eingabe", "Es wurde keine ID für den Knappen eingegeben");
                return;
            } else {
                if (memberList.getKnappe(Integer.parseInt(id)) != null) {
                    ritter.setKnappe(memberList.getKnappe(Integer.parseInt(id)));
                } else {
                    new WrongInputsAlert("Kein Knappe", "Es existiert kein Knappe mir der ID " + id + "\nÜberprüfe deine Eingabe oder füge einen Knappen hinzu.");
                    return;
                }

            }
        }
        if (!id.equals("")) {
            System.out.println(id);
        }

    }


    private void clearTextFields() {
        nameTextField.setText("");
        mobileNumberTextField.setText("");
        levelOfTrainingTextField.setText("");
        reputationTextField.setText("");
    }

    private void setInputTextField(ArrayList<String> memberList, Number new_value) {
        if (Objects.equals(memberList.get(new_value.intValue()), "Ritter") || Objects.equals(memberList.get(new_value.intValue()), "Knappe")) {
            nameTextField.setDisable(false);
            mobileNumberTextField.setDisable(false);
            if (Objects.equals(memberList.get(new_value.intValue()), "Ritter")) {
                weaponLabel.setOpacity(1);
                // weaponSubCategoryLabel.setOpacity(1);
                weaponChoiceBox.setDisable(false);
                weaponChoiceBox.setOpacity(1);
                // weaponSubCategoryChoiceBox.setDisable(false);
                // weaponSubCategoryChoiceBox.setOpacity(1);
                mobileNumberTextField.setOpacity(1);
                reputationTextField.setDisable(false);
                levelOfTrainingTextField.setDisable(true);
                levelOfTrainingTextField.setOpacity(0);
                reputationTextField.setOpacity(1);
                checkBox.setOpacity(1);
                checkBox.setDisable(false);
            } else if (Objects.equals(memberList.get(new_value.intValue()), "Knappe")) {
                // weaponSubCategoryChoiceBox.setDisable(true);
                // weaponSubCategoryChoiceBox.setOpacity(0);
                weaponLabel.setOpacity(0);
                weaponSubCategoryLabel.setOpacity(0);
                weaponChoiceBox.setDisable(true);
                weaponChoiceBox.setOpacity(0);
                mobileNumberTextField.setOpacity(1);
                levelOfTrainingTextField.setDisable(false);
                reputationTextField.setDisable(true);
                reputationTextField.setOpacity(0);
                levelOfTrainingTextField.setOpacity(1);
                checkBox.setOpacity(0);
                checkBox.setDisable(true);
                disable = true;
                idTextFieldRitterKnappe.setDisable(disable);
                idTextFieldRitterKnappe.setOpacity(0);
                checkBox.setSelected(false);
            }
        }
    }

    public void processSelection() {
        String selected = characterChoiceBox.getSelectionModel().getSelectedItem();
        String name = nameTextField.getText();
        String reputation = reputationTextField.getText();
        String mobileNumber = mobileNumberTextField.getText();
        int levelOfTraining = 0;

        if (Objects.equals(selected, null)) {
            new WrongInputsAlert("Eingabe Fehler", "Kein Charakter ausgewählt");
        }

        if (Objects.equals(name, "")) {
            new WrongInputsAlert("Eingabe Fehler", "Es wurde kein Name eingegeben");
            return;
        }

        if (Objects.equals(mobileNumber, "")) {
            new WrongInputsAlert("Eingabe Fehler", "Es wurde keine Telefonnummer eingegeben");
            return;
        }

        if (Objects.equals(selected, "Ritter")) {
            if (Objects.equals(reputation, "")) {
                new WrongInputsAlert("Eingabe Fehler", "Es wurde kein Rufname eingegeben");
                return;
            }
        } else if (Objects.equals(selected, "Knappe")) {
            try {
                levelOfTraining = Integer.parseInt(levelOfTrainingTextField.getText());
                if (levelOfTraining > 100 || levelOfTraining < 10) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                new WrongInputsAlert("Eingabe Fehler", "Trainingslevel muss eine valide Zahl zwischen 10 und 100 sein");
                return;
            }
        }

/*
        if (Objects.equals(selected, "Ritter")) {
            // listView.getItems().add(selected + "\nName: " + name + "\nReputation Name: " + reputation + "\nMobile Number: " + mobileNumber);
            System.out.println("Name: " + name + "\nselected type: " + selected + "\nReputation Name: " + reputation + "\nMobile Number: " + mobileNumber);
            // Ritter ritter = new Ritter(name, 0020202, reputation);
        } else {
            //listView.getItems().add(selected + "\nName: " + name + "\nMobile Number: " + mobileNumber + "\nLevel of Training: " + levelOfTraining);
            System.out.println("Name: " + name + "\nselected type: " + selected + "\nMobile Number: " + mobileNumber + "\nLevel of Training: " + levelOfTraining);
        }
*/
        if (Objects.equals(selected, "Ritter")) {
            if (Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Lanze") || Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Schwert")
                    || Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Keule")) {
                if (Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Lanze")) {
                    lanze = new Lanze("Lanze");
                    weapon = lanze;
                } else if (Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Schwert")) {
                    schwert = new Schwert("Schwert");
                    weapon = schwert;
                } else if (Objects.equals(weaponChoiceBox.getSelectionModel().getSelectedItem(), "Keule")) {
                    keule = new Keule("Keule");
                    weapon = keule;
                }
            } else {
                new WrongInputsAlert("Eingabe Fehler", "Es wurde keine Waffe ausgewählt");
                return;
            }
        }
        if (Objects.equals(selected, "Ritter")){
            try{
                for (int i = 1; i <= memberList.getHashSizeRitter(); i++) {
                    if (Objects.equals(memberList.getRitter(i).getName().toLowerCase(Locale.ROOT).strip(), name.toLowerCase(Locale.ROOT).strip())) {
                        if (Objects.equals((memberList.getRitter(i).getReputationName().toLowerCase(Locale.ROOT).strip()), reputation.toLowerCase(Locale.ROOT).strip())){
                            throw new DoubleNameAndReputationException("Double Name and Reputation");
                        }
                    }
                }
            } catch (DoubleNameAndReputationException ignored){
                new WrongInputsAlert("Eingabe Fehler", "Es wurde bereits ein Ritter mit dem Namen: " + name + " und mit dem Rufnamen: " + reputation + " hinzugefügt");
                return;
            }
        }

        makeSelection(selected, name, mobileNumber, levelOfTraining, reputation, weapon);

    }


    private void makeSelection(String selected, String name, String mobileNumber, int levelOfTraining, String reputation, Weapon selectedWeapon) {
        if (Objects.equals(selected, "Ritter")) {
            String cc2 = "265E";
            String text2 = String.valueOf(Character.toChars(Integer.parseInt(cc2, 16)));
            if (checkBox.isSelected()) {
                try {
                    Ritter ritter = new Ritter(name, mobileNumber, reputation, ritterID);
                    ritter.setWeapon(selectedWeapon);
                    addKnappeToRitter(ritter);
                    listViewRitterWithKnappe.getItems().add("Ritter" + ritter.toString() + "\n\nKnappe with Ritter" + ritter.getKnappeToString());
                    memberList.setRitter(ritter, ritterID);
                    clearTextFields();
                    ritterID++;
                } catch (NullPointerException ignored) {
                    new WrongInputsAlert("Kein Knappe", "Der eingegebene Knappe existiert nicht");
                }
            } else {
                Ritter ritter = new Ritter(name, mobileNumber, reputation, ritterID);
                memberList.setRitter(ritter, ritterID);
                ritter.setWeapon(selectedWeapon);
                listViewRitter.getItems().add(selected + " " + text2 + ritter);
                clearTextFields();
                ritterID++;
            }

        } else if (Objects.equals(selected, "Knappe")) {
            Knappe knappe = new Knappe(name, mobileNumber, levelOfTraining, knappeID);
            listViewKnappe.getItems().add(selected + knappe);
            memberList.setKnappe(knappe, knappeID);
            knappeID++;
            clearTextFields();
        }
    }
}