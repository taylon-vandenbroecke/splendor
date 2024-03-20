package gui;

import java.io.FileInputStream;
import java.util.Properties;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class BeginScherm extends HBox {
	private static String padTaal = "src/talen/taal.properties";
	private String taalKeuze;
	private DomeinController dc;
	
	static final Properties taal = new Properties();
	static {
		try {
			taal.load(new FileInputStream(padTaal));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BeginScherm(String taalKeuze) {
		dc = new DomeinController();
		this.taalKeuze = taalKeuze;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		
		Button btnLogIn = new Button(taal.getProperty(taalKeuze + "LogIn"));
		btnLogIn.setPrefHeight(50);
		btnLogIn.setPrefWidth(100);
		
		Button btnRegistreer = new Button(taal.getProperty(taalKeuze + "Registreer"));
		btnRegistreer.setPrefHeight(50);
		btnRegistreer.setPrefWidth(100);
		
		Line line = new Line(50, 0, 50, 100);
		
		// Create the exit button and set its action
        Button exitButton = new Button("X");
        exitButton.setOnAction(e -> System.exit(0));
        BorderPane.setAlignment(exitButton, Pos.TOP_RIGHT);
        
		this.getChildren().add(btnLogIn);
		this.getChildren().add(line);
		this.getChildren().add(btnRegistreer);
		
		btnLogIn.setOnAction(this::buttonPushed);
		btnRegistreer.setOnAction(this::buttonPushed2);
		
	}

	private void buttonPushed(ActionEvent event) {
		LoginScherm ls = new LoginScherm(taalKeuze, dc);
	    Scene scene = new Scene(ls, 350, 275);
		Stage stage = (Stage) this.getScene().getWindow();
	    stage.setScene(scene);
	    stage.centerOnScreen();
	    stage.show();
    }
	
	private void buttonPushed2(ActionEvent event) {
		RegistreerScherm rs = new RegistreerScherm(taalKeuze, dc);
	    Scene scene = new Scene(rs, 350, 275);
		Stage stage = (Stage) this.getScene().getWindow();
	    stage.setScene(scene);
	    stage.centerOnScreen();
	    stage.show();
	}
}


