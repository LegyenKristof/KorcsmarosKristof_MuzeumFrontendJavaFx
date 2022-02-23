package com.example.muzeumfrontendjavafx.controllers;

import com.example.muzeumfrontendjavafx.Api;
import com.example.muzeumfrontendjavafx.Festmeny;
import com.example.muzeumfrontendjavafx.Szobor;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
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
    public static Szobor szobor;
    public static Festmeny festmeny;

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
        try {
            Controller c = ujAblak("szobor-hozzaadas-view.fxml", "Új szobor",260, 200);

            c.getStage().setOnCloseRequest(event -> listazas());
            c.getStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void szoborModositas(MouseEvent mouseEvent) {
        Szobor s = listViewSzobrok.getSelectionModel().getSelectedItem();
        if(s == null){
            alert("Jelöljön ki egy elemet a módosításhoz");
            return;
        }
        try {
            Controller c = ujAblak("szobor-modositas-view.fxml", "Szobor módosítása",260, 200);
            szobor = s;

            c.getStage().setOnCloseRequest(event -> listazas());
            c.getStage().show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            hibaKiir(e);
        }
    }

    @FXML
    public void szoborTorles(MouseEvent mouseEvent) {
        Szobor s = listViewSzobrok.getSelectionModel().getSelectedItem();
        if(s == null){
            alert("Jelöljön ki egy elemet a törléshez");
            return;
        }
        if (!confirm("Biztos törli?")) {
            return;
        }
        try {
            if(Api.deleteStatue(s.getId())){
                alert("Sikeres törlés");
            }
            else{
                alert("Sikertelen törlés");
            }
            listazas();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void festmenyHozzaadas(MouseEvent mouseEvent) {
        try {
            Controller c = ujAblak("festmeny-hozzaadas-view.fxml", "Új festmény",285, 192);

            c.getStage().setOnCloseRequest(event -> listazas());
            c.getStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void festmenyModositas(MouseEvent mouseEvent) {
        Festmeny f = listViewFestmenyek.getSelectionModel().getSelectedItem();
        if(f == null){
            alert("Jelöljön ki egy elemet a módosításhoz");
            return;
        }
        try {
            FestmenyModositasController c = (FestmenyModositasController) ujAblak("festmeny-modositas-view.fxml", "Festmény módosítása",285, 192);
            c.setFestmeny(f);
            c.getStage().setOnCloseRequest(event -> listazas());
            c.getStage().show();
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void festmenyTorles(MouseEvent mouseEvent) {
        Festmeny f = listViewFestmenyek.getSelectionModel().getSelectedItem();
        if(f == null){
            alert("Jelöljön ki egy elemet a törléshez");
            return;
        }
        if (!confirm("Biztos törli?")) {
            return;
        }
        try {
            if(Api.deletePainting(f.getId())){
                alert("Sikeres törlés");
            }
            else{
                alert("Sikertelen törlés");
            }
            listazas();
        } catch (IOException e) {
            hibaKiir(e);
        }
    }
}