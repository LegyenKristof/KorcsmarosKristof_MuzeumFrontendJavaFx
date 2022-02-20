package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Festmeny;
import com.example.muzeumfrontendjavafx.Szobor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class ListazasController extends Controller{
    @FXML
    public ListView<Szobor> listViewSzobrok;
    @FXML
    public ListView<Festmeny> listViewFestmenyek;

    public void initialize(){
        listazas();
    }

    public void listazas(){
        try {
            List<Szobor> szoborList = Api.getSzobrok();
            listViewSzobrok.getItems().clear();
            listViewSzobrok.getItems().addAll(szoborList);
            List<Festmeny> festmenyList = Api.getFestmenyek();
            listViewFestmenyek.getItems().clear();
            listViewFestmenyek.getItems().addAll(festmenyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void szoborHozzaadas(MouseEvent mouseEvent) {

    }

    @FXML
    public void szoborModositas(MouseEvent mouseEvent) {

    }

    @FXML
    public void szoborTorles(MouseEvent mouseEvent) {

    }

    @FXML
    public void festmenyHozzaadas(MouseEvent mouseEvent) {

    }

    @FXML
    public void festmenyModositas(MouseEvent mouseEvent) {

    }

    @FXML
    public void festmenyTorles(MouseEvent mouseEvent) {

    }
}