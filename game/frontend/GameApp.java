package game.frontend;

import game.backend.CandyGames.CandyGame;
import game.backend.CandyGames.CandyGameL2;
import game.backend.level.Level1;
import game.backend.level.Level2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox(8);
		vbox.getChildren().add(new AppMenu(this, primaryStage));
		Scene scene = new Scene(vbox);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void runLevel1(Stage primaryStage){
		CandyGame game = new CandyGame(Level1.class);
		CandyFrame frame = new CandyFrame(game, this, primaryStage);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void runLevel2(Stage primaryStage) {
		CandyGameL2 game = new CandyGameL2(Level2.class);
		CandyFrameL2 frame = new CandyFrameL2(game, this, primaryStage);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void runLevel3(Stage primaryStage) {
		/*CandyGameL3 game = new CandyGameL3(Level3.class);
		CandyFrameL3 frame = new CandyFrameL3(game, this, primaryStage);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();*/
	}
}
