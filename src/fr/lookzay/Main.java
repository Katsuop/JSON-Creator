package fr.lookzay;

import fr.lookzay.components.Components;
import fr.lookzay.stage.*;
import fr.lookzay.value.Infos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class  Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group principalComponents = new Group();
        StageManager stageManager = new StageManager();
        stageManager.createNewStage(primaryStage, principalComponents, Infos.frameName, false, Infos.icon, 500, 300);
        Components components = new Components();

        Label title = new Label();
        Button block = new Button(), item = new Button(), credits = new Button(), itemCustom = new Button();

        components.setLabel(title, Infos.frameName, 120, 5, Infos.cssTitle, "Arial", 28);
        components.setButton(itemCustom, "Create Custom Item", 10, 140, 100, 40);
        components.setButton(item, "Item", 145, 140, 100, 40);
        components.setButton(block, "Block", 260, 140, 100, 40);
        components.setButton(credits, "Credits", 375, 140, 100, 40);

        /*itemCustom.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ItemCustomStage itemCustomStage = new ItemCustomStage();
                itemCustomStage.generateStage(primaryStage, Infos.icon);
            }
        });*/
        item.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ItemStage itemStage = new ItemStage();
                itemStage.generateStage(primaryStage, Infos.icon);
            }
        });
        block.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BlockStage blockStage = new BlockStage();
                blockStage.generateStage(primaryStage, Infos.icon);
            }
        });
        credits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreditsStage creditsStage = new CreditsStage();
                creditsStage.generateStage(primaryStage, Infos.icon);
            }
        });

        principalComponents.getChildren().addAll(title, item, block, itemCustom, credits);
    }
}