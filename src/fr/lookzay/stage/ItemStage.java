package fr.lookzay.stage;

import fr.lookzay.AlertMain;
import fr.lookzay.generator.ItemGenerator;
import fr.lookzay.value.Infos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ItemStage {

    public void generateStage(Stage primaryStage, Image icon){
        Label titleItem = new Label("Item Json Creator");
        titleItem.setFont(new Font("Arial", 28));
        titleItem.setLayoutX(105);
        titleItem.setLayoutY(5);
        titleItem.setStyle(Infos.cssTitle);

        Label itemNameLabel = new Label("Item Name :");
        itemNameLabel.setFont(new Font("Arial", 12));
        itemNameLabel.setLayoutX(10);
        itemNameLabel.setLayoutY(80);

        TextField itemNameField = new TextField("");
        itemNameField.setMinWidth(190);
        itemNameField.setLayoutY(75);
        itemNameField.setLayoutX(100);

        Label textureNameLabel = new Label("Texture Name :");
        textureNameLabel.setFont(new Font("Arial", 12));
        textureNameLabel.setLayoutX(10);
        textureNameLabel.setLayoutY(120);

        TextField textureNameField = new TextField("");
        textureNameField.setMinWidth(190);
        textureNameField.setLayoutY(115);
        textureNameField.setLayoutX(100);

        CheckBox isTool = new CheckBox();
        isTool.setLayoutY(170);
        isTool.setLayoutX(140);

        Label isToolLabel = new Label("Is tool: ");
        isToolLabel.setFont(new Font("Arial", 12));
        isToolLabel.setLayoutX(100);
        isToolLabel.setLayoutY(170);

        Button launch = new Button("Create");
        launch.setLayoutY(167);
        launch.setLayoutX(175);
        launch.setMinWidth(112);
        launch.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                boolean isSelected = isTool.isSelected();
                if(!(itemNameField.getLength() == 0 || textureNameField.getLength() == 0)){
                    if (isSelected == true){
                        ItemGenerator.writeItemJson(itemNameField.getText(), textureNameField.getText(), true);
                        AlertMain.alert(Alert.AlertType.INFORMATION, Infos.frameName, "Votre fichier a bien était créer !", "Dans : export/models/item");
                    } else {
                        ItemGenerator.writeItemJson(itemNameField.getText(), textureNameField.getText(), false);
                        AlertMain.alert(Alert.AlertType.INFORMATION, Infos.frameName, "Votre fichier a bien était créer !", "Dans : export/models/item");
                    }
                } else {
                    AlertMain.alert(Alert.AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                }
            }
        });

        Group componentsGUI = new Group();
        componentsGUI.getChildren().addAll(itemNameField, titleItem, itemNameLabel, textureNameField, textureNameLabel, isTool, isToolLabel, launch);

        Scene otherScene = new Scene(componentsGUI, 400, 250);

        Stage itemStage = new Stage();
        itemStage.setTitle("Item JSON");
        itemStage.setScene(otherScene);
        itemStage.setResizable(false);
        itemStage.getIcons().add(icon);

        itemStage.setX(primaryStage.getX() + 200);
        itemStage.setY(primaryStage.getY() + 100);

        itemStage.show();
    }
}
