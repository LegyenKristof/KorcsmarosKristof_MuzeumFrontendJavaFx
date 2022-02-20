package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Szobor;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SzoborHozzaadasController extends Controller{
    @FXML
    public TextField textFieldPerson;
    @FXML
    public Spinner<Integer> spinnerHeight;
    @FXML
    public Spinner<Integer> spinnerPrice;

    @FXML
    public void hozzaadas(MouseEvent mouseEvent) {
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
                Szobor s = new Szobor(0, person, height, price);
                Szobor letrehozott = Api.addStatue(s);
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
