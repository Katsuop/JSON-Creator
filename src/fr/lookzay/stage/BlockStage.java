package fr.lookzay.stage;

import fr.lookzay.AlertMain;
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
        Label titleBlock = new Label("Block Json Creator");
        titleBlock.setFont(new Font("Arial", 28));
        titleBlock.setLayoutX(86);
        titleBlock.setLayoutY(5);
        titleBlock.setStyle(Infos.cssTitle);

        Label blockNameLabel = new Label("Block Name :");
        blockNameLabel.setFont(new Font("Arial", 12));
        blockNameLabel.setLayoutX(10);
        blockNameLabel.setLayoutY(80);

        TextField blockNameField = new TextField("");
        blockNameField.setMinWidth(190);
        blockNameField.setLayoutY(75);
        blockNameField.setLayoutX(100);

        Label textureNameLabelB = new Label("Texture Name :");
        textureNameLabelB.setFont(new Font("Arial", 12));
        textureNameLabelB.setLayoutX(10);
        textureNameLabelB.setLayoutY(120);

        TextField textureNameFieldB = new TextField("");
        textureNameFieldB.setMinWidth(190);
        textureNameFieldB.setLayoutY(115);
        textureNameFieldB.setLayoutX(100);

        Button launchB = new Button("Create");
        launchB.setLayoutY(155);
        launchB.setLayoutX(100);
        launchB.setMinWidth(190);
        launchB.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!(blockNameField.getLength() == 0 || textureNameFieldB.getLength() == 0)){
                    BlockGenerator.writeBlockstates(blockNameField.getText());
                    BlockGenerator.writeBlockJson(blockNameField.getText(), textureNameFieldB.getText());
                    AlertMain.alert(Alert.AlertType.INFORMATION, Infos.frameName, "Vos fichiers ont bien été créer !", "Dans : export/models/block  | et |  export/blockstates");
                } else {
                    AlertMain.alert(Alert.AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                }
            }
        });

        Group componentsGUI = new Group();
        componentsGUI.getChildren().addAll(blockNameField, blockNameLabel, titleBlock, textureNameFieldB, textureNameLabelB, launchB);

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
