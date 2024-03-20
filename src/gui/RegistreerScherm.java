package gui;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import domein.DomeinController;
import domein.Speler;
import domein.SpelerRepository;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import persistentie.SpelerMapper;

public class RegistreerScherm extends GridPane{
	private static String padTaal = "src/talen/taal.properties";
	private String taalKeuze;
	private DomeinController dc;
	private SpelerMapper mapper;
	private SpelerRepository repo;
	private TextField txfVoornaam;
	private TextField txfAchternaam;
	private TextField txfGeboortejaar;
	private TextField txfGebruikersnaam;
	private Label lblBericht;
	
	static final Properties taal = new Properties();
	static {
		try {
			taal.load(new FileInputStream(padTaal));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public RegistreerScherm(String taalKeuze, DomeinController dc){
        
		mapper = new SpelerMapper();
		this.taalKeuze = taalKeuze;
		this.dc = dc;
		repo = new SpelerRepository();
		
		this.setAlignment(Pos.CENTER);      
        this.setHgap(10);        
        this.setVgap(10); 
      
        this.setPadding(new Insets(25, 25, 25, 25)); 
        this.setPadding(new Insets(25, 25, 25, 25)); 
		
		Label lblVoornaam = new Label(taal.getProperty(taalKeuze + "Voornaam"));
		this.add(lblVoornaam, 1, 0);
		
		txfVoornaam = new TextField();
	    this.add(txfVoornaam, 2, 0);
		
		Label lblAchternaam = new Label(taal.getProperty(taalKeuze + "Achternaam"));
		this.add(lblAchternaam, 1, 1);
		
		txfAchternaam = new TextField();
	    this.add(txfAchternaam, 2, 1);
		
		Label lblGeboortejaar = new Label(taal.getProperty(taalKeuze + "Geboortejaar"));
		this.add(lblGeboortejaar, 1, 2);
		
		txfGeboortejaar = new TextField();
	    this.add(txfGeboortejaar, 2, 2);
		
		Label lblGebruikersnaam = new Label(taal.getProperty(taalKeuze + "Gebruikersnaam"));
		this.add(lblGebruikersnaam, 1, 3);
		
		txfGebruikersnaam = new TextField();
	    this.add(txfGebruikersnaam, 2, 3);
	    
	    Button btnRegistreer = new Button(taal.getProperty(taalKeuze + "Registreer"));
	    this.add(btnRegistreer, 1, 4);
	    btnRegistreer.setOnAction(this::buttonPushed);
	    
	    lblBericht = new Label();
	    this.add(lblBericht, 1, 5);
	    GridPane.setColumnSpan(lblBericht, 2); // set label to span 2 columns
	    
	    Button btnAnnuleer = new Button(taal.getProperty(taalKeuze + "Annuleer"));
	    setHalignment(btnAnnuleer, HPos.RIGHT); 
	    this.add(btnAnnuleer, 2, 4);
	    btnAnnuleer.setOnAction(this::buttonPushed2);
	    
	}
	
	private void buttonPushed(ActionEvent event) {
		LocalDate currentdate = LocalDate.now();
		
		
		if(!repo.bestaatSpeler(txfGebruikersnaam.getText()))	
		{
			if(txfVoornaam.getText().isBlank())
			{
				lblBericht.setText(taal.getProperty(taalKeuze + "LegeVoornaam"));
			}else {
				if(txfAchternaam.getText().isBlank())
				{
					lblBericht.setText(taal.getProperty(taalKeuze + "LegeAchternaam"));
				}else {
					if(txfGebruikersnaam.getText().isBlank())
					{
						lblBericht.setText(taal.getProperty(taalKeuze + "LegeGebruikersnaam"));
					}else {
						if(txfGeboortejaar.getText().isBlank())
						{
							lblBericht.setText(taal.getProperty(taalKeuze + "LeegGeboortejaar"));
						}else {
							if(Integer.parseInt(txfGeboortejaar.getText()) > currentdate.getYear() - 6)
							{
								lblBericht.setText(taal.getProperty(taalKeuze + "TeJong"));
							}else {
								Speler speler = new Speler(Integer.parseInt(txfGeboortejaar.getText()), txfVoornaam.getText(), txfAchternaam.getText(), txfGebruikersnaam.getText(), true);
								mapper.voegToe(speler);
								MenuScherm ms = new MenuScherm(taalKeuze, speler); 
							    Scene scene = new Scene(ms, 400, 720);
								Stage stage = (Stage) this.getScene().getWindow();
							    stage.setScene(scene);
							    stage.centerOnScreen();
							    stage.show();
							}
						}
					}
				}
			}
		}else {
			lblBericht.setText(taal.getProperty(taalKeuze + "BestaandAcc"));
		}
			
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
