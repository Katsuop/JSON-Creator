package fr.lookzay;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertMain {

    public static void alert(AlertType type, String frameTitle, String topText, String bottomText){
        Alert alertInfo = new Alert(type);
        alertInfo.setTitle(frameTitle);
        alertInfo.setHeaderText(topText);

        Image icon = new Image(AlertMain.class.getResourceAsStream("/fr/lookzay/images/icon.png"));
        Stage stage = (Stage) alertInfo.getDialogPane().getScene().getWindow();
        stage.getIcons().add(icon);

        alertInfo.setContentText(bottomText);

        alertInfo.showAndWait();
    }
}
