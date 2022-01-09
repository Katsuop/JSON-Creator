package fr.lookzay;

import fr.lookzay.components.Components;
import fr.lookzay.generator.BlockGenerator;
import fr.lookzay.generator.ItemGenerator;
import fr.lookzay.value.Infos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class  Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle(Infos.frameName);
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("/fr/lookzay/images/icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();

        Group group = new Group();

        //Titre de la Frame
        Label title = new Label(Infos.frameName);
        title.setFont(new Font("Arial", 28));
        title.setLayoutX(120);
        title.setLayoutY(5);
        title.setStyle("-fx-border-width: 2; -fx-border-color: #000000; -fx-border-style: solid;");

        Button block = new Button("Block");
        block.setMinHeight(40);
        block.setMinWidth(100);
        block.setLayoutX(260);
        block.setLayoutY(140);
        block.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            Label titleBlock = new Label("Block Json Creator");
            titleBlock.setFont(new Font("Arial", 28));
            titleBlock.setLayoutX(86);
            titleBlock.setLayoutY(5);
            titleBlock.setStyle("-fx-border-width: 2; -fx-border-color: #000000; -fx-border-style: solid;");

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
                        AlertMain.alert(AlertType.INFORMATION, Infos.frameName, "Vos fichiers ont bien été créer !", "Dans : export/models/block  | et |  export/blockstates");
                    } else {
                        AlertMain.alert(AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                    }
                }
            });

            Group groupB = new Group();
            groupB.getChildren().addAll(blockNameField, blockNameLabel, titleBlock, textureNameFieldB, textureNameLabelB, launchB);

            Scene secondScene = new Scene(groupB, 400, 250);

            Stage blockStage = new Stage();
            blockStage.setTitle("Block JSON");
            blockStage.setScene(secondScene);
            blockStage.setResizable(false);
            blockStage.getIcons().add(icon);

            blockStage.setX(primaryStage.getX() + 200);
            blockStage.setY(primaryStage.getY() + 100);

            blockStage.show();
            }
        });

        //Bouton Item
        Button item = new Button("Item");
        item.setMinHeight(40);
        item.setMinWidth(100);
        item.setLayoutX(145);
        item.setLayoutY(140);
        item.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label titleItem = new Label("Item Json Creator");
                titleItem.setFont(new Font("Arial", 28));
                titleItem.setLayoutX(105);
                titleItem.setLayoutY(5);
                titleItem.setStyle("-fx-border-width: 2; -fx-border-color: #000000; -fx-border-style: solid;");

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
                                AlertMain.alert(AlertType.INFORMATION, Infos.frameName, "Votre fichier a bien était créer !", "Dans : export/models/item");
                            } else {
                                ItemGenerator.writeItemJson(itemNameField.getText(), textureNameField.getText(), false);
                                AlertMain.alert(AlertType.INFORMATION, Infos.frameName, "Votre fichier a bien était créer !", "Dans : export/models/item");
                            }
                        } else {
                            AlertMain.alert(AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                        }
                    }
                });

                Group groupI = new Group();
                groupI.getChildren().addAll(itemNameField, titleItem, itemNameLabel, textureNameField, textureNameLabel, isTool, isToolLabel, launch);

                Scene secondScene = new Scene(groupI, 400, 250);

                Stage itemStage = new Stage();
                itemStage.setTitle("Item JSON");
                itemStage.setScene(secondScene);
                itemStage.setResizable(false);
                itemStage.getIcons().add(icon);

                itemStage.setX(primaryStage.getX() + 200);
                itemStage.setY(primaryStage.getY() + 100);

                itemStage.show();
            }
        });

        Button credits = new Button("Credits");
        credits.setMinHeight(40);
        credits.setMinWidth(100);
        credits.setLayoutX(375);
        credits.setLayoutY(140);

        Button itemCustom = new Button("Create Custom Item");
        itemCustom.setMinHeight(40);
        itemCustom.setMinWidth(100);
        itemCustom.setLayoutX(10);
        itemCustom.setLayoutY(140);
        itemCustom.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label titleItem = new Label(), itemNameLabel = new Label(), textureNameLabel = new Label(), thirdNameLabel = new Label(), firstNameLabel = new Label();
                Label tpr1a = new Label(), tpr2a = new Label(), tpr3a = new Label(), tpt1a = new Label(), tpt2a = new Label(), tpt3a = new Label(), tps1a = new Label(), tps2a = new Label(), tps3a = new Label();
                Label fpr1a = new Label(), fpr2a = new Label(), fpr3a = new Label(), fpt1a = new Label(), fpt2a = new Label(), fpt3a = new Label(), fps1a = new Label(), fps2a = new Label(), fps3a = new Label();

                TextField itemNameField = new TextField();
                TextField textureNameField = new TextField();
                TextField tpr1b = new TextField(), tpr2b = new TextField(), tpr3b = new TextField(), tpt1b = new TextField(), tpt2b = new TextField(), tpt3b = new TextField(), tps1b = new TextField(), tps2b = new TextField(), tps3b = new TextField();
                TextField fpr1b = new TextField(), fpr2b = new TextField(), fpr3b = new TextField(), fpt1b = new TextField(), fpt2b = new TextField(), fpt3b = new TextField(), fps1b = new TextField(), fps2b = new TextField(), fps3b = new TextField();

                Components components = new Components();

                components.setLabel(titleItem, "Item Json Creator", 205, 5, "-fx-border-width: 2; -fx-border-color: #000000; -fx-border-style: solid;", "Arial", 28);
                components.setTextFieldWithLabel(itemNameLabel, itemNameField, "Item Name :", 10, 70, 90, 65, 190);
                components.setTextFieldWithLabel(textureNameLabel, textureNameField, "Texture Name :", 300, 70, 390, 65, 190);
                components.setLabel(thirdNameLabel, "Third Person Variable :", 60, 120);
                components.setTextFieldWithLabel(tpr1a, tpr1b, "Rotate 1 :", 20, 150, 103, 147, 190);
                components.setTextFieldWithLabel(tpr2a, tpr2b, "Rotate 2 :", 20, 185, 103, 182, 190);
                components.setTextFieldWithLabel(tpr3a, tpr3b, "Rotate 3 :", 20, 220, 103, 217, 190);
                components.setTextFieldWithLabel(tpt1a, tpt1b, "Translation 1 :", 20, 250, 103, 247, 190);
                components.setTextFieldWithLabel(tpt2a, tpt2b, "Translation 2 :", 20, 280, 103, 277, 190);
                components.setTextFieldWithLabel(tpt3a, tpt3b, "Translation 3 :", 20, 310, 103, 307, 190);
                components.setTextFieldWithLabel(tps1a, tps1b, "Scale 1 :", 20, 340, 103, 337, 190);
                components.setTextFieldWithLabel(tps2a, tps2b, "Scale 2 :", 20, 370, 103, 367, 190);
                components.setTextFieldWithLabel(tps3a, tps3b, "Scale 3 :", 20, 400, 103, 397, 190);
                components.setLabel(firstNameLabel, "First Person Variable :", 360, 120);
                components.setTextFieldWithLabel(fpr1a, fpr1b, "Rotate 1 :", 320, 150, 403, 147, 190);
                components.setTextFieldWithLabel(fpr2a, fpr2b, "Rotate 2 :", 320, 185, 403, 182, 190);
                components.setTextFieldWithLabel(fpr3a, fpr3b, "Rotate 3 :", 320, 220, 403, 217, 190);
                components.setTextFieldWithLabel(fpt1a, fpt1b, "Translation 1 :", 320, 250, 403, 247, 190);
                components.setTextFieldWithLabel(fpt2a, fpt2b, "Translation 2 :", 320, 280, 403, 277, 190);
                components.setTextFieldWithLabel(fpt3a, fpt3b, "Translation 3 :", 320, 310, 403, 307, 190);
                components.setTextFieldWithLabel(fps1a, fps1b, "Scale 1 :", 320, 340, 403, 337, 190);
                components.setTextFieldWithLabel(fps2a, fps2b, "Scale 2 :", 320, 370, 403, 367, 190);
                components.setTextFieldWithLabel(fps3a, fps3b, "Scale 3 :", 320, 400, 403, 397, 190);

                Button createFile = new Button("Create File");
                createFile.setLayoutY(420);
                createFile.setLayoutX(175);
                createFile.setMinWidth(112);
                createFile.setOnAction(new EventHandler<ActionEvent>() {

                     @Override
                     public void handle(ActionEvent event) {

                         Double tpr1bd = Double.parseDouble(tpr1b.getText());
                         Double tpr2bd = Double.parseDouble(tpr2b.getText());
                         Double tpr3bd = Double.parseDouble(tpr3b.getText());
                         Double tpt1bd = Double.parseDouble(tpt1b.getText());
                         Double tpt2bd = Double.parseDouble(tpt2b.getText());
                         Double tpt3bd = Double.parseDouble(tpt3b.getText());
                         Double tps1bd = Double.parseDouble(tps1b.getText());
                         Double tps2bd = Double.parseDouble(tps2b.getText());
                         Double tps3bd = Double.parseDouble(tps3b.getText());

                         Double fpr1bd = Double.parseDouble(fpr1b.getText());
                         Double fpr2bd = Double.parseDouble(fpr2b.getText());
                         Double fpr3bd = Double.parseDouble(fpr3b.getText());
                         Double fpt1bd = Double.parseDouble(fpt1b.getText());
                         Double fpt2bd = Double.parseDouble(fpt2b.getText());
                         Double fpt3bd = Double.parseDouble(fpt3b.getText());
                         Double fps1bd = Double.parseDouble(fps1b.getText());
                         Double fps2bd = Double.parseDouble(fps2b.getText());
                         Double fps3bd = Double.parseDouble(fps3b.getText());

                         if(!(itemNameField.getLength() == 0 || textureNameField.getLength() == 0)){
                             ItemGenerator.writeCustomItemJson(itemNameField.getText(), textureNameField.getText(), tpr1bd, tpr2bd, tpr3bd, tpt1bd, tpt2bd, tpt3bd, tps1bd, tps2bd, tps3bd, fpr1bd, fpr2bd, fpr3bd, fpt1bd, fpt2bd, fpt3bd, fps1bd, fps2bd, fps3bd);
                             AlertMain.alert(AlertType.INFORMATION, Infos.frameName, "Votre fichier a bien était créer !", "Dans : export/models/item");
                         } else {
                             AlertMain.alert(AlertType.ERROR, Infos.frameName, "Erreur !", "Vous devez remplir tous les champs !");
                         }
                   }
                });

                Group groupI = new Group();
                groupI.getChildren().addAll(titleItem, itemNameLabel, itemNameField, textureNameLabel, textureNameField, thirdNameLabel,
                        tpr1a, tpr1b, tpr2a, tpr2b, tpr3a, tpr3b, tpt1a, tpt1b, tpt2a, tpt2b, tpt3a, tpt3b, tps1a, tps1b, tps2a, tps2b, tps3a, tps3b,
                        firstNameLabel, fpr1a, fpr1b, fpr2a, fpr2b, fpr3a, fpr3b, fpt1a, fpt1b, fpt2a, fpt2b, fpt3a, fpt3b, fps1a, fps1b, fps2a, fps2b, fps3a, fps3b, createFile);

                Scene secondScene = new Scene(groupI, 600, 500);

                Stage itemStage = new Stage();
                itemStage.setTitle("Item JSON");
                itemStage.setScene(secondScene);
                itemStage.setResizable(false);
                itemStage.getIcons().add(icon);

                itemStage.setX(primaryStage.getX() + 200);
                itemStage.setY(primaryStage.getY() + 100);

                itemStage.show();
            }
        });

        group.getChildren().addAll(title, item, block, itemCustom, credits);
        primaryStage.setScene(new Scene(group));
    }

    public static void print(String args){
        System.out.println(args);
    }
}