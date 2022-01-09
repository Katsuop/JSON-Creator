package fr.lookzay.stage;

import fr.lookzay.value.Infos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageManager {

    public void createNewStage(Stage primaryStage, Group components, String title, boolean isResizable, Image icon, int width, int height, int setX, int setY){
        Scene scene = new Scene(components, width, height);

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(isResizable);
        stage.getIcons().add(icon);
        stage.setX(primaryStage.getX() + setX);
        stage.setY(primaryStage.getY() + setY);
        stage.show();
    }
    public void createNewStage(Stage primaryStage, Group components, String title, boolean isResizable, Image icon, int width, int height){
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setTitle(title);
        primaryStage.setResizable(isResizable);
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(components));
        primaryStage.show();
    }
}
