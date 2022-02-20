package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Festmeny;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FestmenyModositasController extends Controller{
    @FXML
    public TextField textFieldTitle;
    @FXML
    public Spinner<Integer> spinnerYear;
    @FXML
    public CheckBox checkBoxOnDisplay;
    private Festmeny festmeny;

    public Festmeny getFestmeny() {
        return festmeny;
    }

    public void setFestmeny(Festmeny festmeny) {
        this.festmeny = festmeny;
    }

    public void initialize(){
        textFieldTitle.setText(festmeny.getTitle());
        spinnerYear.getValueFactory().setValue(festmeny.getYear());
        checkBoxOnDisplay.setSelected(festmeny.isOnDisplay());
    }

    @FXML
    public void modositas(MouseEvent mouseEvent) {
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
                Festmeny f = new Festmeny(festmeny.getId(), title, year, on_display);
                Festmeny modositott = Api.editPainting(f);
                if (modositott != null){
                    alert("Sikeres hozzáadás");
                    festmeny = modositott;
                } else {
                    alert("Sikertelen hozzáadás");
                }
            } catch (Exception e) {
                hibaKiir(e);
            }
            initialize();
        }
    }
}
