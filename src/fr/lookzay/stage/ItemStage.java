package fr.lookzay.stage;

import fr.lookzay.AlertMain;
import fr.lookzay.components.Components;
import fr.lookzay.generator.ItemGenerator;
import fr.lookzay.value.Infos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ItemStage {

    public void generateStage(Stage primaryStage, Image icon){

        Components components = new Components();
        Label titleItem = new Label(), itemNameLabel = new Label(),  textureNameLabel = new Label(), isToolLabel = new Label();
        TextField itemNameField = new TextField(), textureNameField = new TextField();
        Button launch = new Button();
        CheckBox isTool = new CheckBox();

        components.setLabel(titleItem, "Item Json Creator", 105, 5, Infos.cssTitle, "Arial", 28);
        components.setLabel(itemNameLabel, "Item Name :", 10, 80);
        components.setTextField(itemNameField, 100, 75, 190);
        components.setLabel(textureNameLabel, "Texture Name :", 10, 120);
        components.setTextField(textureNameField, 100, 115, 190);
        components.setLabel(isToolLabel, "Is Tool :", 95, 171);
        components.setCheckbox(isTool, 140, 170);
        components.setButton(launch, "Create", 175, 167, 190);

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
