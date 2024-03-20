package gui;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domein.Speler;
import domein.SpelerRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import persistentie.SpelerMapper;
import domein.DomeinController;
import domein.Edele;
import domein.Edelsteen;
import domein.Kaart;
import domein.Spel;
import util.Kleur;

public class Spelbord extends BorderPane {
    
    private String taalKeuze;
    private Speler huidigeSpeler;
    
    private List<Speler> spelers = new ArrayList<>();
    private DomeinController dc;
    private Spel spelInfo;

    private VBox VboxRechts;
    private VBox VboxSpeler1;
    private VBox VboxSpeler2;
    private VBox VboxSpeler3;
    private VBox VboxSpeler4;
    
    private HBox HboxKaartenSpeler1 = new HBox();
    private HBox HboxKaartenSpeler2 = new HBox();
    private HBox HboxKaartenSpeler3 = new HBox();
    private HBox HboxKaartenSpeler4 = new HBox();
    
    private GridPane grid;
    private GridPane gridCenter;
    private GridPane gridRechts;
    
    private List<Edelsteen> genomenEdelstenen;
    private int aantalWitteInBeurt;
    private int aantalBlauweInBeurt;
    private int aantalGroeneInBeurt;
    private int aantalZwarteInBeurt;
    private int aantalRodeInBeurt;
        
    private boolean edele1Gekocht = false;
    private boolean edele2Gekocht = false;
    private boolean edele3Gekocht = false;
    private boolean edele4Gekocht = false;
    
    private Label lblWit;
    private Label lblBlauw;
    private Label lblGroen;
    private Label lblZwart;
    private Label lblRood;
    
    private Label lblWit2;
    private Label lblBlauw2;
    private Label lblGroen2;
    private Label lblZwart2;
    private Label lblRood2;

    private Label lblWit3;
    private Label lblBlauw3;
    private Label lblGroen3;
    private Label lblZwart3;
    private Label lblRood3;
    
    private Label lblWit4;
    private Label lblBlauw4;
    private Label lblGroen4;
    private Label lblZwart4;
    private Label lblRood4;
    
    private Button btnWit;
    private Button btnBlauw;
    private Button btnGroen;
    private Button btnZwart;
    private Button btnRood;
    
    private Button btnPas;
    private Button btnStop;
    private Button btnVoeg15Toe;
    
    
    private Button btnEdele1 = new Button();
    private Button btnEdele2 = new Button();
    private Button btnEdele3 = new Button();
    private Button btnEdele4 = new Button();
    
    private Button btnKaart1;
    private Button btnKaart2;
    private Button btnKaart3;
    private Button btnKaart4;
    private Button btnKaart5;
    private Button btnKaart6;
    private Button btnKaart7;
    private Button btnKaart8;
    private Button btnKaart9;
    
    private Label lblSpelerR1;
    private Label lblSpelerR2;
    private Label lblSpelerR3;
    private Label lblSpelerR4;
    
    private Label lblSpeler;
    private Label lblSpeler1Punten;
    private Label lblSpelerTop;
    private Label lblSpelerAanDeBeurtTop;
    private Label lblSpeler2;
    private Label lblSpeler2Punten;
    private Label lblSpeler3;
    private Label lblSpeler4;
    private Label lblSpeler3Punten;
    private Label lblSpeler4Punten;
    
    private Edelsteen Wit;
    private Edelsteen Rood;
    private Edelsteen Zwart;
    private Edelsteen Blauw;
    private Edelsteen Groen;
    private List<Edelsteen> voorraad;
    private List<Kaart> kaartenNiveau1;
    private List<Kaart> kaartenNiveau2;
    private List<Kaart> kaartenNiveau3;
    private List<Edele> edelen;
    
    private int getal = 0;
    private int puntenSpeler1 = 0;
    private int puntenSpeler2 = 0;
    private int puntenSpeler3 = 0;
    private int puntenSpeler4 = 0;
    
    private int speler1Wit;
    private int speler1Rood;
    private int speler1Zwart;
    private int speler1Blauw;
    private int speler1Groen;
    
    private int speler2Wit;
    private int speler2Rood;
    private int speler2Zwart;
    private int speler2Blauw;
    private int speler2Groen;
    
    private int speler3Wit;
    private int speler3Rood;
    private int speler3Zwart;
    private int speler3Blauw;
    private int speler3Groen;
    
    private int speler4Wit;
    private int speler4Rood;
    private int speler4Zwart;
    private int speler4Blauw;
    private int speler4Groen;
    
    private int hulp0niveau1;
    private int hulp1niveau1;
    private int hulp2niveau1;
    
    private int hulp0niveau2;
    private int hulp1niveau2;
    private int hulp2niveau2;
    
    private int hulp0niveau3;
    private int hulp1niveau3;
    private int hulp2niveau3;	
    
    private int hulpEdele1;
    private int hulpEdele2;
    private int hulpEdele3;
    private int hulpEdele4;
    
    private List<Image> gekochteKaartenSpeler1;
    private List<Image> gekochteKaartenSpeler2;
    private List<Image> gekochteKaartenSpeler3;
    private List<Image> gekochteKaartenSpeler4;
    
    private List<Kaart> kaartenSpeler1;
    private List<Kaart> kaartenSpeler2;
    private List<Kaart> kaartenSpeler3;
    private List<Kaart> kaartenSpeler4;
   
    

    private static String padTaal = "src/talen/taal.properties";
    static final Properties taal = new Properties();
    static {
        try {
            taal.load(new FileInputStream(padTaal));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public Spelbord(String taalKeuze, List<Speler> spelerslijst, DomeinController dc) {
        this.taalKeuze = taalKeuze;
        new SpelerRepository();
        new SpelerMapper();
        this.spelers.addAll(spelerslijst);
        this.dc = dc;
        
        huidigeSpeler = spelers.get(getal);
        
        genomenEdelstenen = new ArrayList<Edelsteen>();
        aantalWitteInBeurt = 0;
        aantalGroeneInBeurt = 0;
        aantalBlauweInBeurt = 0;
        aantalZwarteInBeurt = 0;
        aantalRodeInBeurt = 0;
        
        spelInfo = new Spel();
        voorraad = new ArrayList<>();
        voorraad = spelInfo.getResterendeVoorraad();
        kaartenNiveau1 = dc.geefKaartNiveau1(taalKeuze);
        kaartenNiveau2 = dc.geefKaartNiveau2(taalKeuze);
        kaartenNiveau3 = dc.geefKaartNiveau3(taalKeuze);
        
        edelen = dc.geefEdelen(taalKeuze);
        
        Wit = voorraad.get(0);
        Rood = voorraad.get(1);
        Zwart = voorraad.get(2);
        Blauw = voorraad.get(3);
        Groen = voorraad.get(4);
        
        btnKaart1 = new Button();
        btnKaart2 = new Button();
        btnKaart3 = new Button();
        btnKaart4 = new Button();
        btnKaart5 = new Button();
        btnKaart6 = new Button();
        btnKaart7 = new Button();
        btnKaart8 = new Button();
        btnKaart9 = new Button();
        
        gekochteKaartenSpeler1 = new ArrayList<>();
        gekochteKaartenSpeler2 = new ArrayList<>();
        gekochteKaartenSpeler3 = new ArrayList<>();
        gekochteKaartenSpeler4= new ArrayList<>();
        
         hulp0niveau1 = 0;
         hulp1niveau1 = 1;
         hulp2niveau1 = 2;
         
         hulp0niveau2 = 0;
         hulp1niveau2 = 1;
         hulp2niveau2 = 2;
         
         hulp0niveau3 = 0;
         hulp1niveau3 = 1;
         hulp2niveau3 = 2;	
         
         hulpEdele1 = 0;
         hulpEdele2 = 1;
         hulpEdele3 = 2;
         hulpEdele4 = 3;
         
         lblSpeler1Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
         lblSpeler2Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
         lblSpeler3Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
         lblSpeler4Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
         
         HboxKaartenSpeler1.setSpacing(5);
         HboxKaartenSpeler2.setSpacing(5);
         HboxKaartenSpeler3.setSpacing(5);
         HboxKaartenSpeler4.setSpacing(5);
         
         
         
        buildGui();
    }

    private void buildGui() {
        // create labels for player usernames and turns
        lblSpeler = new Label(spelers.get(0).getUsername());
        lblSpelerTop = new Label(spelers.get(0).getUsername());
        lblSpelerR1 = lblSpeler = new Label(spelers.get(0).getUsername());
        lblSpelerAanDeBeurtTop = new Label(taal.getProperty(taalKeuze + "AanDeBeurt"));
        lblSpeler2 = new Label(spelers.get(1).getUsername());
        lblSpelerR2 = new Label(spelers.get(1).getUsername());
        if(spelers.size() == 3) {
        	lblSpeler3 = new Label(spelers.get(2).getUsername());
        	lblSpelerR3 = new Label(spelers.get(2).getUsername());
        	lblSpeler3Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
        }else if (spelers.size() == 4) {
        	lblSpeler3 = new Label(spelers.get(2).getUsername());
        	lblSpelerR3 = new Label(spelers.get(2).getUsername());
        	lblSpeler3Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
        	lblSpeler4 = new Label(spelers.get(3).getUsername());
        	lblSpelerR4 = new Label(spelers.get(3).getUsername());
        	lblSpeler4Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
        }
        
        
        
        // create gridpane for cards and buttons
        GridPane centerPane = new GridPane();
        
        
        // create listview for player's cards
        
        List<Kaart> SpelerKaarten = new ArrayList<>();
        if(spelers.get(0).getKaarten() == null || spelers.get(0).getKaarten().isEmpty()) {
        	
        }else {
        	SpelerKaarten.addAll(dc.toonKaartenVanSpeler(spelers.get(0)));
        }
        
        ObservableList<Kaart> items = FXCollections.observableArrayList(SpelerKaarten);

        ListView<Kaart> listView = new ListView<>();
        listView.getItems().addAll(items);
        centerPane.add(listView, 1, 0);
        
       
        
        // add labels to borderpane
        BorderPane root = new BorderPane();
        root.setTop(buildTopPane());
        root.setCenter(buildCenterPane());
        root.setLeft(buildLeftPane());
        root.setRight(buildRightPane());
        //root.setCenter(centerPane);
        
        // create scene and stage
        Scene scene = new Scene(root, 1350, 780);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    
    private HBox buildTopPane() {
        HBox hbox = new HBox();
        hbox.getStyleClass().add("pane");
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #151B54;");

        lblSpelerTop.setTextFill(Color.WHITE);
        lblSpelerTop.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        lblSpelerAanDeBeurtTop.setTextFill(Color.WHITE);
        lblSpelerAanDeBeurtTop.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        hbox.getChildren().addAll(lblSpelerTop, lblSpelerAanDeBeurtTop);

        return hbox;
    }

    private GridPane buildCenterPane() {
        gridCenter = new GridPane();
        gridCenter.getStyleClass().add("pane");
        gridCenter.setPadding(new Insets(15, 12, 15, 12));
        gridCenter.setVgap(5);
        gridCenter.setHgap(5);
        
        Image backgroundImg = new Image(this.getClass().getResourceAsStream("/images/bluebackground.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(backgroundImg,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );

        // Create a new Background object with the background image
        Background background = new Background(backgroundImage);
        
        // Set the background of the GridPane
        gridCenter.setBackground(background);

        
        
        
        // Kaarten niveaus
        Image niveau01 = new Image(this.getClass().getResourceAsStream("/images/niveau1.jpg"));
        ImageView niveau1 = new ImageView(niveau01);
        double newWidth = 120; 
        double newHeight = 145;
        niveau1.setFitWidth(newWidth);
        niveau1.setFitHeight(newHeight);
        
        Image niveau02 = new Image(this.getClass().getResourceAsStream("/images/niveau2.jpg"));
        ImageView niveau2 = new ImageView(niveau02);
        niveau2.setFitWidth(newWidth);
        niveau2.setFitHeight(newHeight);
        
        Image niveau03 = new Image(this.getClass().getResourceAsStream("/images/niveau3.jpg"));
        ImageView niveau3 = new ImageView(niveau03);
        niveau3.setFitWidth(newWidth);
        niveau3.setFitHeight(newHeight);
        
        
        Button btnNiveau1 = new Button();
        btnNiveau1.setGraphic(niveau1);
        btnNiveau1.setStyle("-fx-background-color: transparent;");
        Button btnNiveau2 = new Button();
        btnNiveau2.setGraphic(niveau2);
        btnNiveau2.setStyle("-fx-background-color: transparent;");
        Button btnNiveau3 = new Button();
        btnNiveau3.setGraphic(niveau3);
        btnNiveau3.setStyle("-fx-background-color: transparent;");
        
  	  //Image Edele01 = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(0).getKaartID()+".jpg"));
        /*Image Edele01 = new Image(this.getClass().getResourceAsStream("/images/edele_1.jpg"));
        ImageView edele1 = new ImageView(Edele01);
        edele1.setFitWidth(newWidth);
        edele1.setFitHeight(newHeight);
        gridCenter.getChildren().remove(btnEdele1);
        btnEdele1 = new Button();
        btnEdele1.setGraphic(edele1); */
        
        Image Edele01 = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(0).getKaartID()+".jpg"));
        ImageView edele1 = new ImageView(Edele01);
        edele1.setFitWidth(newWidth);
        edele1.setFitHeight(newHeight);
        
        //Button btnEdele1 = new Button();
        btnEdele1.setGraphic(edele1);
        btnEdele1.setStyle("-fx-background-color: transparent;");
        btnEdele1.setOnAction(this::buttonPushedEdele1);
        
        gridCenter.add(btnEdele1, 0, 0);
        
        Image Edele02 = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(1).getKaartID()+".jpg"));
        ImageView edele2 = new ImageView(Edele02);
        edele2.setFitWidth(newWidth);
        edele2.setFitHeight(newHeight);
        
        //Button btnEdele2 = new Button();
        btnEdele2.setGraphic(edele2);
        btnEdele2.setStyle("-fx-background-color: transparent;");
        btnEdele2.setOnAction(this::buttonPushedEdele2);
      
        gridCenter.add(btnEdele2, 1, 0);
        
        Image Edele03 = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(2).getKaartID()+".jpg"));
        ImageView edele3 = new ImageView(Edele03);
        edele3.setFitWidth(newWidth);
        edele3.setFitHeight(newHeight);
        
