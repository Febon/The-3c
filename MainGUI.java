package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainGUI extends Application {
	private static Desktop desktop = Desktop.getDesktop();
	Button button;
	Scene scene1 , scene2;
	BorderPane layout;
	public static void main(String[] args) {
		launch(args);
	}

	private void closeProgram() {
		Boolean answer = ConfirmClosureBox.display("The 3 C's","Sure you want to exit?");
		if(answer) {
			Platform.exit();
			System.out.println("Thanks for trusting us by using our program.");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

			Label label1 = new Label("Welcome to our little magic world,wut?");
			Label label2 = new Label("Above this text you can locate your file's path");
			Label label3 = new Label("Since you are here though let -The Three C's- handle it, do their magic for you and correct any possible mistakes.");

			//Label 1-Welcome Stage,Button 1 is used for the user to proceed to the next stage where the magic happens.
			Button proceedButton = new Button("Procceed to stage 2.");
			proceedButton.setOnAction(e -> primaryStage.setScene(scene2));

			primaryStage.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});

			//Add the three C's image


			Button exitButton = new Button("Exit Program");
			exitButton.setOnAction(e-> closeProgram());


			//File menu creator(example from NotePad)
			Menu fileMenu = new Menu("File");
			Menu editMenu = new Menu("Edit");

			fileMenu.getItems().add(new MenuItem("New text file"));
			fileMenu.getItems().add(new MenuItem("Open..."));
			fileMenu.getItems().add(new MenuItem("Save"));
			fileMenu.getItems().add(new MenuItem("Save as..."));
			fileMenu.getItems().add(new MenuItem("Exit"));

			editMenu.getItems().add(new MenuItem("Undo"));
			editMenu.getItems().add(new MenuItem("Cut"));
			editMenu.getItems().add(new MenuItem("Copy"));
			editMenu.getItems().add(new MenuItem("Paste"));
			editMenu.getItems().add(new MenuItem("Delete"));

			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu, editMenu);

			layout = new BorderPane();
			layout.setTop(menuBar);

			FileChooser fileChooser = new FileChooser();
			Button openButton = new Button("Open a file");

			openButton.setOnAction(e -> {
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null) {
					openFile(file);
				}
			});
			Label chosenFP = new Label();
			Button getFilePath = new Button("Get file path");

			getFilePath.setOnAction(e-> {
				FileChooser chooser = new FileChooser();
				File file = chooser.showOpenDialog(primaryStage);
				if (file != null) {
					String fileAsString = file.toString();
					chosenFP.setText("Chosen file is in path: " +fileAsString);
				} else {
					chosenFP.setText(null);
				}
			});


			VBox layout1 = new VBox(20);
			layout1.getChildren().addAll(label1, proceedButton, exitButton);
			scene1 = new Scene(layout1, 300,300);

			primaryStage.setTitle("The three C's");
			primaryStage.setScene(scene1);
			primaryStage.show();

			VBox layout2 = new VBox(20,menuBar, chosenFP);
			layout2.getChildren().addAll(label2, label3,openButton, getFilePath, exitButton);
			scene2 = new Scene(layout2, 600,300);
		}
	static void openFile(File file) {
		try {
			desktop.open(file);
		} catch (IOException e) {
		}
	}
}
