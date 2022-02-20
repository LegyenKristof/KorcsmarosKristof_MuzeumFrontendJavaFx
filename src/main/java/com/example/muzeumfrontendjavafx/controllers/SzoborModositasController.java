package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Szobor;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SzoborModositasController extends Controller{
    @FXML
    public TextField textFieldPerson;
    @FXML
    public Spinner<Integer> spinnerHeight;
    @FXML
    public Spinner<Integer> spinnerPrice;

    private Szobor szobor;

    public Szobor getSzobor() {
        return szobor;
    }

    public void setSzobor(Szobor szobor) {
        this.szobor = szobor;
    }

    public void initialize(){
        textFieldPerson.setText(szobor.getPerson());
        spinnerHeight.getValueFactory().setValue(szobor.getHeight());
        spinnerPrice.getValueFactory().setValue(szobor.getPrice());
    }

    @FXML
    public void modositas(MouseEvent mouseEvent) {
        String person = textFieldPerson.getText().trim();
        int height = spinnerHeight.getValue();
        int price = spinnerPrice.getValue();

        if (person.isEmpty()){
            alert("A person mező megadása kötelező");
        }
        else if (person.length() < 5) {
            alert("A person mezőnek minimum 5 karakternek kell lennie");
        }
        else{
            try {
                Szobor s = new Szobor(szobor.getId(), person, height, price);
                Szobor modositott = Api.editStatue(s);
                if (modositott != null){
                    alert("Sikeres módosítás");
                    szobor = modositott;
                } else {
                    alert("Sikertelen módosítás");
                }
            } catch (Exception e) {
                hibaKiir(e);
            }
            initialize();
        }
    }
}
