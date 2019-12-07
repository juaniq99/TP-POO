package game.frontend;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public enum levelType {
    LEVEL1("1") {
        @Override
        public void runLevel(GameApp gameApp, Stage stage) {
            gameApp.runLevel1(stage);
        }
    }, LEVEL2("2"){
        @Override
        public void runLevel(GameApp gameApp, Stage stage) {
            gameApp.runLevel2(stage);
        }
    }, LEVEL3("3"){
        @Override
        public void runLevel(GameApp gameApp, Stage stage) {
            gameApp.runLevel3(stage);
        }
    };
    private String level;

    levelType(String level) {
        this.level = level;
    }

    public void leveler(GameApp gameApp, Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cambiar Nivel");
        alert.setHeaderText("Cambiar el nivel actual al nivel " + getLevel());
        alert.setContentText("Se perderá el progreso en el nivel actual, si está jugando uno");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                runLevel(gameApp,stage);
            }
        }
    }

    public String getLevel() {
        return level;
    }

    abstract void runLevel(GameApp gameApp, Stage stage);
}
