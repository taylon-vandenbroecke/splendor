package gui;

import java.io.FileInputStream;
import java.util.Properties;

import domein.DomeinController;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import persistentie.SpelerMapper;


public class LoginScherm extends GridPane {
    private Label lblBericht;
    private Label lblBericht2;
    private TextField txfGebruiker;
    private TextField txfGeboortejaar;
    private String taalKeuze;
    private static String padTaal = "src/talen/taal.properties";
    private DomeinController dc;
    private final SpelerMapper mapper;
    
    static final Properties taal = new Properties();
    static {
    	try {
    		taal.load(new FileInputStream(padTaal));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public LoginScherm(String taalKeuze, DomeinController dc) {
    	this.taalKeuze = taalKeuze;
    	this.dc = dc;
    	mapper = new SpelerMapper();
    	
    	this.setAlignment(Pos.CENTER);      
        this.setHgap(10);        
        this.setVgap(10); 
      
        this.setPadding(new Insets(25, 25, 25, 25)); 

        Label lblTitel = new Label(taal.getProperty(taalKeuze + "Welkom"));
        lblTitel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));     
        this.add(lblTitel, 0, 0, 2, 1); 

        Label lblGebruikersnaam = new Label(taal.getProperty(taalKeuze + "Gebruikersnaam"));
        this.add(lblGebruikersnaam, 0, 1);

        txfGebruiker = new TextField();
        this.add(txfGebruiker, 1, 1);

        Label lblBirthyear = new Label(taal.getProperty(taalKeuze + "Geboortejaar"));
        this.add(lblBirthyear, 0, 2);

        txfGeboortejaar = new TextField();
        this.add(txfGeboortejaar, 1, 2);

        Tooltip tooltip = new Tooltip();
        tooltip.setText(taalKeuze + "GeboortejaarFout");
        txfGeboortejaar.setTooltip(tooltip);

        Button btnLogIn = new Button(taal.getProperty(taalKeuze + "LogIn"));

        setHalignment(btnLogIn, HPos.LEFT); 
        this.add(btnLogIn, 0, 4);

        Button btnAnnuleer = new Button(taal.getProperty(taalKeuze + "Annuleer"));

        setHalignment(btnAnnuleer, HPos.RIGHT); 
        this.add(btnAnnuleer, 1, 4);

        lblBericht = new Label();
        this.add(lblBericht, 0, 6);
        GridPane.setColumnSpan(lblBericht, 2);
  
        btnLogIn.setOnAction(this::buttonPushed);
        btnAnnuleer.setOnAction(this::buttonPushed2);
     } 
    
     private void buttonPushed(ActionEvent event) {
    	boolean isFout = false;
    	if(mapper.geefSpeler(txfGebruiker.getText()) != null)
    	{
    		if(mapper.geefSpeler(txfGebruiker.getText()).getGeboortejaar() == Integer.parseInt(txfGeboortejaar.getText()))
   			{
    			isFout = false;
    			dc.meldAan(txfGebruiker.getText(), Integer.parseInt(txfGeboortejaar.getText()));
    		}
    		else {
    			isFout = true;
    			lblBericht.setText(taal.getProperty(taalKeuze + "FoutGeboortejaar"));
    		}
    	}
    	else {
    		isFout = true;
    		lblBericht.setText(taal.getProperty(taalKeuze + "FoutUsername"));
    	}
    	if(isFout == false) {
    		Speler speler = mapper.geefSpeler(txfGebruiker.getText());
    		speler.setAanDeBeurt(true);
    		MenuScherm ms = new MenuScherm(taalKeuze, speler); 
    	    Scene scene = new Scene(ms, 400, 500);
    		Stage stage = (Stage) this.getScene().getWindow();
    	    stage.setScene(scene);
    	    stage.centerOnScreen();
    	    stage.show();
    	}
    	isFout = false;
    	
     }
     
     private void buttonPushed2(ActionEvent event) {
    	 BeginScherm bs = new BeginScherm(taalKeuze); // <1>
		    Scene scene = new Scene(bs, 400, 200);
			Stage stage = (Stage) this.getScene().getWindow();
		    stage.setScene(scene);
		    stage.centerOnScreen();
		    stage.show();
     }

}
