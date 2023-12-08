package com.example.formularz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class HelloApplication extends Application {

    boolean isValid = false;
    Text imie = new Text("Imie");
    Text nazwisko = new Text("Nazwisko");
    Text adres = new Text("Adres");
    Text miejscowosc = new Text("Miejscowosc");
    Text telefon = new Text("Telefon");
    Text email = new Text("Email");

    TextField imieText = new TextField();
    TextField nazwiskoText = new TextField();
    TextField adresText = new TextField();
    TextField miejscowoscText = new TextField();
    TextField telefonText = new TextField();
    TextField emailText = new TextField();
    Button zatwierdz = new Button("Submit");
    Button wyczysc = new Button("Clear");

    Text errmsg = new Text();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Text[] teksty = {imie, nazwisko, adres, miejscowosc, telefon, email};
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(imie, 0, 0);
        gridPane.add(imieText, 1, 0);
        gridPane.add(nazwisko, 0, 1);
        gridPane.add(nazwiskoText, 1, 1);
        gridPane.add(adres, 0, 2);
        gridPane.add(adresText, 1, 2);
        gridPane.add(miejscowosc, 0, 3);
        gridPane.add(miejscowoscText, 1, 3);
        gridPane.add(telefon, 0, 4);
        gridPane.add(telefonText, 1, 4);
        gridPane.add(email, 0, 5);
        gridPane.add(emailText, 1, 5);
        gridPane.add(zatwierdz, 0, 6);
        gridPane.add(wyczysc, 1, 6);
        gridPane.add(errmsg, 0, 7);
        zatwierdz.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        wyczysc.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        zatwierdz.setDisable(true);
        for (Text text : teksty) {
            text.setStyle("-fx-font: normal bold 20px 'serif'");
        }
        wyczysc.setOnAction(event -> wyczysc());
        imieText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzImie());
        nazwiskoText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzNazwisko());
        adresText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzAdres());
        miejscowoscText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzMiejscowosc());
        telefonText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzTelefon());
        emailText.textProperty().addListener((observable, oldValue, newValue) -> sprawdzEmail());
        Scene scene = new Scene(gridPane);
        stage.setTitle("CSS Example");
        stage.setScene(scene);
        stage.show();
    }

    private void sprawdzImie() {
        isValid = checkAllFieldsFilled();
        if (Pattern.matches("[a-zA-Z]{2,}", imieText.getText())) {
            imie.setFill(Color.BLACK);
        } else {
            isValid = false;
            imie.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void sprawdzNazwisko() {
        isValid = checkAllFieldsFilled();
        if (Pattern.matches("[a-zA-Z]{2,}", nazwiskoText.getText())) {
            nazwisko.setFill(Color.BLACK);
        } else {
            isValid = false;
            nazwisko.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void sprawdzAdres() {
        isValid = checkAllFieldsFilled();
        if (!adresText.getText().trim().isEmpty()) {
            adres.setFill(Color.BLACK);
        } else {
            isValid = false;
            adres.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void sprawdzMiejscowosc() {
        isValid = checkAllFieldsFilled();
        if (Pattern.matches("[a-zA-Z]{3,}", miejscowoscText.getText())) {
            miejscowosc.setFill(Color.BLACK);
        } else {
            isValid = false;
            miejscowosc.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void sprawdzTelefon() {
        isValid = checkAllFieldsFilled();
        if (Pattern.matches("\\d{9,}", telefonText.getText())) {
            telefon.setFill(Color.BLACK);
        } else {
            isValid = false;
            telefon.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void sprawdzEmail() {
        isValid = checkAllFieldsFilled();
        if (Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", emailText.getText())) {
            email.setFill(Color.BLACK);
        } else {
            isValid = false;
            email.setFill(Color.RED);
        }
        moznaZatwierdzic();
    }

    private void wyczysc() {
        imieText.clear();
        nazwiskoText.clear();
        adresText.clear();
        miejscowoscText.clear();
        telefonText.clear();
        emailText.clear();
    }

    private void moznaZatwierdzic() {
        zatwierdz.setDisable(!isValid);
    }

    private boolean checkAllFieldsFilled() {
        return !imieText.getText().trim().isEmpty() &&
                !nazwiskoText.getText().trim().isEmpty() &&
                !adresText.getText().trim().isEmpty() &&
                !miejscowoscText.getText().trim().isEmpty() &&
                !telefonText.getText().trim().isEmpty() &&
                !emailText.getText().trim().isEmpty();
    }
}
