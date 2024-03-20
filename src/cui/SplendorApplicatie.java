package cui;

import domein.DomeinController;
import domein.Spel;
import domein.Speler;
import dto.SpelerDTO;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.ResourceBundle;

public class SplendorApplicatie
{
	private boolean isAangemeld = false;
	int keuze = 0;
	private final DomeinController dc;
	private Scanner s = new Scanner(System.in);
	private String taalKeuze = "";
	private static String padTaal ="src/talen/taal.properties";
	
	static final Properties taal = new Properties();
	 static {
	        try {
	            taal.load(new FileInputStream(padTaal));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    };
	
	public SplendorApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
	
	public void kiesTaal()
	{
		
		dc.geefKaartNiveau1(taalKeuze);
		geefTaalKeuze();
		
		switch(keuze)
		{
		 case 1 -> taalKeuze = "nederlands";
		 case 2 -> taalKeuze = "engels";
		 case 3 -> taalKeuze = "frans";
		}
		startMenu(false);
		
		
	}
	public void startMenu(boolean aangemeld)
	{
		
		if(aangemeld)
		{
			
			geefKeuzeUitMenu();
			
			switch(keuze)
			{
			case 1 -> voegSpelerToe();
			case 2 -> uitloggen();
			case 3 -> startNieuwSpel();
			case 4 -> spelerToevoegen();
			}
		}else {
			
			geefKeuzeUitMenu();
			
			switch(keuze)
			{
			case 1 -> voegSpelerToe();
			case 2 -> inloggen();
			case 3 -> startNieuwSpel();
			case 4 -> spelerToevoegen();
			}
		}
		
	}
	


	private void uitloggen() {
		isAangemeld = false;
		startMenu(isAangemeld);
	}


	private void startNieuwSpel() {
		
		dc.infoSpeler(taalKeuze);
		dc.startSpel();
		
		do
		{
			keuze = geefKeuzeUitMenuSpel();
			
			switch(keuze)
			{
			case 1 -> neemKaart();
			case 2 -> neemGems();
			}
			
		}
		while (keuze!=2);
		
	}

	private void neemGems() {
	  
	}




	private void neemKaart() {
		
	}


	private void inloggen() {
		int geboortejaar;
		 String username;
		 
		 s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "InloggenUsername"));
		 username = s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "InloggenGeboorteJaar"));
		 geboortejaar = s.nextInt();
		 dc.meldAan(username, geboortejaar);
		 dc.voegSpeler(username, geboortejaar);
		 isAangemeld = true;
		 startMenu(isAangemeld);
	}




	private void voegSpelerToe() {
		 s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenVoornaam"));
		 String voornaam = s.nextLine();		 
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenAchternaam"));
		 String achternaam = s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenUsername"));
		 String username = s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenGeboortejaar"));
		 int geboortejaar = s.nextInt();
		 
		 if(dc.controleerSpeler(username))
		 {
			 System.out.print(taal.getProperty(taalKeuze + "FoutmeldingSpelerbestaat"));
			 
		 }
		 else
		 {
			 dc.registreer(username,  voornaam,  achternaam,  geboortejaar);
			 System.out.println(taal.getProperty(taalKeuze + "SpelerToevoegenGeregistreerd"));
		 }
		 dc.voegSpeler(username, geboortejaar);
		 startMenu(isAangemeld);
		 
	}
	
	private void spelerToevoegen() {
		 s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenUsername"));
		 String username = s.nextLine();
		 System.out.print(taal.getProperty(taalKeuze + "SpelerToevoegenGeboortejaar"));
		 int geboortejaar = s.nextInt();
		if(dc.controleerSpeler(username))
		 {
			 System.out.print(taal.getProperty(taalKeuze + "SpelerBestaat"));
			 dc.voegSpeler(username, geboortejaar);
			 
		 }else
		 {
			 System.out.println(taal.getProperty(taalKeuze + "FoutmeldingSpelerbestaatniet"));
		 }
		
		startMenu(isAangemeld);
	}

	public int geefKeuzeUitMenu()
	{
		
		if(!isAangemeld)
		{
			try
			{
					System.out.println(taal.getProperty(taalKeuze + "KiesUit"));
					System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze1"));
					System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze2"));
					System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze3"));
					System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze6"));
					System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze4"));
					System.out.print(taal.getProperty(taalKeuze + "JeKeuzeIs"));
	        		keuze = s.nextInt();
				if(keuze>4 || keuze<1)
				{
					throw new IllegalArgumentException(taal.getProperty(taalKeuze + "FoutmeldingGetalTussen1en4"));
				}				
			}
			catch(InputMismatchException e )
			{
				System.out.println(taal.getProperty(taalKeuze + "FoutmeldingGeheelGetal"));
				s.nextLine();
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
				geefKeuzeUitMenu();
			}
			}else {
				try
				{
						System.out.println(taal.getProperty(taalKeuze + "KiesUit"));
						System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze1"));
						System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze5"));
						System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze3"));
						System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze6"));
						System.out.println(taal.getProperty(taalKeuze + "HoofdMenuKeuze4"));
						System.out.print(taal.getProperty(taalKeuze + "JeKeuzeIs"));
		        		keuze = s.nextInt();
					if(keuze>4 || keuze<1)
					{
						throw new IllegalArgumentException(taal.getProperty(taalKeuze + "FoutmeldingGetalTussen1en4"));
					}				
				}
				catch(InputMismatchException e )
				{
					System.out.println(taal.getProperty(taalKeuze + "FoutmeldingGeheelGetal"));
					s.nextLine();
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
					geefKeuzeUitMenu();
			}
		}
				return keuze;
	}
	
	public int geefKeuzeUitMenuSpel()
	{
		try
		{
			System.out.println(taal.getProperty(taalKeuze + "KiesUit"));
			System.out.println(taal.getProperty(taalKeuze + "MenuSpelKeuze4"));
			System.out.println(taal.getProperty(taalKeuze + "MenuSpelKeuze5"));
			System.out.println(taal.getProperty(taalKeuze + "MenuSpelKeuze6"));
			System.out.print(taal.getProperty(taalKeuze + "JeKeuzeIs"));
        	keuze = s.nextInt();
			if(keuze>6 || keuze<1)
			{
				throw new IllegalArgumentException(taal.getProperty(taalKeuze + "FoutmeldingGetalTussen1en6"));
			}
		}
		catch(InputMismatchException e )
		{
			System.out.println(taal.getProperty(taalKeuze + "FoutmeldingGeheelGetal"));
			s.nextLine();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			geefKeuzeUitMenu();
		}
	return keuze;
	}
	
	public int geefTaalKeuze()
	{
		try
		{
			System.out.println("Kies uit:");
			System.out.println("1. Nederlands ");
			System.out.println("2. English ");
			System.out.println("3. Français ");
			System.out.print("Je keuze is: ");
        	keuze = s.nextInt();
			if(keuze>3 || keuze<1)
			{
				throw new IllegalArgumentException("voer een getal tussen 1 en 3");
			}
		}
		catch(InputMismatchException e )
		{
			System.out.println("Voer een geheel getal in");
			s.nextLine();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			geefKeuzeUitMenu();
		}
	return keuze;
	}
	
}