package game.frontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu(GameApp gameApp, Stage stage) {

        Menu file = new Menu("Archivo");
        MenuItem exitMenuItem = new MenuItem("Salir");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("Salir de la aplicación");
            alert.setContentText("¿Está seguro que desea salir de la aplicación?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        file.getItems().add(exitMenuItem);

        Menu help = new Menu("Ayuda");
        MenuItem aboutMenuItem = new MenuItem("Acerca De");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca De");
            alert.setHeaderText("Candy TPE");
            alert.setContentText("Cátedra POO 2019.\n" +
                    "Implementacion: Juan Ignacio Quintairos, Gastón Donikian\n" + "Cualquier parecido con Candy Crush es pura coincidencia");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);

        Menu levels = new Menu("Seleccionar Nivel");

        MenuItem infoMenuItem = new MenuItem("Descripción niveles");
        infoMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Niveles");
            alert.setHeaderText("Descripción de los distintos niveles disponibles");
            alert.setContentText("Nivel 1: Clásico (Conseguir 5000 puntos en 20 movimientos)\n" +
                            "Nivel 2: Jaulas (Liberar las 8 jaulas en 25 movimientos)\n" +
                            "Nivel 3: Frutas (Llevar 4 frutas abajo de todo en 25 movimientos)\n");
            alert.showAndWait();
        });

        MenuItem level1MenuItem = new MenuItem("Nivel 1");
        level1MenuItem.setOnAction(event -> LevelType.LEVEL1.leveler(gameApp,stage));
        MenuItem level2MenuItem = new MenuItem("Nivel 2");
        level2MenuItem.setOnAction(event -> LevelType.LEVEL2.leveler(gameApp,stage));
        MenuItem level3MenuItem = new MenuItem("Nivel 3");
        level3MenuItem.setOnAction(event -> LevelType.LEVEL3.leveler(gameApp,stage));
        levels.getItems().addAll(infoMenuItem, level1MenuItem, level2MenuItem, level3MenuItem);
        getMenus().addAll(file, help, levels);

    }

}
