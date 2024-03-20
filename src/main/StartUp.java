 package main;

import cui.SplendorApplicatie;
import domein.DomeinController;
import gui.TaalScherm;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Create the root layout
            BorderPane root = new BorderPane();
            root.setPadding(new Insets(10));

            // Create the exit button and set its action
            Button exitButton = new Button("X");
            exitButton.setOnAction(e -> System.exit(0));
            BorderPane.setAlignment(exitButton, Pos.TOP_RIGHT);
            root.setTop(exitButton);

            // Create the language selection screen and set it as the center of the root layout
            TaalScherm taalScherm = new TaalScherm();
            root.setCenter(taalScherm);

            // Create the scene and set it as the primary stage's scene
            Scene scene = new Scene(root, 400, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Splendor");
            primaryStage.setResizable(false);
            Image iconImage = new Image(this.getClass().getResourceAsStream("/images/Splendor.png"));
            primaryStage.getIcons().add(iconImage);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DomeinController dc = new DomeinController();
        SplendorApplicatie sa = new SplendorApplicatie(dc);
        sa.kiesTaal();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
