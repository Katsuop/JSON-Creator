package fr.lookzay.stage;

import fr.lookzay.AlertMain;
import fr.lookzay.components.Components;
import fr.lookzay.generator.BlockGenerator;
import fr.lookzay.value.Infos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BlockStage {

    public void generateStage(Stage primaryStage, Image icon){
        Components components = new Components();
        Label titleBlock = new Label(), blockNameLabel = new Label(),  textureNameLabel = new Label();
        TextField blockNameField = new TextField(), textureNameField = new TextField();
        Button launch = new Button();

        components.setLabel(titleBlock, "Block Json Creator", 86, 5, Infos.cssTitle, "Arial", 28);
        components.setLabel(blockNameLabel, "Block Name :", 10, 86);
        components.setTextField(blockNameField, 100, 75, 190);
        components.setLabel(textureNameLabel, "Texture Name :", 10, 120);
        components.setTextField(textureNameField, 100, 115, 190);
        components.setButton(launch, "Create", 100, 155, 190);

        launch.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!(blockNameField.getLength() == 0 || textureNameField.getLength() == 0)){
                    BlockGenerator.writeBlockstates(blockNameField.getText());
                    BlockGenerator.writeBlockJson(blockNameField.getText(), textureNameField.getText());
                    AlertMain.alert(Alert.AlertType.INFORMATION, Infos.frameName, "Vos fichiers ont bien été créer !", "Dans : export/models/block  | et |  export/blockstates");
                } else {
                    AlertMain.alert(Alert.AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                }
            }
        });

        Group componentsGUI = new Group();
        componentsGUI.getChildren().addAll(blockNameField, blockNameLabel, titleBlock, textureNameLabel, textureNameField, launch);

        Scene otherScene = new Scene(componentsGUI, 400, 250);

        Stage blockStage = new Stage();
        blockStage.setTitle("Block JSON");
        blockStage.setScene(otherScene);
        blockStage.setResizable(false);
        blockStage.getIcons().add(icon);

        blockStage.setX(primaryStage.getX() + 200);
        blockStage.setY(primaryStage.getY() + 100);

        blockStage.show();
    }

}
