package gui;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domein.DomeinController;
import domein.Speler;
import domein.SpelerRepository;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import persistentie.SpelerMapper;

public class MenuScherm extends VBox {
    
	//Commit testen
	
    private String taalKeuze;
    
    private DomeinController dc;
    private SpelerRepository repo;
    private SpelerMapper mapper;
    private Speler ingelogdeSpeler;  
    private List<Speler> spelers;
    private String resultaatDialoog;
    
    private Label lblSpeler;
    private Label lblSpeler2;
    private Label lblSpeler3;
    private Label lblSpeler4;
    
    private TextInputDialog dialog;
    
    private static String padTaal = "src/talen/taal.properties";
    
    static final Properties taal = new Properties();
    static {
    	try {
    		taal.load(new FileInputStream(padTaal));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public MenuScherm(String taalKeuze, Speler speler) {
    	   	
    	
        this.taalKeuze = taalKeuze;
        dc = new DomeinController();
        repo = new SpelerRepository();
        mapper = new SpelerMapper();
        
        this.ingelogdeSpeler = speler;
        this.spelers = new ArrayList<>();
        spelers.add(speler);
        
        resultaatDialoog = null;
        this.setAlignment(Pos.CENTER); 
        
        
        buildGui();
             
       
    }

    private void buildGui() {
    	  
    	this.setSpacing(20);
    	
    	
    	Label lblTaal = new Label(taalKeuze);
    	    	
        lblSpeler = new Label(spelers.get(0).getUsername());
        lblSpeler2 = new Label("");
        lblSpeler3 = new Label("");
        lblSpeler4 = new Label("");
        
        
        lblSpeler.setStyle("-fx-font-size: 15px;");
        lblSpeler2.setStyle("-fx-font-size: 15px;");
        lblSpeler3.setStyle("-fx-font-size: 15px;");
        lblSpeler4.setStyle("-fx-font-size: 15px;");
        
        
        Label lblLijstSpelers = new Label(taal.getProperty(taalKeuze + "LijstSpelers"));
        lblLijstSpelers.setStyle("-fx-font-size: 20px;");
        
        GridPane.setColumnSpan(lblLijstSpelers, 3);
        GridPane.setColumnSpan(lblSpeler, 2);
        GridPane.setColumnSpan(lblSpeler2, 2);
        GridPane.setColumnSpan(lblSpeler3, 2);
        GridPane.setColumnSpan(lblSpeler4, 2);
        
        Line line1 = new Line(0, 0, 300, 0); // startX, startY, endX, endY
        line1.setStrokeWidth(2); // Set the stroke width to 2 pixels
        
        Line line2 = new Line(0, 0, 300, 0); // startX, startY, endX, endY
        line1.setStrokeWidth(2); // Set the stroke width to 2 pixels
        
        Line line3 = new Line(0, 0, 300, 0); // startX, startY, endX, endY
        line1.setStrokeWidth(2); // Set the stroke width to 2 pixels
        
        Line line4 = new Line(0, 0, 300, 0); // startX, startY, endX, endY
        line1.setStrokeWidth(2); // Set the stroke width to 2 pixels
           
        Button btnVoegSpelerToe = new Button(taal.getProperty(taalKeuze + "SpelerToevoegen"));
        GridPane.setColumnSpan(btnVoegSpelerToe, 2);
        
        Button btnLogUit = new Button(taal.getProperty(taalKeuze + "LogUit"));
        GridPane.setColumnSpan(btnLogUit, 2);
        
        Button btnStartSpel = new Button(taal.getProperty( taalKeuze + "StartSpel"));
        GridPane.setColumnSpan(btnStartSpel, 2);
                
        btnLogUit.setOnAction(this::buttonPushed);
        btnVoegSpelerToe.setOnAction(this::buttonPushed2);
        btnStartSpel.setOnAction(this::buttonPushed4);
        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        hbox.getChildren().add(btnVoegSpelerToe);
        hbox.getChildren().add(btnStartSpel);
        hbox.getChildren().add(btnLogUit);
        
        this.getChildren().add(lblLijstSpelers);
        this.getChildren().add(line1);
        this.getChildren().add(lblSpeler);      
        this.getChildren().add(line2);
        this.getChildren().add(lblSpeler2);
        this.getChildren().add(line3);
        this.getChildren().add(lblSpeler3);
        this.getChildren().add(line4);              
        this.getChildren().add(lblSpeler4);
        this.getChildren().add(hbox);
        lblSpeler4.setPadding(new Insets(0,0,30,0));
        
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
    	
    	if(spelers.size() == 4)
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "LobbyVol"));
    		alert.showAndWait();
    	}else {
    		
    		dialog = new TextInputDialog();
    		dialog.setTitle(taal.getProperty(taalKeuze + "Dialoog"));
    		dialog.setHeaderText(taal.getProperty(taalKeuze + "SpelerToevoegen"));
    		dialog.setContentText(taal.getProperty(taalKeuze + "StandaardTekst"));
    		dialog.show();
    		
    		Button btnAccepteer = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
    		btnAccepteer.setOnAction(this::buttonPushed3);
    		    	}
    	
    	
    }
    
    private void buttonPushed3(ActionEvent event) {
    	resultaatDialoog = dialog.getResult();
    	
    	if(!repo.bestaatSpeler(resultaatDialoog)) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "FoutUsername"));
    		alert.setContentText(taal.getProperty(taalKeuze + "GeldigeUsername"));
    		alert.showAndWait();
    	}else {
    		
    		if(resultaatDialoog.toLowerCase().equals(lblSpeler.getText().toString().toLowerCase())  
    				|| resultaatDialoog.toLowerCase().equals(lblSpeler2.getText().toString().toLowerCase()) 
    				|| resultaatDialoog.toLowerCase().equals(lblSpeler3.getText().toString().toLowerCase()) 
    				|| resultaatDialoog.toLowerCase().equals(lblSpeler4.getText().toString().toLowerCase()))
    		{
    			Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
        		alert.setHeaderText(taal.getProperty(taalKeuze + "SpelerAlInSpel"));
        		alert.showAndWait();
    		}else {
    			spelers.add(mapper.geefSpeler(resultaatDialoog));
    			if(lblSpeler2.getText().isEmpty())
        		{
        			lblSpeler2.setText(spelers.get(1).getUsername());
        		}else {
        			if(lblSpeler3.getText().isEmpty())
            		{
            			lblSpeler3.setText(spelers.get(2).getUsername()); 
            	        
            		}else {
            			if(lblSpeler4.getText().isEmpty())
                		{
                			lblSpeler4.setText(spelers.get(3).getUsername()); 
               			}
           			}
       			}    			
    		}
    	}
	}
    
    private void buttonPushed4(ActionEvent event) { 
    	if(spelers.size()<2)
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSpelers"));
    		alert.showAndWait();
    	}
    	else{
    		Spelbord Sb = new Spelbord(taalKeuze, spelers, dc);
    		Scene scene = new Scene(Sb, 1280, 720);
			Stage stage = (Stage) this.getScene().getWindow();
		    stage.setScene(scene);
		    stage.show();
		    stage.close();
    		
    	}
    }
}

