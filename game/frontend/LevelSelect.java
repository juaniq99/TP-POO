package game.frontend;


import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class LevelSelect extends VBox {

    public LevelSelect(GameApp gameApp, Stage stage) {

        VBox levelHolder = new VBox();

        Button level1 = new Button("Classic!");
        Button level2 = new Button("Jailed!");
        Button level3 = new Button("Fruits!");
        levelHolder.setSpacing(25);
        BackgroundImage background = new BackgroundImage(new Image("images/" + "background.jpg",1050,225,true,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        levelHolder.setBackground(new Background(background));
        level1.setStyle("-fx-background-color: transparent; -fx-text-alignment: center;-fx-alignment: center;-fx-border-color: #ff4f51;-fx-border-width:2;-fx-font-size: 20");
        level2.setStyle("-fx-background-color: transparent;-fx-text-alignment: center;-fx-alignment: center;-fx-border-color: #41ff46;-fx-border-width:2;-fx-font-size: 20");
        level3.setStyle("-fx-background-color: transparent;-fx-text-alignment: center;-fx-alignment: center; -fx-border-color: #625eff;-fx-border-width:2;-fx-font-size: 20");

        level1.setPrefSize(400,50);
        level2.setPrefSize(level1.getPrefWidth(),level1.getPrefHeight());
        level3.setPrefSize(level1.getPrefWidth(),level1.getPrefHeight());


        level1.setOnAction(event -> levelType.LEVEL1.leveler(gameApp,stage));
        level2.setOnAction(event -> levelType.LEVEL2.leveler(gameApp,stage));
        level3.setOnAction(event -> levelType.LEVEL3.leveler(gameApp,stage));

        levelHolder.getChildren().addAll(level1,level2,level3);
        this.getChildren().add(levelHolder);
    }
}
