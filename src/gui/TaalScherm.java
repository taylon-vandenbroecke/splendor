package gui;

	import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
	import javafx.scene.paint.Color;
	import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

	public class TaalScherm extends GridPane{
		
		public TaalScherm() {
			buildGui(); 
		}

		private void buildGui() {
			
			this.setAlignment(Pos.CENTER);
			this.setHgap(5);
			this.setVgap(10);
			
			Label lbSplendor = new Label();
			lbSplendor.setText("Splendor");
			
			ImageView ivEngels = new ImageView();
			ImageView ivNederlands = new ImageView();
			ImageView ivFrans = new ImageView();
			
			ivNederlands.setImage(new Image(this.getClass().getResourceAsStream("/images/Nederlands.png")));
			ivNederlands.setPreserveRatio(true);
			Button btnNederlands = new Button();
			btnNederlands.setStyle("-fx-background-color: transparent;");
			this.add(btnNederlands, 0 , 1);
			btnNederlands.setPrefSize(75, 45);
			btnNederlands.setGraphic(ivNederlands);
			Label lbTaal = new Label("Taal");
			lbTaal.setFont(Font.font("Arial", 18));
			GridPane.setHalignment(lbTaal, HPos.CENTER);
			this.add(lbTaal, 0 , 2);
			
			ivEngels.setImage(new Image(this.getClass().getResourceAsStream("/images/Engels.png")));
			ivEngels.setPreserveRatio(true);
			Button btnEngels = new Button();
			btnEngels.setStyle("-fx-background-color: transparent;");
			this.add(btnEngels, 1, 1);
			btnEngels.setPrefSize(75, 45);
			btnEngels.setGraphic(ivEngels);
			Label lbLanguage = new Label("Language");
			lbLanguage.setFont(Font.font("Arial", 18));
			GridPane.setHalignment(lbLanguage, HPos.CENTER);
			this.add(lbLanguage, 1 , 2);
			
			ivFrans.setImage(new Image(this.getClass().getResourceAsStream("/images/Frans.png")));
			ivFrans.setPreserveRatio(true);
			Button btnFrans = new Button();
			btnFrans.setStyle("-fx-background-color: transparent;");
			this.add(btnFrans, 2 , 1);
			btnFrans.setPrefSize(75, 45);
			btnFrans.setGraphic(ivFrans);
			Label lbLangue = new Label("Langue");
			lbLangue.setFont(Font.font("Arial", 18));
			GridPane.setHalignment(lbLangue, HPos.CENTER);
			this.add(lbLangue, 2 , 2);
					
			btnNederlands.setOnAction(this::buttonPushedNL);
			btnEngels.setOnAction(this::buttonPushedENG);
			btnFrans.setOnAction(this::buttonPushedFR);
		}
		
		 private void buttonPushedNL(ActionEvent event) {
			BeginScherm bs = new BeginScherm("nederlands"); // <1>
		    Scene scene = new Scene(bs, 400, 200);
		    Stage stage = (Stage) this.getScene().getWindow();
		    stage.setScene(scene);
		    stage.centerOnScreen();
		    stage.show();
		 }
		 
		 private void buttonPushedENG(ActionEvent event) { 
			BeginScherm bs = new BeginScherm("engels"); // <1>
		    Scene scene = new Scene(bs, 400, 200);
			Stage stage = (Stage) this.getScene().getWindow();
		    stage.setScene(scene);
		    stage.centerOnScreen();
		    stage.show();
		 }
		 
		 private void buttonPushedFR(ActionEvent event) {       
			BeginScherm bs = new BeginScherm("frans"); // <1>
		    Scene scene = new Scene(bs, 400, 200);
		    Stage stage = (Stage) this.getScene().getWindow();
		    stage.setScene(scene);
		    stage.centerOnScreen();
		    stage.show();
		 }
}


