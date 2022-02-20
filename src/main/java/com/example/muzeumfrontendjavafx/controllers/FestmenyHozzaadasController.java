package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Festmeny;
import com.example.muzeumfrontendjavafx.Szobor;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FestmenyHozzaadasController extends Controller{

    @FXML
    public TextField textFieldTitle;
    @FXML
    public Spinner<Integer> spinnerYear;
    @FXML
    public CheckBox checkBoxOnDisplay;

    @FXML
    public void hozzaadas(MouseEvent mouseEvent) {
        String title = textFieldTitle.getText().trim();
        int year = spinnerYear.getValue();
        boolean on_display = checkBoxOnDisplay.isSelected();

        if (title.isEmpty()){
            alert("A title mező megadása kötelező");
        }
        else if (title.length() > 255) {
            alert("A title mezőnek maximum 255 karakternek kell lennie");
        }
        else{
            try {
                Festmeny f = new Festmeny(0, title, year, on_display);
                Festmeny letrehozott = Api.addPainting(f);
                if (letrehozott != null){
                    alert("Sikeres hozzáadás");
                } else {
                    alert("Sikertelen hozzáadás");
                }
            } catch (Exception e) {
                hibaKiir(e);
            }
        }
    }
}
