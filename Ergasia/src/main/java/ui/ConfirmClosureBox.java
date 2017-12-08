package ui;

import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class ConfirmClosureBox {
	static boolean confirmationAnswer;
	public static boolean display(String title, String message) {
		Stage closureStage = new Stage();

		closureStage.initModality(Modality.APPLICATION_MODAL);
		closureStage.setTitle(title);
		closureStage.setMinWidth(200);
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e -> {
			confirmationAnswer = true;
			closureStage.close();
		});
		noButton.setOnAction(e -> {
			confirmationAnswer = false;
			closureStage.close();
		});
				
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		closureStage.setScene(scene);
		closureStage.showAndWait();	
		return confirmationAnswer;
	}

}
