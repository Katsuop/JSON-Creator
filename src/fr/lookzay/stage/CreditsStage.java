package fr.lookzay.stage;

import fr.lookzay.Main;
import fr.lookzay.components.Components;
import fr.lookzay.value.Infos;
import javafx.scene.Group;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreditsStage {

    public void generateStage(Stage primaryStage, Image icon){

        Label titleCredits = new Label(), textCredits = new Label(), githubText = new Label(), discordText = new Label();
        Hyperlink hyperlink = new Hyperlink();
        Components components = new Components();
        components.setLabel(titleCredits, "Credits", 160, 5, Infos.cssTitle, "Arial", 28);
        components.setLabel(textCredits, Infos.creditsText, 5, 55);
        components.setLabel(githubText, "Github :", 5, 83);
        components.setHyperLinkURL(hyperlink, Infos.githubUrl, 50, 80);
        components.setLabel(discordText, Infos.discordText, 5, 110);

        Group componentsGUI = new Group();
        componentsGUI.getChildren().addAll(titleCredits, textCredits, githubText, hyperlink, discordText);

        StageManager stageManager = new StageManager();
        stageManager.createNewStage(primaryStage, componentsGUI, "Credits", false, icon, 400, 140, 200, 100);

    }
}