        //Button btnEdele3 = new Button();
        btnEdele3.setGraphic(edele3);
        btnEdele3.setStyle("-fx-background-color: transparent;");
        btnEdele3.setOnAction(this::buttonPushedEdele3);
      
        gridCenter.add(btnEdele3, 2, 0);
        
        Image Edele04 = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(3).getKaartID()+".jpg"));
        ImageView edele4 = new ImageView(Edele04);
        edele4.setFitWidth(newWidth);
        edele4.setFitHeight(newHeight);
        
        //Button btnEdele4 = new Button();
        btnEdele4.setGraphic(edele4);
        btnEdele4.setStyle("-fx-background-color: transparent;");
        btnEdele4.setOnAction(this::buttonPushedEdele4);
      
        gridCenter.add(btnEdele4, 3, 0);
        
        // Kaarten niveau 1
        
        Image kaart01 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(0).getKaartID()+".jpg"));
        ImageView kaart1 = new ImageView(kaart01);
        kaart1.setFitWidth(newWidth);
        kaart1.setFitHeight(newHeight);
        
        
        Image kaart02 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(1).getKaartID()+".jpg"));
        ImageView kaart2 = new ImageView(kaart02);
        kaart2.setFitWidth(newWidth);
        kaart2.setFitHeight(newHeight);
        
        Image kaart03 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(2).getKaartID()+".jpg"));
        ImageView kaart3 = new ImageView(kaart03);
        kaart3.setFitWidth(newWidth);
        kaart3.setFitHeight(newHeight);
        
        
        Button btnKaart1 = new Button();
        btnKaart1.setOnAction(this::buttonPushedKoopKaart0);
        btnKaart1.setGraphic(kaart1);
        btnKaart1.setStyle("-fx-background-color: transparent;");
        Button btnKaart2 = new Button();
        btnKaart2.setOnAction(this::buttonPushedKoopKaart1);
        btnKaart2.setGraphic(kaart2);
        btnKaart2.setStyle("-fx-background-color: transparent;");
        Button btnKaart3 = new Button();
        btnKaart3.setOnAction(this::buttonPushedKoopKaart2);
        btnKaart3.setGraphic(kaart3);
        btnKaart3.setStyle("-fx-background-color: transparent;");
        
        
        // Kaarten niveau 2
        
        
        Image kaart04 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(0).getKaartID()+".jpg"));
        ImageView kaart4 = new ImageView(kaart04);
        kaart4.setFitWidth(newWidth);
        kaart4.setFitHeight(newHeight);
        
        Image kaart05 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(1).getKaartID()+".jpg"));
        ImageView kaart5 = new ImageView(kaart05);
        kaart5.setFitWidth(newWidth);
        kaart5.setFitHeight(newHeight);
        
        Image kaart06 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(2).getKaartID()+".jpg"));
        ImageView kaart6 = new ImageView(kaart06);
        kaart6.setFitWidth(newWidth);
        kaart6.setFitHeight(newHeight);
        
        Button btnKaart4 = new Button();
        btnKaart4.setOnAction(this::buttonPushedKoopKaart3);
        btnKaart4.setGraphic(kaart4);
        btnKaart4.setStyle("-fx-background-color: transparent;");
        Button btnKaart5 = new Button();
        btnKaart5.setOnAction(this::buttonPushedKoopKaart4);
        btnKaart5.setGraphic(kaart5);
        btnKaart5.setStyle("-fx-background-color: transparent;");
        Button btnKaart6 = new Button();
        btnKaart6.setOnAction(this::buttonPushedKoopKaart5);
        btnKaart6.setGraphic(kaart6);
        btnKaart6.setStyle("-fx-background-color: transparent;");
        
        
        // Kaarten niveau 3
        
        Image kaart07 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(0).getKaartID()+".jpg"));
        ImageView kaart7 = new ImageView(kaart07);
        kaart7.setFitWidth(newWidth);
        kaart7.setFitHeight(newHeight);
        
        Image kaart08 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(1).getKaartID()+".jpg"));
        ImageView kaart8 = new ImageView(kaart08);
        kaart8.setFitWidth(newWidth);
        kaart8.setFitHeight(newHeight);
        
        Image kaart09 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(2).getKaartID()+".jpg"));
        ImageView kaart9 = new ImageView(kaart09);
        kaart9.setFitWidth(newWidth);
        kaart9.setFitHeight(newHeight);
        
        Button btnKaart7 = new Button();
        btnKaart7.setOnAction(this::buttonPushedKoopKaart6);
        btnKaart7.setGraphic(kaart7);
        btnKaart7.setStyle("-fx-background-color: transparent;");
        Button btnKaart8 = new Button();
        btnKaart8.setOnAction(this::buttonPushedKoopKaart7);
        btnKaart8.setGraphic(kaart8);
        btnKaart8.setStyle("-fx-background-color: transparent;");
        Button btnKaart9 = new Button();
        btnKaart9.setOnAction(this::buttonPushedKoopKaart8);
        btnKaart9.setGraphic(kaart9);
        btnKaart9.setStyle("-fx-background-color: transparent;");
        
        // Edelen + kaarten in bezit tonen
        
        Image imgRoodSpeler = new Image(this.getClass().getResourceAsStream("/images/rood.png"));
    	Image imgWitSpeler = new Image(this.getClass().getResourceAsStream("/images/wit.png"));
    	Image imgBlauwSpeler = new Image(this.getClass().getResourceAsStream("/images/blauw.png"));
    	Image imgGroenSpeler = new Image(this.getClass().getResourceAsStream("/images/groen.png"));
    	Image imgZwartSpeler = new Image(this.getClass().getResourceAsStream("/images/zwart.png"));
        ImageView viewRoodSpeler = new ImageView(imgRoodSpeler);
        ImageView viewWitSpeler = new ImageView(imgWitSpeler);
        ImageView viewBlauwSpeler = new ImageView(imgBlauwSpeler);
        ImageView viewGroenSpeler = new ImageView(imgGroenSpeler);
        ImageView viewZwartSpeler = new ImageView(imgZwartSpeler);
        
        Image imgRoodSpeler2 = new Image(this.getClass().getResourceAsStream("/images/rood.png"));
    	Image imgWitSpeler2 = new Image(this.getClass().getResourceAsStream("/images/wit.png"));
    	Image imgBlauwSpeler2 = new Image(this.getClass().getResourceAsStream("/images/blauw.png"));
    	Image imgGroenSpeler2 = new Image(this.getClass().getResourceAsStream("/images/groen.png"));
    	Image imgZwartSpeler2 = new Image(this.getClass().getResourceAsStream("/images/zwart.png"));
        ImageView viewRoodSpeler2 = new ImageView(imgRoodSpeler2);
        ImageView viewWitSpeler2 = new ImageView(imgWitSpeler2);
        ImageView viewBlauwSpeler2 = new ImageView(imgBlauwSpeler2);
        ImageView viewGroenSpeler2 = new ImageView(imgGroenSpeler2);
        ImageView viewZwartSpeler2 = new ImageView(imgZwartSpeler2);
        
        Image imgRoodSpeler3 = new Image(this.getClass().getResourceAsStream("/images/rood.png"));
    	Image imgWitSpeler3 = new Image(this.getClass().getResourceAsStream("/images/wit.png"));
    	Image imgBlauwSpeler3 = new Image(this.getClass().getResourceAsStream("/images/blauw.png"));
    	Image imgGroenSpeler3 = new Image(this.getClass().getResourceAsStream("/images/groen.png"));
    	Image imgZwartSpeler3 = new Image(this.getClass().getResourceAsStream("/images/zwart.png"));
        ImageView viewRoodSpeler3 = new ImageView(imgRoodSpeler3);
        ImageView viewWitSpeler3 = new ImageView(imgWitSpeler3);
        ImageView viewBlauwSpeler3 = new ImageView(imgBlauwSpeler3);
        ImageView viewGroenSpeler3 = new ImageView(imgGroenSpeler3);
        ImageView viewZwartSpeler3 = new ImageView(imgZwartSpeler3);
        
        Image imgRoodSpeler4 = new Image(this.getClass().getResourceAsStream("/images/rood.png"));
    	Image imgWitSpeler4 = new Image(this.getClass().getResourceAsStream("/images/wit.png"));
    	Image imgBlauwSpeler4 = new Image(this.getClass().getResourceAsStream("/images/blauw.png"));
    	Image imgGroenSpeler4 = new Image(this.getClass().getResourceAsStream("/images/groen.png"));
    	Image imgZwartSpeler4 = new Image(this.getClass().getResourceAsStream("/images/zwart.png"));
        ImageView viewRoodSpeler4 = new ImageView(imgRoodSpeler4);
        ImageView viewWitSpeler4 = new ImageView(imgWitSpeler4);
        ImageView viewBlauwSpeler4 = new ImageView(imgBlauwSpeler4);
        ImageView viewGroenSpeler4 = new ImageView(imgGroenSpeler4);
        ImageView viewZwartSpeler4 = new ImageView(imgZwartSpeler4);
      
        
        Image imgRood = new Image(this.getClass().getResourceAsStream("/images/token_rood.png"));
    	Image imgWit = new Image(this.getClass().getResourceAsStream("/images/token_wit.png"));
    	Image imgBlauw = new Image(this.getClass().getResourceAsStream("/images/token_blauw.png"));
    	Image imgGroen = new Image(this.getClass().getResourceAsStream("/images/token_groen.png"));
    	Image imgZwart = new Image(this.getClass().getResourceAsStream("/images/token_zwart.png"));
        new ImageView(imgRood);
        new ImageView(imgWit);
        new ImageView(imgBlauw);
        new ImageView(imgGroen);
        new ImageView(imgZwart);
        
        lblWit = new Label();
        lblWit.setGraphic(viewWitSpeler);
        lblWit.setText("0");
        lblWit.setStyle("-fx-text-fill: white;");
        
        lblRood = new Label();
        lblRood.setGraphic(viewRoodSpeler);
        lblRood.setText("0");
        lblRood.setStyle("-fx-text-fill: white;");
        
        lblZwart = new Label();
        lblZwart.setGraphic(viewZwartSpeler);
        lblZwart.setText("0");
        lblZwart.setStyle("-fx-text-fill: white;");
        
        lblBlauw = new Label();
        lblBlauw.setGraphic(viewBlauwSpeler);
        lblBlauw.setText("0");
        lblBlauw.setStyle("-fx-text-fill: white;");
        
        lblGroen = new Label();
        lblGroen.setGraphic(viewGroenSpeler);
        lblGroen.setText("0");
        lblGroen.setStyle("-fx-text-fill: white;");
        
        lblWit2 = new Label();
        lblWit2.setGraphic(viewWitSpeler2);
        lblWit2.setText("0");
        lblWit2.setStyle("-fx-text-fill: white;");
        
        lblRood2 = new Label();
        lblRood2.setGraphic(viewRoodSpeler2);
        lblRood2.setText("0");
        lblRood2.setStyle("-fx-text-fill: white;");
        
        lblZwart2 = new Label();
        lblZwart2.setGraphic(viewZwartSpeler2);
        lblZwart2.setText("0");
        lblZwart2.setStyle("-fx-text-fill: white;");
        
        lblBlauw2 = new Label();
        lblBlauw2.setGraphic(viewBlauwSpeler2);
        lblBlauw2.setText("0");
        lblBlauw2.setStyle("-fx-text-fill: white;");
        
        lblGroen2 = new Label();
        lblGroen2.setGraphic(viewGroenSpeler2);
        lblGroen2.setText("0");
        lblGroen2.setStyle("-fx-text-fill: white;");
        
        lblWit3 = new Label();
        lblWit3.setGraphic(viewWitSpeler3);
        lblWit3.setText("0");
        lblWit3.setStyle("-fx-text-fill: white;");
        
        lblRood3 = new Label();
        lblRood3.setGraphic(viewRoodSpeler3);
        lblRood3.setText("0");
        lblRood3.setStyle("-fx-text-fill: white;");
        
        lblZwart3 = new Label();
        lblZwart3.setGraphic(viewZwartSpeler3);
        lblZwart3.setText("0");
        lblZwart3.setStyle("-fx-text-fill: white;");
        
        lblBlauw3 = new Label();
        lblBlauw3.setGraphic(viewBlauwSpeler3);
        lblBlauw3.setText("0");
        lblBlauw3.setStyle("-fx-text-fill: white;");
        
        lblGroen3 = new Label();
        lblGroen3.setGraphic(viewGroenSpeler3);
        lblGroen3.setText("0");
        lblGroen3.setStyle("-fx-text-fill: white;");
        
        lblWit4 = new Label();
        lblWit4.setGraphic(viewWitSpeler4);
        lblWit4.setText("0");
        lblWit4.setStyle("-fx-text-fill: white;");
        
        lblRood4 = new Label();
        lblRood4.setGraphic(viewRoodSpeler4);
        lblRood4.setText("0");
        lblRood4.setStyle("-fx-text-fill: white;");
        
        lblZwart4 = new Label();
        lblZwart4.setGraphic(viewZwartSpeler4);
        lblZwart4.setText("0");
        lblZwart4.setStyle("-fx-text-fill: white;");
        
        lblBlauw4 = new Label();
        lblBlauw4.setGraphic(viewBlauwSpeler4);
        lblBlauw4.setText("0");
        lblBlauw4.setStyle("-fx-text-fill: white;");
        
        lblGroen4 = new Label();
        lblGroen4.setGraphic(viewGroenSpeler4);
        lblGroen4.setText("0");
        lblGroen4.setStyle("-fx-text-fill: white;");
        
        new Button("Pas");
        Button btnStop = new Button("Stop");
        btnStop.setOnAction(e -> Platform.exit());
        btnStop.setStyle("-fx-background-color: black; -fx-color: red");
         
        VboxRechts = new VBox();
        gridCenter.add(VboxRechts, 10, 0);
        GridPane.setColumnSpan(VboxRechts, 9);
        GridPane.setRowSpan(VboxRechts, 13);
        VboxRechts.setAlignment(Pos.CENTER);
        VboxRechts.setSpacing(10);  
        
        VboxRechts.getChildren().add(lblSpelerR1);
        lblSpelerR1.setStyle("-fx-text-fill: white; -fx-font-size: 12pt;");
        
        VboxSpeler1 = new VBox();
        VboxRechts.getChildren().add(VboxSpeler1);
        
        HBox HboxSpeler1 = new HBox();
        HboxSpeler1.setSpacing(10);
        HboxSpeler1.getChildren().addAll(lblWit, lblRood, lblZwart,lblBlauw,lblGroen);
        VboxSpeler1.getChildren().add(HboxSpeler1);
        
        
        VboxRechts.getChildren().add(lblSpelerR2);
        lblSpelerR2.setStyle("-fx-text-fill: white; -fx-font-size: 12pt;");
        
        VboxSpeler2 = new VBox();
        VboxRechts.getChildren().add(VboxSpeler2);
        
        HBox HboxSpeler2 = new HBox();
        HboxSpeler2.setSpacing(10);
        HboxSpeler2.getChildren().addAll(lblWit2, lblRood2, lblZwart2,lblBlauw2,lblGroen2);
        VboxSpeler2.getChildren().add(HboxSpeler2);
                
        if(spelers.size() == 3)
        {
        	VboxRechts.getChildren().add(lblSpelerR3);
        	lblSpelerR3.setStyle("-fx-text-fill: white; -fx-font-size: 12pt;");
        	
        	VboxSpeler3 = new VBox();
        	VboxRechts.getChildren().add(VboxSpeler3);
        	
        	HBox HboxSpeler3 = new HBox();
        	HboxSpeler3.setSpacing(10);
            HboxSpeler3.getChildren().addAll(lblWit3, lblRood3, lblZwart3,lblBlauw3,lblGroen3);
            VboxSpeler3.getChildren().add(HboxSpeler3);
      
        }
        
        if(spelers.size() == 4)
        {
        	VboxRechts.getChildren().add(lblSpelerR3);
        	lblSpelerR3.setStyle("-fx-text-fill: white; -fx-font-size: 12pt;");
        	
        	VboxSpeler3 = new VBox();
        	VboxRechts.getChildren().add(VboxSpeler3);
        	
        	HBox HboxSpeler3 = new HBox();
        	HboxSpeler3.setSpacing(10);
            HboxSpeler3.getChildren().addAll(lblWit3, lblRood3, lblZwart3,lblBlauw3,lblGroen3);
            VboxSpeler3.getChildren().add(HboxSpeler3);
            
            VboxRechts.getChildren().add(lblSpelerR4);
            lblSpelerR4.setStyle("-fx-text-fill: white; -fx-font-size: 12pt;");
            
            VboxSpeler4 = new VBox();
            VboxRechts.getChildren().add(VboxSpeler4);
            
            HBox HboxSpeler4 = new HBox();
            HboxSpeler4.setSpacing(10);
            HboxSpeler4.getChildren().addAll(lblWit4, lblRood4, lblZwart4,lblBlauw4,lblGroen4);
            VboxSpeler4.getChildren().add(HboxSpeler4);
        }
        
        // add buttons to gridpane
        gridCenter.add(niveau1, 0, 1);
        gridCenter.add(niveau2, 0, 2);
        gridCenter.add(niveau3, 0, 3);
        gridCenter.add(btnKaart1, 1, 1);
        gridCenter.add(btnKaart2, 2, 1);
        gridCenter.add(btnKaart3, 3, 1);
        gridCenter.add(btnKaart4, 1, 2);
        gridCenter.add(btnKaart5, 2, 2);
        gridCenter.add(btnKaart6, 3, 2);
        gridCenter.add(btnKaart7, 1, 3);
        gridCenter.add(btnKaart8, 2, 3);
        gridCenter.add(btnKaart9, 3, 3);


        return gridCenter;
    }
    
    private VBox buildLeftPane() {
        VBox vbox = new VBox();
        vbox.getStyleClass().add("pane");
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #f2da3c");
        
        Label lblSpeler1 = new Label(spelers.get(0).getUsername());
        lblSpeler1.setTextFill(Color.BLACK);
        lblSpeler1.setStyle("-fx-background-color: lightgrey;");
        
        lblSpeler1Punten.setTextFill(Color.BLACK);

        Label lblSpeler2 = new Label(spelers.get(1).getUsername());
        lblSpeler2.setTextFill(Color.BLACK);
        lblSpeler2.setStyle("-fx-background-color: lightgrey;");
        
        lblSpeler2Punten.setTextFill(Color.BLACK);
        
       
        
        if(spelers.size() == 3) {
        	lblSpeler3 = new Label(spelers.get(2).getUsername());
            lblSpeler3Punten = new Label(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
            lblSpeler3.setTextFill(Color.BLACK);
            lblSpeler3.setStyle("-fx-background-color: lightgrey;");
        }else if (spelers.size() == 4) {
            lblSpeler3 = new Label(spelers.get(2).getUsername());
            lblSpeler4 = new Label(spelers.get(3).getUsername());
            lblSpeler3.setTextFill(Color.BLACK);
            lblSpeler3.setStyle("-fx-background-color: lightgrey;");
            
            lblSpeler4.setTextFill(Color.BLACK);
            lblSpeler4.setStyle("-fx-background-color: lightgrey;");

        }

        
        vbox.getChildren().addAll(lblSpeler1, lblSpeler1Punten, lblSpeler2,
        		lblSpeler2Punten);
        if(spelers.size() == 3) {
        	vbox.getChildren().add(lblSpeler3);
            vbox.getChildren().add(lblSpeler3Punten);
        }else if (spelers.size() == 4) {
        	vbox.getChildren().add(lblSpeler3);
            vbox.getChildren().add(lblSpeler3Punten);
            vbox.getChildren().add(lblSpeler4);
            vbox.getChildren().add(lblSpeler4Punten);
        }
       
        return vbox;
    }
    
    private GridPane buildRightPane() {
    	gridRechts = new GridPane();
    	gridRechts.getStyleClass().add("pane");
    	gridRechts.setPadding(new Insets(15, 12, 15, 12));
    	gridRechts.setVgap(5);
    	gridRechts.setHgap(5);
    	gridRechts.setStyle("-fx-background-color: white");
        
    	Image imgRood = new Image(this.getClass().getResourceAsStream("/images/token_rood.png"));
    	Image imgWit = new Image(this.getClass().getResourceAsStream("/images/token_wit.png"));
    	Image imgBlauw = new Image(this.getClass().getResourceAsStream("/images/token_blauw.png"));
    	Image imgGroen = new Image(this.getClass().getResourceAsStream("/images/token_groen.png"));
    	Image imgZwart = new Image(this.getClass().getResourceAsStream("/images/token_zwart.png"));
        ImageView viewRood = new ImageView(imgRood);
        ImageView viewWit = new ImageView(imgWit);
        ImageView viewBlauw = new ImageView(imgBlauw);
        ImageView viewGroen = new ImageView(imgGroen);
        ImageView viewZwart = new ImageView(imgZwart);
        
        btnWit = new Button("Wit");
        btnWit.setText(Integer.toString(Wit.getAantal()));
        btnWit.setGraphic(viewWit);
        btnWit.setStyle("-fx-background-color: transparent;");
        btnWit.setOnAction(this::buttonPushedWit);
        
        btnRood = new Button("Rood");
        btnRood.setText(Integer.toString(Rood.getAantal()));
        btnRood.setGraphic(viewRood);
        btnRood.setStyle("-fx-background-color: transparent;");
        btnRood.setOnAction(this::buttonPushedRood);
        
        btnZwart = new Button("Zwart");
        btnZwart.setText(Integer.toString(Zwart.getAantal()));
        btnZwart.setGraphic(viewZwart);
        btnZwart.setStyle("-fx-background-color: transparent;");
        btnZwart.setOnAction(this::buttonPushedZwart);
        
        btnBlauw = new Button("Blauw");
        btnBlauw.setText(Integer.toString(Blauw.getAantal()));
        btnBlauw.setGraphic(viewBlauw);
        btnBlauw.setStyle("-fx-background-color: transparent;");
        btnBlauw.setOnAction(this::buttonPushedBlauw);
        
        btnGroen = new Button("Groen");
        btnGroen.setText(Integer.toString(Groen.getAantal()));
        btnGroen.setGraphic(viewGroen);
        btnGroen.setStyle("-fx-background-color: transparent;");
        btnGroen.setOnAction(this::buttonPushedGroen);
        
        btnPas = new Button(taal.getProperty(taalKeuze + "VolgendeBeurt"));
        btnPas.setStyle("-fx-background-color: #333333;-fx-text-fill: white;");
        btnPas.setOnAction(this::buttonPushedPas);
  
        btnStop = new Button(taal.getProperty(taalKeuze + "Stop"));
        btnStop.setOnAction(e -> Platform.exit());
        btnStop.setStyle("-fx-background-color: #333333;-fx-text-fill: white;");
        
        btnVoeg15Toe = new Button(taal.getProperty(taalKeuze + "Voeg15Toe"));
        btnVoeg15Toe.setOnAction(this::buttonPushedplus15);
        btnVoeg15Toe.setStyle("-fx-background-color: #333333;-fx-text-fill: white;");
        // add buttons to gridpane
        gridRechts.add(btnWit, 0, 0);
        gridRechts.add(btnRood, 0, 1);
        gridRechts.add(btnZwart, 0, 2);
        gridRechts.add(btnBlauw, 0, 3);
        gridRechts.add(btnGroen, 0, 4);
        gridRechts.add(btnPas, 1, 0);
        gridRechts.add(btnStop, 1, 1);
        gridRechts.add(btnVoeg15Toe, 1, 2);
        
        return gridRechts;
    }
    private void buttonPushedPas(ActionEvent event) {
    	genomenEdelstenen.clear();
    	aantalWitteInBeurt = 0;
        aantalGroeneInBeurt = 0;
        aantalBlauweInBeurt = 0;
        aantalZwarteInBeurt = 0;
        aantalRodeInBeurt = 0;
        
    	if(puntenSpeler1 >= 15 || puntenSpeler2 >= 15 || puntenSpeler3 >= 15 || puntenSpeler4 >= 15) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle(taal.getProperty(taalKeuze + "Winnaar"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "WinnaarText")+" "+huidigeSpeler.getUsername());
			alert.showAndWait();
		            Stage currentStage = (Stage) btnPas.getScene().getWindow();
		            currentStage.close();
		            
    	}else {
    		getal = getal + 1;
        	if(getal + 1 > spelers.size())
        	{
        		getal = 0;
        	}
        	lblSpelerTop.setText(spelers.get(getal).getUsername());
        	huidigeSpeler = spelers.get(getal);
    	}
    	
    }
    
    private void buttonPushedplus15(ActionEvent event) {
    
    	if(huidigeSpeler.getUsername() == spelers.get(0).getUsername()) {
    		puntenSpeler1 = puntenSpeler1+15;
    		lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    	}else if(huidigeSpeler.getUsername() == spelers.get(1).getUsername()) {
    		puntenSpeler2 = puntenSpeler2+15;
    		lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    	}else if(huidigeSpeler.getUsername() == spelers.get(2).getUsername()) {
    		puntenSpeler3 = puntenSpeler3+15;
    		lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    	}else if(huidigeSpeler.getUsername() == spelers.get(3).getUsername()) {
    		puntenSpeler4 = puntenSpeler4+15;
    		lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    	}
    }
    
    private void buttonPushedEdele1(ActionEvent event) {
    	if(!edele1Gekocht)
    	{
    		int aantalWitte = 0;
    		int aantalRode = 0;
    		int aantalZwarte = 0;
    		int aantalBlauwe = 0;
    		int aantalGroene = 0;
    		
    		for(Kaart k : huidigeSpeler.getKaarten())
    		{
    			if(k.getKleur().equals("WIT"))
    			{
    				aantalWitte += 5;
    			}
    			
    			if(k.getKleur().equals("ROOD"))
    			{
    				aantalRode += 5;
    			}
    			
    			if(k.getKleur().equals("ZWART"))
    			{
    				aantalZwarte += 5;
    			}
    			
    			if(k.getKleur().equals("BLAUW"))
    			{
    				aantalBlauwe += 5;
    			}
    			
    			if(k.getKleur().equals("GROEN"))
    			{
    				aantalGroene += 5;
    			}
    		}
    		
    		int[] prijslijst = edelen.get(hulpEdele1).getPrijs();
    		int kostWit = prijslijst[0];
    		int kostRood = prijslijst[1];
    		int kostZwart = prijslijst[2];
    		int kostBlauw = prijslijst[3];
    		int kostGroen = prijslijst[4];
    		
    		if(aantalWitte >= kostWit && aantalRode >= kostRood && aantalZwarte >= kostZwart && aantalBlauwe >= kostBlauw && aantalGroene >= kostGroen) {
    			if(getal == 0)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele1).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler1.getChildren().add(imageEdele);
            	    
            	    puntenSpeler1 += edelen.get(hulpEdele1).getWaarde();
        			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			}
    			
    			if(getal == 1)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele1).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler2.getChildren().add(imageEdele);
            	    
            	    puntenSpeler2 += edelen.get(hulpEdele1).getWaarde();
        			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			}
    			
    			if(getal == 2)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele1).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler3.getChildren().add(imageEdele);
            	    
            	    puntenSpeler3 += edelen.get(hulpEdele1).getWaarde();
        			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			}
    			
    			if(getal == 3)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele1).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler4.getChildren().add(imageEdele);
            	    
            	    puntenSpeler4 += edelen.get(hulpEdele1).getWaarde();
        			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			}
        		edele1Gekocht = true;
        		btnEdele1.setVisible(false);
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    			alert.setHeaderText(taal.getProperty(taalKeuze + "NietGenoegKaarten"));
    			alert.showAndWait();
    		}
    	}else
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "Verkocht"));
			alert.showAndWait();
    	}
    	
    }
    
    private void buttonPushedEdele2(ActionEvent event) {
    	if(!edele2Gekocht)
    	{
    		int aantalWitte = 0;
    		int aantalRode = 0;
    		int aantalZwarte = 0;
    		int aantalBlauwe = 0;
    		int aantalGroene = 0;
    		
    		for(Kaart k : huidigeSpeler.getKaarten())
    		{
    			if(k.getKleur().equals("WIT"))
    			{
    				aantalWitte++;
    			}
    			
    			if(k.getKleur().equals("ROOD"))
    			{
    				aantalRode++;
    			}
    			
    			if(k.getKleur().equals("ZWART"))
    			{
    				aantalZwarte++;
    			}
    			
    			if(k.getKleur().equals("BLAUW"))
    			{
    				aantalBlauwe++;
    			}
    			
    			if(k.getKleur().equals("GROEN"))
    			{
    				aantalGroene++;
    			}
    		}
    		
    		int[] prijslijst = edelen.get(hulpEdele2).getPrijs();
    		int kostWit = prijslijst[0];
    		int kostRood = prijslijst[1];
    		int kostZwart = prijslijst[2];
    		int kostBlauw = prijslijst[3];
    		int kostGroen = prijslijst[4];
    		
    		if(aantalWitte >= kostWit && aantalRode >= kostRood && aantalZwarte >= kostZwart && aantalBlauwe >= kostBlauw && aantalGroene >= kostGroen) {
    			if(getal == 0)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele2).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler1.getChildren().add(imageEdele);
            	    
            	    puntenSpeler1 += edelen.get(hulpEdele2).getWaarde();
        			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			}
    			
    			if(getal == 1)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele2).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler2.getChildren().add(imageEdele);
            	    
            	    puntenSpeler2 += edelen.get(hulpEdele2).getWaarde();
        			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			}
    			
    			if(getal == 2)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele2).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler3.getChildren().add(imageEdele);
            	    
            	    puntenSpeler3 += edelen.get(hulpEdele2).getWaarde();
        			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			}
    			
    			if(getal == 3)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele2).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler4.getChildren().add(imageEdele);
            	    
            	    puntenSpeler4 += edelen.get(hulpEdele2).getWaarde();
        			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			}
        		edele2Gekocht = true;
        		btnEdele2.setVisible(false);
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    			alert.setHeaderText(taal.getProperty(taalKeuze + "NietGenoegKaarten"));
    			alert.showAndWait();
    		}
    	}else
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "Verkocht"));
			alert.showAndWait();
    	}
    }
    
    private void buttonPushedEdele3(ActionEvent event) {
    	if(!edele3Gekocht)
    	{
    		int aantalWitte = 0;
    		int aantalRode = 0;
    		int aantalZwarte = 0;
    		int aantalBlauwe = 0;
    		int aantalGroene = 0;
    		
    		for(Kaart k : huidigeSpeler.getKaarten())
    		{
    			if(k.getKleur().equals("WIT"))
    			{
    				aantalWitte++;
    			}
    			
    			if(k.getKleur().equals("ROOD"))
    			{
    				aantalRode++;
    			}
    			
    			if(k.getKleur().equals("ZWART"))
    			{
    				aantalZwarte++;
    			}
    			
    			if(k.getKleur().equals("BLAUW"))
    			{
    				aantalBlauwe++;
    			}
    			
    			if(k.getKleur().equals("GROEN"))
    			{
    				aantalGroene++;
    			}
    		}
    		
    		int[] prijslijst = edelen.get(hulpEdele3).getPrijs();
    		int kostWit = prijslijst[0];
    		int kostRood = prijslijst[1];
    		int kostZwart = prijslijst[2];
    		int kostBlauw = prijslijst[3];
    		int kostGroen = prijslijst[4];
    		
    		if(aantalWitte >= kostWit && aantalRode >= kostRood && aantalZwarte >= kostZwart && aantalBlauwe >= kostBlauw && aantalGroene >= kostGroen) {
    			if(getal == 0)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele3).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler1.getChildren().add(imageEdele);
            	    
            	    puntenSpeler1 += edelen.get(hulpEdele3).getWaarde();
        			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			}
    			
    			if(getal == 1)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele3).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler2.getChildren().add(imageEdele);
            	    
            	    puntenSpeler2 += edelen.get(hulpEdele3).getWaarde();
        			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			}
    			
    			if(getal == 2)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele3).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler3.getChildren().add(imageEdele);
            	    
            	    puntenSpeler3 += edelen.get(hulpEdele3).getWaarde();
        			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			}
    			
    			if(getal == 3)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele3).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler4.getChildren().add(imageEdele);
            	    
            	    puntenSpeler4 += edelen.get(hulpEdele3).getWaarde();
        			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			}
        		edele3Gekocht = true;
        		btnEdele3.setVisible(false);
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    			alert.setHeaderText(taal.getProperty(taalKeuze + "NietGenoegKaarten"));
    			alert.showAndWait();
    		}
    	}else
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "Verkocht"));
			alert.showAndWait();
    	}
    }
    
    private void buttonPushedEdele4(ActionEvent event) {
    	if(!edele4Gekocht)
    	{
    		int aantalWitte = 0;
    		int aantalRode = 0;
    		int aantalZwarte = 0;
    		int aantalBlauwe = 0;
    		int aantalGroene = 0;
    		
    		for(Kaart k : huidigeSpeler.getKaarten())
    		{
    			if(k.getKleur().equals("WIT"))
    			{
    				aantalWitte+=5;
    			}
    			
    			if(k.getKleur().equals("ROOD"))
    			{
    				aantalRode+=5;
    			}
    			
    			if(k.getKleur().equals("ZWART"))
    			{
    				aantalZwarte+=5;
    			}
    			
    			if(k.getKleur().equals("BLAUW"))
    			{
    				aantalBlauwe+=5;
    			}
    			
    			if(k.getKleur().equals("GROEN"))
    			{
    				aantalGroene+=5;
    			}
    		}
    		
    		int[] prijslijst = edelen.get(hulpEdele4).getPrijs();
    		int kostWit = prijslijst[0];
    		int kostRood = prijslijst[1];
    		int kostZwart = prijslijst[2];
    		int kostBlauw = prijslijst[3];
    		int kostGroen = prijslijst[4];
    		
    		if(aantalWitte >= kostWit && aantalRode >= kostRood && aantalZwarte >= kostZwart && aantalBlauwe >= kostBlauw && aantalGroene >= kostGroen) {
    			if(getal == 0)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele4).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler1.getChildren().add(imageEdele);
            	    
            	    puntenSpeler1 += edelen.get(hulpEdele4).getWaarde();
        			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			}
    			
    			if(getal == 1)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele4).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler2.getChildren().add(imageEdele);
            	    
            	    puntenSpeler2 += edelen.get(hulpEdele4).getWaarde();
        			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			}
    			
    			if(getal == 2)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele4).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler3.getChildren().add(imageEdele);
            	    
            	    puntenSpeler3 += edelen.get(hulpEdele4).getWaarde();
        			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			}
    			
    			if(getal == 3)
    			{
    				Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/edele_"+edelen.get(hulpEdele4).getKaartID()+".jpg"));	
            	    ImageView imageEdele = new ImageView(tussenImage);
            	    imageEdele.setFitWidth(96);
            	    imageEdele.setFitHeight(116);
            	    HboxKaartenSpeler4.getChildren().add(imageEdele);
            	    
            	    puntenSpeler4 += edelen.get(hulpEdele4).getWaarde();
        			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			}
        		edele4Gekocht = true; 
        		btnEdele4.setVisible(false);
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    			alert.setHeaderText(taal.getProperty(taalKeuze + "NietGenoegKaarten"));
    			alert.showAndWait();
    		}
    	}else
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "Verkocht"));
			alert.showAndWait();
    	}
    }
    
    private void buttonPushedKoopKaart0(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
        
    	
    	boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau1.get(hulp0niveau1).getPrijs(0);
    	int kostRood = kaartenNiveau1.get(hulp0niveau1).getPrijs(1);
    	int kostZwart = kaartenNiveau1.get(hulp0niveau1).getPrijs(2);
    	int kostBlauw = kaartenNiveau1.get(hulp0niveau1).getPrijs(3);
    	int kostGroen = kaartenNiveau1.get(hulp0niveau1).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		
    		
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau1.get(hulp0niveau1).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    	        
    			huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp0niveau1));
    			    			
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear(); 
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp0niveau1 += 3;
    	        Image kaartV01 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV1 = new ImageView(kaartV01);
    	        kaartV1.setFitWidth(newWidth);
    	        kaartV1.setFitHeight(newHeight);
    	        kaartV1.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart1);
    	        btnKaart1 = new Button();
    	        btnKaart1.setGraphic(kaartV1);
    	        btnKaart1.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart1, 1, 1);
    	        btnKaart1.setOnAction(this::buttonPushedKoopKaart0);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
    						zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau1.get(hulp0niveau1).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp0niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();   
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp0niveau1 += 3;
    	        Image kaartV01 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV1 = new ImageView(kaartV01);
    	        kaartV1.setFitWidth(newWidth);
    	        kaartV1.setFitHeight(newHeight);
    	        kaartV1.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart1);
    	        btnKaart1 = new Button();
    	        btnKaart1.setGraphic(kaartV1);
    	        btnKaart1.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart1, 1, 1);
    	        btnKaart1.setOnAction(this::buttonPushedKoopKaart0);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau1.get(hulp0niveau1).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp0niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();   
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp0niveau1 += 3;
    	        Image kaartV01 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV1 = new ImageView(kaartV01);
    	        kaartV1.setFitWidth(newWidth);
    	        kaartV1.setFitHeight(newHeight);
    	        kaartV1.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart1);
    	        btnKaart1 = new Button();
    	        btnKaart1.setGraphic(kaartV1);
    	        btnKaart1.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart1, 1, 1);
    	        btnKaart1.setOnAction(this::buttonPushedKoopKaart0);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau1.get(hulp0niveau1).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp0niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();   
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp0niveau1 += 3;
    	        Image kaartV01 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp0niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV1 = new ImageView(kaartV01);
    	        kaartV1.setFitWidth(newWidth);
    	        kaartV1.setFitHeight(newHeight);
    	        kaartV1.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart1);
    	        btnKaart1 = new Button();
    	        btnKaart1.setGraphic(kaartV1);
    	        btnKaart1.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart1, 1, 1);
    	        btnKaart1.setOnAction(this::buttonPushedKoopKaart0);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }

    private void buttonPushedKoopKaart1(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
    	boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau1.get(hulp1niveau1).getPrijs(0);
    	int kostRood = kaartenNiveau1.get(hulp1niveau1).getPrijs(1);
    	int kostZwart = kaartenNiveau1.get(hulp1niveau1).getPrijs(2);
    	int kostBlauw = kaartenNiveau1.get(hulp1niveau1).getPrijs(3);
    	int kostGroen = kaartenNiveau1.get(hulp1niveau1).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau1.get(hulp1niveau1).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp1niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear();   
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp1niveau1 += 3;
    	        Image kaartV02 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV2 = new ImageView(kaartV02);
    	        kaartV2.setFitWidth(newWidth);
    	        kaartV2.setFitHeight(newHeight);
    	        kaartV2.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart2);
    	        btnKaart2 = new Button();
    	        btnKaart2.setGraphic(kaartV2);
    	        btnKaart2.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart2, 2, 1);
    	        btnKaart2.setOnAction(this::buttonPushedKoopKaart1);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau1.get(hulp1niveau1).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp1niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();   
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp1niveau1 += 3;
    	        Image kaartV02 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV2 = new ImageView(kaartV02);
    	        kaartV2.setFitWidth(newWidth);
    	        kaartV2.setFitHeight(newHeight);
    	        kaartV2.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart2);
    	        btnKaart2 = new Button();
    	        btnKaart2.setGraphic(kaartV2);
    	        btnKaart2.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart2, 2, 1);
    	        btnKaart2.setOnAction(this::buttonPushedKoopKaart1);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau1.get(hulp1niveau1).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp1niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();   
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp1niveau1 += 3;
    	        Image kaartV02 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV2 = new ImageView(kaartV02);
    	        kaartV2.setFitWidth(newWidth);
    	        kaartV2.setFitHeight(newHeight);
    	        kaartV2.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart2);
    	        btnKaart2 = new Button();
    	        btnKaart2.setGraphic(kaartV2);
    	        btnKaart2.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart2, 2, 1);
    	        btnKaart2.setOnAction(this::buttonPushedKoopKaart1);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau1.get(hulp1niveau1).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp1niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();   
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp1niveau1 += 3;
    	        Image kaartV02 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp1niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV2 = new ImageView(kaartV02);
    	        kaartV2.setFitWidth(newWidth);
    	        kaartV2.setFitHeight(newHeight);
    	        kaartV2.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart2);
    	        btnKaart2 = new Button();
    	        btnKaart2.setGraphic(kaartV2);
    	        btnKaart2.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart2, 2, 1);
    	        btnKaart2.setOnAction(this::buttonPushedKoopKaart1);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }
    private void buttonPushedKoopKaart2(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau1.get(hulp2niveau1).getPrijs(0);
    	int kostRood = kaartenNiveau1.get(hulp2niveau1).getPrijs(1);
    	int kostZwart = kaartenNiveau1.get(hulp2niveau1).getPrijs(2);
    	int kostBlauw = kaartenNiveau1.get(hulp2niveau1).getPrijs(3);
    	int kostGroen = kaartenNiveau1.get(hulp2niveau1).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau1.get(hulp2niveau1).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp2niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear();   
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp2niveau1 += 3;
    	        Image kaartV03 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV3 = new ImageView(kaartV03);
    	        kaartV3.setFitWidth(newWidth);
    	        kaartV3.setFitHeight(newHeight);
    	        kaartV3.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart3);
    	        btnKaart3 = new Button();
    	        btnKaart3.setGraphic(kaartV3);
    	        btnKaart3.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart3, 3, 1);
    	        btnKaart3.setOnAction(this::buttonPushedKoopKaart2);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau1.get(hulp2niveau1).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp2niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();   
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp2niveau1 += 3;
    	        Image kaartV03 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV3 = new ImageView(kaartV03);
    	        kaartV3.setFitWidth(newWidth);
    	        kaartV3.setFitHeight(newHeight);
    	        kaartV3.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart3);
    	        btnKaart3 = new Button();
    	        btnKaart3.setGraphic(kaartV3);
    	        btnKaart3.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart3, 3, 1);
    	        btnKaart3.setOnAction(this::buttonPushedKoopKaart2);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau1.get(hulp2niveau1).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp2niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();   
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp2niveau1 += 3;
    	        Image kaartV03 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV3 = new ImageView(kaartV03);
    	        kaartV3.setFitWidth(newWidth);
    	        kaartV3.setFitHeight(newHeight);
    	        kaartV3.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart3);
    	        btnKaart3 = new Button();
    	        btnKaart3.setGraphic(kaartV3);
    	        btnKaart3.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart3, 3, 1);
    	        btnKaart3.setOnAction(this::buttonPushedKoopKaart2);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau1.get(hulp2niveau1).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau1.get(hulp2niveau1));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();   
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp2niveau1 += 3;
    	        Image kaartV03 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau1.get(hulp2niveau1).getKaartID()+".jpg"));
    	        ImageView kaartV3 = new ImageView(kaartV03);
    	        kaartV3.setFitWidth(newWidth);
    	        kaartV3.setFitHeight(newHeight);
    	        kaartV3.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart3);
    	        btnKaart3 = new Button();
    	        btnKaart3.setGraphic(kaartV3);
    	        btnKaart3.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart3, 3, 1);
    	        btnKaart3.setOnAction(this::buttonPushedKoopKaart2);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }
    private void buttonPushedKoopKaart3(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
    	boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau2.get(hulp0niveau2).getPrijs(0);
    	int kostRood = kaartenNiveau2.get(hulp0niveau2).getPrijs(1);
    	int kostZwart = kaartenNiveau2.get(hulp0niveau2).getPrijs(2);
    	int kostBlauw = kaartenNiveau2.get(hulp0niveau2).getPrijs(3);
    	int kostGroen = kaartenNiveau2.get(hulp0niveau2).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau2.get(hulp0niveau2).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp0niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear();   
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp0niveau2 += 3;
    	        Image kaartV04 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV4 = new ImageView(kaartV04);
    	        kaartV4.setFitWidth(newWidth);
    	        kaartV4.setFitHeight(newHeight);
    	        kaartV4.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart4);
    	        btnKaart4 = new Button();
    	        btnKaart4.setGraphic(kaartV4);
    	        btnKaart4.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart4, 1, 2);
    	        btnKaart4.setOnAction(this::buttonPushedKoopKaart3);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau2.get(hulp0niveau2).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp0niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();   
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp0niveau2 += 3;
    	        Image kaartV04 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV4 = new ImageView(kaartV04);
    	        kaartV4.setFitWidth(newWidth);
    	        kaartV4.setFitHeight(newHeight);
    	        kaartV4.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart4);
    	        btnKaart4 = new Button();
    	        btnKaart4.setGraphic(kaartV4);
    	        btnKaart4.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart4, 1, 2);
    	        btnKaart4.setOnAction(this::buttonPushedKoopKaart3);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau2.get(hulp0niveau2).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp0niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();   
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp0niveau2 += 3;
    	        Image kaartV04 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV4 = new ImageView(kaartV04);
    	        kaartV4.setFitWidth(newWidth);
    	        kaartV4.setFitHeight(newHeight);
    	        kaartV4.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart4);
    	        btnKaart4 = new Button();
    	        btnKaart4.setGraphic(kaartV4);
    	        btnKaart4.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart4, 1, 2);
    	        btnKaart4.setOnAction(this::buttonPushedKoopKaart3);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0; 
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau2.get(hulp0niveau2).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp0niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();   
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp0niveau2 += 3;
    	        Image kaartV04 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp0niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV4 = new ImageView(kaartV04);
    	        kaartV4.setFitWidth(newWidth);
    	        kaartV4.setFitHeight(newHeight);
    	        kaartV4.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart4);
    	        btnKaart4 = new Button();
    	        btnKaart4.setGraphic(kaartV4);
    	        btnKaart4.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart4, 1, 2);
    	        btnKaart4.setOnAction(this::buttonPushedKoopKaart3);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }

    private void buttonPushedKoopKaart4(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau2.get(hulp1niveau2).getPrijs(0);
    	int kostRood = kaartenNiveau2.get(hulp1niveau2).getPrijs(1);
    	int kostZwart = kaartenNiveau2.get(hulp1niveau2).getPrijs(2);
    	int kostBlauw = kaartenNiveau2.get(hulp1niveau2).getPrijs(3);
    	int kostGroen = kaartenNiveau2.get(hulp1niveau2).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau2.get(hulp1niveau2).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp1niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear(); 
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp1niveau2 += 3;
    	        Image kaartV05 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV5 = new ImageView(kaartV05);
    	        kaartV5.setFitWidth(newWidth);
    	        kaartV5.setFitHeight(newHeight);
    	        kaartV5.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart5);
    	        btnKaart5 = new Button();
    	        btnKaart5.setGraphic(kaartV5);
    	        btnKaart5.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart5, 2, 2);
    	        btnKaart5.setOnAction(this::buttonPushedKoopKaart4);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau2.get(hulp1niveau2).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp1niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear(); 
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp1niveau2 += 3;
    	        Image kaartV05 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV5 = new ImageView(kaartV05);
    	        kaartV5.setFitWidth(newWidth);
    	        kaartV5.setFitHeight(newHeight);
    	        kaartV5.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart5);
    	        btnKaart5 = new Button();
    	        btnKaart5.setGraphic(kaartV5);
    	        btnKaart5.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart5, 2, 2);
    	        btnKaart5.setOnAction(this::buttonPushedKoopKaart4);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0; 
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau2.get(hulp1niveau2).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp1niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp1niveau2 += 3;
    	        Image kaartV05 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV5 = new ImageView(kaartV05);
    	        kaartV5.setFitWidth(newWidth);
    	        kaartV5.setFitHeight(newHeight);
    	        kaartV5.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart5);
    	        btnKaart5 = new Button();
    	        btnKaart5.setGraphic(kaartV5);
    	        btnKaart5.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart5, 2, 2);
    	        btnKaart5.setOnAction(this::buttonPushedKoopKaart4);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau2.get(hulp1niveau2).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp1niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();  
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp1niveau2 += 3;
    	        Image kaartV05 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp1niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV5 = new ImageView(kaartV05);
    	        kaartV5.setFitWidth(newWidth);
    	        kaartV5.setFitHeight(newHeight);
    	        kaartV5.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart5);
    	        btnKaart5 = new Button();
    	        btnKaart5.setGraphic(kaartV5);
    	        btnKaart5.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart5, 2, 2);
    	        btnKaart5.setOnAction(this::buttonPushedKoopKaart4);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }
    
    private void buttonPushedKoopKaart5(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau2.get(hulp2niveau2).getPrijs(0);
    	int kostRood = kaartenNiveau2.get(hulp2niveau2).getPrijs(1);
    	int kostZwart = kaartenNiveau2.get(hulp2niveau2).getPrijs(2);
    	int kostBlauw = kaartenNiveau2.get(hulp2niveau2).getPrijs(3);
    	int kostGroen = kaartenNiveau2.get(hulp2niveau2).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau2.get(hulp2niveau2).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp2niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear();
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp2niveau2 += 3;
    	        Image kaartV06 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV6 = new ImageView(kaartV06);
    	        kaartV6.setFitWidth(newWidth);
    	        kaartV6.setFitHeight(newHeight);
    	        kaartV6.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart6);
    	        btnKaart6 = new Button();
    	        btnKaart6.setGraphic(kaartV6);
    	        btnKaart6.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart6, 3, 2);
    	        btnKaart6.setOnAction(this::buttonPushedKoopKaart5);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau2.get(hulp2niveau2).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp2niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp2niveau2 += 3;
    	        Image kaartV06 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV6 = new ImageView(kaartV06);
    	        kaartV6.setFitWidth(newWidth);
    	        kaartV6.setFitHeight(newHeight);
    	        kaartV6.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart6);
    	        btnKaart6 = new Button();
    	        btnKaart6.setGraphic(kaartV6);
    	        btnKaart6.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart6, 3, 2);
    	        btnKaart6.setOnAction(this::buttonPushedKoopKaart5);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau2.get(hulp2niveau2).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp2niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear(); 
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp2niveau2 += 3;
    	        Image kaartV06 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV6 = new ImageView(kaartV06);
    	        kaartV6.setFitWidth(newWidth);
    	        kaartV6.setFitHeight(newHeight);
    	        kaartV6.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart6);
    	        btnKaart6 = new Button();
    	        btnKaart6.setGraphic(kaartV6);
    	        btnKaart6.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart6, 3, 2);
    	        btnKaart6.setOnAction(this::buttonPushedKoopKaart5);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau2.get(hulp2niveau2).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau2.get(hulp2niveau2));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear(); 
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp2niveau2 += 3;
    	        Image kaartV06 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau2.get(hulp2niveau2).getKaartID()+".jpg"));
    	        ImageView kaartV6 = new ImageView(kaartV06);
    	        kaartV6.setFitWidth(newWidth);
    	        kaartV6.setFitHeight(newHeight);
    	        kaartV6.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart6);
    	        btnKaart6 = new Button();
    	        btnKaart6.setGraphic(kaartV6);
    	        btnKaart6.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart6, 3, 2);
    	        btnKaart6.setOnAction(this::buttonPushedKoopKaart5);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }  
    private void buttonPushedKoopKaart6(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau3.get(hulp0niveau3).getPrijs(0);
    	int kostRood = kaartenNiveau3.get(hulp0niveau3).getPrijs(1);
    	int kostZwart = kaartenNiveau3.get(hulp0niveau3).getPrijs(2);
    	int kostBlauw = kaartenNiveau3.get(hulp0niveau3).getPrijs(3);
    	int kostGroen = kaartenNiveau3.get(hulp0niveau3).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau3.get(hulp0niveau3).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp0niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear(); 
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp0niveau3 += 3;
    	        Image kaartV07 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV7 = new ImageView(kaartV07);
    	        kaartV7.setFitWidth(newWidth);
    	        kaartV7.setFitHeight(newHeight);
    	        kaartV7.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart7);
    	        btnKaart7 = new Button();
    	        btnKaart7.setGraphic(kaartV7);
    	        btnKaart7.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart7, 1, 3);
    	        btnKaart7.setOnAction(this::buttonPushedKoopKaart6);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau3.get(hulp0niveau3).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp0niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp0niveau3 += 3;
    	        Image kaartV07 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV7 = new ImageView(kaartV07);
    	        kaartV7.setFitWidth(newWidth);
    	        kaartV7.setFitHeight(newHeight);
    	        kaartV7.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart7);
    	        btnKaart7 = new Button();
    	        btnKaart7.setGraphic(kaartV7);
    	        btnKaart7.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart7, 1, 3);
    	        btnKaart7.setOnAction(this::buttonPushedKoopKaart6);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau3.get(hulp0niveau3).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp0niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp0niveau3 += 3;
    	        Image kaartV07 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV7 = new ImageView(kaartV07);
    	        kaartV7.setFitWidth(newWidth);
    	        kaartV7.setFitHeight(newHeight);
    	        kaartV7.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart7);
    	        btnKaart7 = new Button();
    	        btnKaart7.setGraphic(kaartV7);
    	        btnKaart7.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart7, 1, 3);
    	        btnKaart7.setOnAction(this::buttonPushedKoopKaart6);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau3.get(hulp0niveau3).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp0niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp0niveau3 += 3;
    	        Image kaartV07 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp0niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV7 = new ImageView(kaartV07);
    	        kaartV7.setFitWidth(newWidth);
    	        kaartV7.setFitHeight(newHeight);
    	        kaartV7.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart7);
    	        btnKaart7 = new Button();
    	        btnKaart7.setGraphic(kaartV7);
    	        btnKaart7.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart7, 1, 3);
    	        btnKaart7.setOnAction(this::buttonPushedKoopKaart6);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }  
    private void buttonPushedKoopKaart7(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau3.get(hulp1niveau3).getPrijs(0);
    	int kostRood = kaartenNiveau3.get(hulp1niveau3).getPrijs(1);
    	int kostZwart = kaartenNiveau3.get(hulp1niveau3).getPrijs(2);
    	int kostBlauw = kaartenNiveau3.get(hulp1niveau3).getPrijs(3);
    	int kostGroen = kaartenNiveau3.get(hulp1niveau3).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau3.get(hulp1niveau3).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp1niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear();
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp1niveau3 += 3;
    	        Image kaartV08 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV8 = new ImageView(kaartV08);
    	        kaartV8.setFitWidth(newWidth);
    	        kaartV8.setFitHeight(newHeight);
    	        kaartV8.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart8);
    	        btnKaart8 = new Button();
    	        btnKaart8.setGraphic(kaartV8);
    	        btnKaart8.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart8, 2, 3);
    	        btnKaart8.setOnAction(this::buttonPushedKoopKaart7);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau3.get(hulp1niveau3).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp1niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp1niveau3 += 3;
    	        Image kaartV08 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV8 = new ImageView(kaartV08);
    	        kaartV8.setFitWidth(newWidth);
    	        kaartV8.setFitHeight(newHeight);
    	        kaartV8.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart8);
    	        btnKaart8 = new Button();
    	        btnKaart8.setGraphic(kaartV8);
    	        btnKaart8.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart8, 2, 3);
    	        btnKaart8.setOnAction(this::buttonPushedKoopKaart7);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau3.get(hulp1niveau3).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp1niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();  
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp1niveau3 += 3;
    	        Image kaartV08 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV8 = new ImageView(kaartV08);
    	        kaartV8.setFitWidth(newWidth);
    	        kaartV8.setFitHeight(newHeight);
    	        kaartV8.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart8);
    	        btnKaart8 = new Button();
    	        btnKaart8.setGraphic(kaartV8);
    	        btnKaart8.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart8, 2, 3);
    	        btnKaart8.setOnAction(this::buttonPushedKoopKaart7);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau3.get(hulp1niveau3).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp1niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();  
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp1niveau3 += 3;
    	        Image kaartV08 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp1niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV8 = new ImageView(kaartV08);
    	        kaartV8.setFitWidth(newWidth);
    	        kaartV8.setFitHeight(newHeight);
    	        kaartV8.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart8);
    	        btnKaart8 = new Button();
    	        btnKaart8.setGraphic(kaartV8);
    	        btnKaart8.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart8, 2, 3);
    	        btnKaart8.setOnAction(this::buttonPushedKoopKaart7);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }  

    private void buttonPushedKoopKaart8(ActionEvent event) {
    	
    	kaartenSpeler1 = spelers.get(0).getKaarten();
        kaartenSpeler2 = spelers.get(1).getKaarten();
        if(spelers.size() ==3) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
        }
        if(spelers.size()==4) {
        	kaartenSpeler3 = spelers.get(2).getKaarten();
            kaartenSpeler4 = spelers.get(3).getKaarten();
        }
    	
        boolean gelukt = false;
    	
    	int kostWit = kaartenNiveau3.get(hulp2niveau3).getPrijs(0);
    	int kostRood = kaartenNiveau3.get(hulp2niveau3).getPrijs(1);
    	int kostZwart = kaartenNiveau3.get(hulp2niveau3).getPrijs(2);
    	int kostBlauw = kaartenNiveau3.get(hulp2niveau3).getPrijs(3);
    	int kostGroen = kaartenNiveau3.get(hulp2niveau3).getPrijs(4);
    	
    	int kortingWit = 0;
		int kortingRood = 0;
		int kortingZwart = 0;
		int kortingBlauw = 0;
		int kortingGroen = 0;
		
		int effectieveKostWit =0;
		int effectieveKostRood =0;
		int effectieveKostZwart =0;
		int effectieveKostBlauw=0;
		int effectieveKostGroen=0;
    	
    	if(getal == 0)
    	{
    		for(Kaart k : kaartenSpeler1) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit.getText());
    		int bezitRood = Integer.parseInt(lblRood.getText());
    		int bezitZwart = Integer.parseInt(lblZwart.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw.getText());
    		int bezitGroen = Integer.parseInt(lblGroen.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit.setText(Integer.toString(bezitWit));
    			lblRood.setText(Integer.toString(bezitRood));
    			lblZwart.setText(Integer.toString(bezitZwart));
    			lblBlauw.setText(Integer.toString(bezitBlauw));
    			lblGroen.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler1Wit -= witWeg;
    			speler1Rood -= roodWeg;
    			speler1Zwart -= zwartWeg;
    			speler1Blauw -= blauwWeg;
    			speler1Groen -= groenWeg;
    			
    			puntenSpeler1 += kaartenNiveau3.get(hulp2niveau3).getPrestigepunten();
    			lblSpeler1Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler1);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp2niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler1.add(tussenImage);
    	        HboxKaartenSpeler1.getChildren().clear(); 
    	        VboxSpeler1.getChildren().remove(HboxKaartenSpeler1);
    	        
    	        for(Image i : gekochteKaartenSpeler1)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler1.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler1.getChildren().add(HboxKaartenSpeler1);
    	        
    	        hulp2niveau3 += 3;
    	        Image kaartV09 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV9 = new ImageView(kaartV09);
    	        kaartV9.setFitWidth(newWidth);
    	        kaartV9.setFitHeight(newHeight);
    	        kaartV9.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart9);
    	        btnKaart9 = new Button();
    	        btnKaart9.setGraphic(kaartV9);
    	        btnKaart9.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart9, 3, 3);
    	        btnKaart9.setOnAction(this::buttonPushedKoopKaart8);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 1)
    	{
    		for(Kaart k : kaartenSpeler2) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit2.getText());
    		int bezitRood = Integer.parseInt(lblRood2.getText());
    		int bezitZwart = Integer.parseInt(lblZwart2.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw2.getText());
    		int bezitGroen = Integer.parseInt(lblGroen2.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit2.setText(Integer.toString(bezitWit));
    			lblRood2.setText(Integer.toString(bezitRood));
    			lblZwart2.setText(Integer.toString(bezitZwart));
    			lblBlauw2.setText(Integer.toString(bezitBlauw));
    			lblGroen2.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler2Wit -= witWeg;
    			speler2Rood -= roodWeg;
    			speler2Zwart -= zwartWeg;
    			speler2Blauw -= blauwWeg;
    			speler2Groen -= groenWeg;
    			
    			puntenSpeler2 += kaartenNiveau3.get(hulp2niveau3).getPrestigepunten();
    			lblSpeler2Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler2);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp2niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler2.add(tussenImage);
    	        HboxKaartenSpeler2.getChildren().clear();  
    	        VboxSpeler2.getChildren().remove(HboxKaartenSpeler2);
    	        
    	        for(Image i : gekochteKaartenSpeler2)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler2.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler2.getChildren().add(HboxKaartenSpeler2);
    	        
    	        hulp2niveau3 += 3;
    	        Image kaartV09 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV9 = new ImageView(kaartV09);
    	        kaartV9.setFitWidth(newWidth);
    	        kaartV9.setFitHeight(newHeight);
    	        kaartV9.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart9);
    	        btnKaart9 = new Button();
    	        btnKaart9.setGraphic(kaartV9);
    	        btnKaart9.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart9, 3, 3);
    	        btnKaart9.setOnAction(this::buttonPushedKoopKaart8);
    			gelukt = true;
    			
    		}
    	}
    	if(getal == 2)
    	{
    		for(Kaart k : kaartenSpeler3) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit3.getText());
    		int bezitRood = Integer.parseInt(lblRood3.getText());
    		int bezitZwart = Integer.parseInt(lblZwart3.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw3.getText());
    		int bezitGroen = Integer.parseInt(lblGroen3.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit3.setText(Integer.toString(bezitWit));
    			lblRood3.setText(Integer.toString(bezitRood));
    			lblZwart3.setText(Integer.toString(bezitZwart));
    			lblBlauw3.setText(Integer.toString(bezitBlauw));
    			lblGroen3.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler3Wit -= witWeg;
    			speler3Rood -= roodWeg;
    			speler3Zwart -= zwartWeg;
    			speler3Blauw -= blauwWeg;
    			speler3Groen -= groenWeg;
    			
    			puntenSpeler3 += kaartenNiveau3.get(hulp2niveau3).getPrestigepunten();
    			lblSpeler3Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler3);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp2niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler3.add(tussenImage);
    	        HboxKaartenSpeler3.getChildren().clear();
    	        VboxSpeler3.getChildren().remove(HboxKaartenSpeler3);
    	        
    	        for(Image i : gekochteKaartenSpeler3)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler3.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler3.getChildren().add(HboxKaartenSpeler3);
    	        
    	        hulp2niveau3 += 3;
    	        Image kaartV09 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV9 = new ImageView(kaartV09);
    	        kaartV9.setFitWidth(newWidth);
    	        kaartV9.setFitHeight(newHeight);
    	        kaartV9.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart9);
    	        btnKaart9 = new Button();
    	        btnKaart9.setGraphic(kaartV9);
    	        btnKaart9.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart9, 3, 3);
    	        btnKaart9.setOnAction(this::buttonPushedKoopKaart8);
    			gelukt = true;	
    		}
    	}
    	if(getal == 3)
    	{
    		for(Kaart k : kaartenSpeler4) {
    			if(k.getKleur().equals("WIT")) {
    				kortingWit++;
    			}else if (k.getKleur().equals("ROOD")) {
					kortingRood++;
				}else if (k.getKleur().equals("ZWART")) {
					kortingZwart++;
				}else if (k.getKleur().equals("BLAUW")) {
					kortingBlauw++;
				}else if (k.getKleur().equals("GROEN")) {
					kortingGroen++;
				}
    		}
    		
    		effectieveKostWit = kostWit-kortingWit;
    		if(effectieveKostWit<0) {
    			effectieveKostWit=0;
    		}
    		effectieveKostRood = kostRood-kortingRood;
    		if(effectieveKostRood<0) {
    			effectieveKostRood=0;
    		}
    		effectieveKostZwart = kostZwart-kortingZwart;
    		if(effectieveKostZwart<0) {
    			effectieveKostZwart=0;
    		}
    		effectieveKostBlauw = kostBlauw-kortingBlauw;
    		if(effectieveKostBlauw<0) {
    			effectieveKostBlauw=0;
    		}
    		effectieveKostGroen = kostGroen-kortingGroen;
    		if(effectieveKostGroen<0) {
    			effectieveKostGroen=0;
    		}
    		
    		int bezitWit = Integer.parseInt(lblWit4.getText());
    		int bezitRood = Integer.parseInt(lblRood4.getText());
    		int bezitZwart = Integer.parseInt(lblZwart4.getText());
    		int bezitBlauw = Integer.parseInt(lblBlauw4.getText());
    		int bezitGroen = Integer.parseInt(lblGroen4.getText());
    		
    		if(bezitWit >= effectieveKostWit && bezitRood >= effectieveKostRood && 
    				bezitZwart >= effectieveKostZwart && bezitBlauw >= effectieveKostBlauw 
    				&& bezitGroen >= effectieveKostGroen)
    		{
    			
    			//Gems speler aftrekken
    			bezitWit -= effectieveKostWit;
    			bezitRood -= effectieveKostRood;
    			bezitZwart -= effectieveKostZwart;
    			bezitBlauw -= effectieveKostBlauw;
    			bezitGroen -= effectieveKostGroen;
    			
    			lblWit4.setText(Integer.toString(bezitWit));
    			lblRood4.setText(Integer.toString(bezitRood));
    			lblZwart4.setText(Integer.toString(bezitZwart));
    			lblBlauw4.setText(Integer.toString(bezitBlauw));
    			lblGroen4.setText(Integer.toString(bezitGroen));
    			
    			//Gems lobby toevoegen
    			int huidigBeschWit = Integer.parseInt(btnWit.getText());
    			int huidigBeschRood = Integer.parseInt(btnRood.getText());
    			int huidigBeschZwart = Integer.parseInt(btnZwart.getText());
    			int huidigBeschBlauw = Integer.parseInt(btnBlauw.getText());
    			int huidigBeschGroen = Integer.parseInt(btnGroen.getText());
    			
    			huidigBeschWit += effectieveKostWit;
    			huidigBeschRood += effectieveKostRood;
    			huidigBeschZwart += effectieveKostZwart;
    			huidigBeschBlauw += effectieveKostBlauw;
    			huidigBeschGroen += effectieveKostGroen;
    			
    			Wit.setAantal(huidigBeschWit);
    			Rood.setAantal(huidigBeschRood);
    			Zwart.setAantal(huidigBeschZwart);
    			Blauw.setAantal(huidigBeschBlauw);
    			Groen.setAantal(huidigBeschGroen);
    			
    			btnWit.setText(Integer.toString(huidigBeschWit));
    			btnRood.setText(Integer.toString(huidigBeschRood));
    			btnZwart.setText(Integer.toString(huidigBeschZwart));
    			btnBlauw.setText(Integer.toString(huidigBeschBlauw));
    			btnGroen.setText(Integer.toString(huidigBeschGroen));
    			
    			int witWeg = 0;
    			int roodWeg = 0;
    			int zwartWeg = 0;
    			int blauwWeg = 0;
    			int groenWeg = 0;
    			
    			List<Edelsteen> tussenStop = new ArrayList<>();
    			
    			for(Edelsteen e : huidigeSpeler.getEdelstenen())
    			{
    				
    				if(witWeg < kostWit)
    				{
    					if(e.getKleur().equals(Kleur.WIT))
        				{
    						tussenStop.add(e);
        					witWeg++;
        				}
    				}
    				
    				if(roodWeg < kostRood)
    				{
    					if(e.getKleur().equals(Kleur.ROOD))
        				{
    						tussenStop.add(e);
        					roodWeg++;
        				}
    				}
    				
    				if(zwartWeg < kostZwart)
    				{
    					if(e.getKleur().equals(Kleur.ZWART))
        				{
    						tussenStop.add(e);
        					zwartWeg++;
        				}
    				}
    				
    				if(blauwWeg < kostBlauw)
    				{
    					if(e.getKleur().equals(Kleur.BLAUW))
        				{
    						tussenStop.add(e);
        					blauwWeg++;
        				}
    				}
    				
    				if(groenWeg < kostGroen)
    				{
    					if(e.getKleur().equals(Kleur.GROEN))
        				{
    						tussenStop.add(e);
        					groenWeg++;
        				}
    				}	
    			}
    			
    			for(Edelsteen e : tussenStop)
    			{
    				if(huidigeSpeler.getEdelstenen().contains(e))
    				{
    					huidigeSpeler.getEdelstenen().remove(e);
    				}
    			}
    			
    			speler4Wit -= witWeg;
    			speler4Rood -= roodWeg;
    			speler4Zwart -= zwartWeg;
    			speler4Blauw -= blauwWeg;
    			speler4Groen -= groenWeg;
    			
    			puntenSpeler4 += kaartenNiveau3.get(hulp2niveau3).getPrestigepunten();
    			lblSpeler4Punten.setText(taal.getProperty(taalKeuze + "AantalPunten")+ puntenSpeler4);
    			
    			
    			double newWidth = 120; 
    	        double newHeight = 145;
    			
    	        huidigeSpeler.getKaarten().add(kaartenNiveau3.get(hulp2niveau3));
    	        
    	        Image tussenImage = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        gekochteKaartenSpeler4.add(tussenImage);
    	        HboxKaartenSpeler4.getChildren().clear();  
    	        VboxSpeler4.getChildren().remove(HboxKaartenSpeler4);
    	        
    	        for(Image i : gekochteKaartenSpeler4)
    	        { 	
        	        ImageView imageGekochteKaart = new ImageView(i);
    	        	imageGekochteKaart.setFitWidth(96);
    	        	imageGekochteKaart.setFitHeight(116);
    	        	HboxKaartenSpeler4.getChildren().add(imageGekochteKaart);
    	        }
    	        VboxSpeler4.getChildren().add(HboxKaartenSpeler4);
    	        
    	        hulp2niveau3 += 3;
    	        Image kaartV09 = new Image(this.getClass().getResourceAsStream("/images/kaart_"+kaartenNiveau3.get(hulp2niveau3).getKaartID()+".jpg"));
    	        ImageView kaartV9 = new ImageView(kaartV09);
    	        kaartV9.setFitWidth(newWidth);
    	        kaartV9.setFitHeight(newHeight);
    	        kaartV9.setStyle("-fx-background-color: transparent;");
    	        gridCenter.getChildren().remove(btnKaart9);
    	        btnKaart9 = new Button();
    	        btnKaart9.setGraphic(kaartV9);
    	        btnKaart9.setStyle("-fx-background-color: transparent;");
    	      
    	        gridCenter.add(btnKaart9, 3, 3);
    	        btnKaart9.setOnAction(this::buttonPushedKoopKaart8);
    			gelukt = true;
    			
    		}
    	}
    	if(!gelukt) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
			alert.setHeaderText(taal.getProperty(taalKeuze + "OnvoldoendeSaldo"));
			alert.showAndWait();
		}
   }  
    
    private void buttonPushedWit(ActionEvent event) {
	 	if(Wit.getAantal() == 0)
	 	{
	 		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "Op"));
    		alert.showAndWait();
	 	}else
	 	{
	 		if(huidigeSpeler.getEdelstenen().size() == 10)
		 	{
		 		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
	    		alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGems"));
	    		alert.showAndWait();
		 	}else {
		 		 		
		 		if(genomenEdelstenen.size() == 3)
		 		{
		 			Alert alert = new Alert(Alert.AlertType.ERROR);
		 			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 			alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 			alert.showAndWait();
		 		}else
		 		{
		 			
		 			for(Edelsteen e : genomenEdelstenen)
		 			{
		 				if (e.getKleur().equals(Kleur.WIT)) {
		 					aantalWitteInBeurt++;
		 				}
		 			}
		 		 	
		 			int beschikbareWitte = Wit.getAantal();
		 			
		 			if(beschikbareWitte >= 4 && aantalWitteInBeurt + 1 <=2 || beschikbareWitte < 4 && aantalWitteInBeurt + 1 == 1 )
		 			{
		 				Wit.setAantal(Wit.getAantal() - 1);
	 					genomenEdelstenen.add(new Edelsteen(Kleur.WIT, 1));
	 					huidigeSpeler.getEdelstenen().add(new Edelsteen(Kleur.WIT, 1));
	 					btnWit.setText(Integer.toString(Wit.getAantal()));
	 					
	 					int aantal = 0;
	 					Edelsteen e = genomenEdelstenen.get(genomenEdelstenen.size()-1);
	 					
	 					if (e.getKleur().equals(Kleur.WIT)) {
	 							aantal++;				
	 					}
	 					
	 					switch(getal)
	 					{
	 					case 0 -> speler1Wit += aantal;
	 					case 1 -> speler2Wit += aantal;
	 					case 2 -> speler3Wit += aantal;
	 					case 3 -> speler4Wit += aantal;
	 					}
	 					
	 					switch(getal)
	 					{
							case 0 -> lblWit.setText(String.valueOf(speler1Wit));
							case 1 -> lblWit2.setText(String.valueOf(speler2Wit));
							case 2 -> lblWit3.setText(String.valueOf(speler3Wit));
							case 3 -> lblWit4.setText(String.valueOf(speler4Wit));
							}
	 					aantalWitteInBeurt = 0;
		 			}
		 			else
		 			{
		 				if(beschikbareWitte < 4 )
		 				{
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "TeWeinigInStock"));
		 					alert.showAndWait();
		 				}else {
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 					alert.showAndWait();
		 				}
		 			}
		 		}
		 	}
	 	}
	}
    
    private void buttonPushedRood(ActionEvent event) {
    	if(Rood.getAantal() == 0)
	 	{
	 		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "Op"));
    		alert.showAndWait();
	 	}else
	 	{
	 		if(huidigeSpeler.getEdelstenen().size() == 10)
		 	{
		 		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
	    		alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGems"));
	    		alert.showAndWait();
		 	}else {
		 		 		
		 		if(genomenEdelstenen.size() == 3)
		 		{
		 			Alert alert = new Alert(Alert.AlertType.ERROR);
		 			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 			alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 			alert.showAndWait();
		 		}else
		 		{
		 			
		 			for(Edelsteen e : genomenEdelstenen)
		 			{
		 				if (e.getKleur().equals(Kleur.ROOD)) {
		 					aantalRodeInBeurt++;
		 				}
		 			}
		 		 	
		 			int beschikbareRode = Rood.getAantal();
		 			
		 			if(beschikbareRode >= 4 && aantalRodeInBeurt + 1 <=2 || beschikbareRode < 4 && aantalRodeInBeurt + 1 == 1 )
		 			{
		 				Rood.setAantal(Rood.getAantal() - 1);
	 					genomenEdelstenen.add(new Edelsteen(Kleur.ROOD, 1));
	 					huidigeSpeler.getEdelstenen().add(new Edelsteen(Kleur.ROOD, 1));
	 					btnRood.setText(Integer.toString(Rood.getAantal()));
	 					int aantal = 0;
	 					Edelsteen e = genomenEdelstenen.get(genomenEdelstenen.size()-1);
	 					
	 					if (e.getKleur().equals(Kleur.ROOD)) {
	 							aantal++;				
	 					}
	 					
	 					switch(getal)
	 					{
	 					case 0 -> speler1Rood += aantal;
	 					case 1 -> speler2Rood += aantal;
	 					case 2 -> speler3Rood += aantal;
	 					case 3 -> speler4Rood += aantal;
	 					}
	 					
	 					switch(getal)
	 					{
							case 0 -> lblRood.setText(String.valueOf(speler1Rood));
							case 1 -> lblRood2.setText(String.valueOf(speler2Rood));
							case 2 -> lblRood3.setText(String.valueOf(speler3Rood));
							case 3 -> lblRood4.setText(String.valueOf(speler4Rood));
							}
	 					aantalRodeInBeurt = 0;
		 			}
		 			else
		 			{
		 				if(beschikbareRode < 4 )
		 				{
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "TeWeinigInStock"));
		 					alert.showAndWait();
		 				}else {
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 					alert.showAndWait();
		 				}
		 			}
		 		}
		 	}
	 	}
    }
    
    private void buttonPushedZwart(ActionEvent event) {
    	if(Zwart.getAantal() == 0)
	 	{
	 		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "Op"));
    		alert.showAndWait();
	 	}else
	 	{
	 		if(huidigeSpeler.getEdelstenen().size() == 10)
		 	{
		 		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
	    		alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGems"));
	    		alert.showAndWait();
		 	}else {
		 		 		
		 		if(genomenEdelstenen.size() == 3)
		 		{
		 			Alert alert = new Alert(Alert.AlertType.ERROR);
		 			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 			alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 			alert.showAndWait();
		 		}else
		 		{
		 			
		 			for(Edelsteen e : genomenEdelstenen)
		 			{
		 				if (e.getKleur().equals(Kleur.ZWART)) {
		 					aantalZwarteInBeurt++;
		 				}
		 			}
		 		 	
		 			int beschikbareZwarte = Zwart.getAantal();
		 			
		 			if(beschikbareZwarte >= 4 && aantalZwarteInBeurt + 1 <=2 || beschikbareZwarte < 4 && aantalZwarteInBeurt + 1 == 1 )
		 			{
		 				Zwart.setAantal(Zwart.getAantal() - 1);
	 					genomenEdelstenen.add(new Edelsteen(Kleur.ZWART, 1));
	 					huidigeSpeler.getEdelstenen().add(new Edelsteen(Kleur.ZWART, 1));
	 					btnZwart.setText(Integer.toString(Zwart.getAantal()));
	 					int aantal = 0;
	 					Edelsteen e = genomenEdelstenen.get(genomenEdelstenen.size()-1);
	 					
	 					if (e.getKleur().equals(Kleur.ZWART)) {
	 							aantal++;				
	 					}
	 					
	 					switch(getal)
	 					{
	 					case 0 -> speler1Zwart += aantal;
	 					case 1 -> speler2Zwart += aantal;
	 					case 2 -> speler3Zwart += aantal;
	 					case 3 -> speler4Zwart += aantal;
	 					}
	 					
	 					switch(getal)
	 					{
							case 0 -> lblZwart.setText(String.valueOf(speler1Zwart));
							case 1 -> lblZwart2.setText(String.valueOf(speler2Zwart));
							case 2 -> lblZwart3.setText(String.valueOf(speler3Zwart));
							case 3 -> lblZwart4.setText(String.valueOf(speler4Zwart));
							}
	 					aantalZwarteInBeurt = 0;
		 			}
		 			else
		 			{
		 				if(beschikbareZwarte < 4 )
		 				{
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "TeWeinigInStock"));
		 					alert.showAndWait();
		 				}else {
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 					alert.showAndWait();
		 				}
		 			}
		 		}
		 	}
	 	}
    }
    
    private void buttonPushedBlauw(ActionEvent event) {
    	if(Blauw.getAantal() == 0)
	 	{
	 		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "Op"));
    		alert.showAndWait();
	 	}else
	 	{
	 		if(huidigeSpeler.getEdelstenen().size() == 10)
		 	{
		 		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
	    		alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGems"));
	    		alert.showAndWait();
		 	}else {
		 		 		
		 		if(genomenEdelstenen.size() == 3)
		 		{
		 			Alert alert = new Alert(Alert.AlertType.ERROR);
		 			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 			alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 			alert.showAndWait();
		 		}else
		 		{
		 			
		 			for(Edelsteen e : genomenEdelstenen)
		 			{
		 				if (e.getKleur().equals(Kleur.BLAUW)) {
		 					aantalBlauweInBeurt++;
		 				}
		 			}
		 		 	
		 			int beschikbareBlauwe = Blauw.getAantal();
		 			
		 			if(beschikbareBlauwe >= 4 && aantalBlauweInBeurt + 1 <=2 || beschikbareBlauwe < 4 && aantalBlauweInBeurt + 1 == 1 )
		 			{
		 				Blauw.setAantal(Blauw.getAantal() - 1);
	 					genomenEdelstenen.add(new Edelsteen(Kleur.BLAUW, 1));
	 					huidigeSpeler.getEdelstenen().add(new Edelsteen(Kleur.BLAUW, 1));
	 					btnBlauw.setText(Integer.toString(Blauw.getAantal()));
	 					int aantal = 0;
	 					Edelsteen e = genomenEdelstenen.get(genomenEdelstenen.size()-1);
	 					
	 					if (e.getKleur().equals(Kleur.BLAUW)) {
	 							aantal++;				
	 					}
	 					
	 					switch(getal)
	 					{
	 					case 0 -> speler1Blauw += aantal;
	 					case 1 -> speler2Blauw += aantal;
	 					case 2 -> speler3Blauw += aantal;
	 					case 3 -> speler4Blauw += aantal;
	 					}
	 					
	 					switch(getal)
	 					{
							case 0 -> lblBlauw.setText(String.valueOf(speler1Blauw));
							case 1 -> lblBlauw2.setText(String.valueOf(speler2Blauw));
							case 2 -> lblBlauw3.setText(String.valueOf(speler3Blauw));
							case 3 -> lblBlauw4.setText(String.valueOf(speler4Blauw));
							}
	 					aantalBlauweInBeurt = 0;
		 			}
		 			else
		 			{
		 				if(beschikbareBlauwe < 4 )
		 				{
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "TeWeinigInStock"));
		 					alert.showAndWait();
		 				}else {
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 					alert.showAndWait();
		 				}
		 			}
		 		}
		 	}
	 	}
    }
    
    private void buttonPushedGroen(ActionEvent event) {
    	if(Groen.getAantal() == 0)
	 	{
	 		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
    		alert.setHeaderText(taal.getProperty(taalKeuze + "Op"));
    		alert.showAndWait();
	 	}else
	 	{
	 		if(huidigeSpeler.getEdelstenen().size() == 10)
		 	{
		 		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setTitle(taal.getProperty(taalKeuze + "Error"));
	    		alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGems"));
	    		alert.showAndWait();
		 	}else {
		 		 		
		 		if(genomenEdelstenen.size() == 3)
		 		{
		 			Alert alert = new Alert(Alert.AlertType.ERROR);
		 			alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 			alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 			alert.showAndWait();
		 		}else
		 		{
		 			
		 			for(Edelsteen e : genomenEdelstenen)
		 			{
		 				if (e.getKleur().equals(Kleur.GROEN)) {
		 					aantalGroeneInBeurt++;
		 				}
		 			}
		 		 	
		 			int beschikbareGroene = Groen.getAantal();
		 			
		 			if(beschikbareGroene >= 4 && aantalGroeneInBeurt + 1 <=2 || beschikbareGroene < 4 && aantalGroeneInBeurt + 1 == 1 )
		 			{
		 				Groen.setAantal(Groen.getAantal() - 1);
	 					genomenEdelstenen.add(new Edelsteen(Kleur.GROEN, 1));
	 					huidigeSpeler.getEdelstenen().add(new Edelsteen(Kleur.GROEN, 1));
	 					btnGroen.setText(Integer.toString(Groen.getAantal()));
	 					int aantal = 0;
	 					Edelsteen e = genomenEdelstenen.get(genomenEdelstenen.size()-1);
	 					
	 					if (e.getKleur().equals(Kleur.GROEN)) {
	 							aantal++;				
	 					}
	 					
	 					switch(getal)
	 					{
	 					case 0 -> speler1Groen += aantal;
	 					case 1 -> speler2Groen += aantal;
	 					case 2 -> speler3Groen += aantal;
	 					case 3 -> speler4Groen += aantal;
	 					}
	 					
	 					switch(getal)
	 					{
							case 0 -> lblGroen.setText(String.valueOf(speler1Groen));
							case 1 -> lblGroen2.setText(String.valueOf(speler2Groen));
							case 2 -> lblGroen3.setText(String.valueOf(speler3Groen));
							case 3 -> lblGroen4.setText(String.valueOf(speler4Groen));
							}
	 					aantalGroeneInBeurt = 0;
		 			}
		 			else
		 			{
		 				if(beschikbareGroene < 4 )
		 				{
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "TeWeinigInStock"));
		 					alert.showAndWait();
		 				}else {
		 					Alert alert = new Alert(Alert.AlertType.ERROR);
		 					alert.setTitle(taal.getProperty(taalKeuze + "Error"));
		 					alert.setHeaderText(taal.getProperty(taalKeuze + "MaxGenomenGems"));
		 					alert.showAndWait();
		 				}
		 				
		 			}
		 		}
		 	}
	 	}
    }
}