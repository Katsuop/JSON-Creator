package fr.lookzay.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Components {

    private Label label;
    private TextField textField;
    private Button button;
    private Hyperlink hyperlink;

    public void setTextFieldWithLabel (Label label, TextField textField, String text, int x1, int y1, int x2, int y2, int minWidthTextField){

        this.label = label;
        label.setText(text);
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(x1);
        label.setLayoutY(y1);

        this.textField = textField;
        textField.setMinWidth(minWidthTextField);
        textField.setLayoutY(y2);
        textField.setLayoutX(x2);
    }
    public void setTextFieldWithLabel (Label label, TextField textField, String text, int x1, int y1, int x2, int y2, int minWidthTextField, String nameOfFont, int sizeOfFont){

        this.label = label;
        label.setText(text);
        label.setFont(new Font(nameOfFont, sizeOfFont));
        label.setLayoutX(x1);
        label.setLayoutY(y1);

        this.textField = textField;
        textField.setMinWidth(minWidthTextField);
        textField.setLayoutY(y2);
        textField.setLayoutX(x2);
    }

    public void setLabel(Label label, String text, int x, int y){
        this.label = label;
        label.setText(text);
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(x);
        label.setLayoutY(y);
    }
    public void setLabel(Label label, String text, int x, int y, String css){

        this.label = label;
        label.setText(text);
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setStyle(css);
    }
    public void setLabel(Label label, String text, int x, int y, String nameOfFont, int sizeOfFont){
        this.label = label;
        label.setText(text);
        label.setFont(new Font(nameOfFont, sizeOfFont));
        label.setLayoutX(x);
        label.setLayoutY(y);
    }
    public void setLabel(Label label, String text, int x, int y, String css, String nameOfFont, int sizeOfFont){
        this.label = label;
        label.setText(text);
        label.setFont(new Font(nameOfFont, sizeOfFont));
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setStyle(css);
    }

    public void setButton(Button button, String text, int x, int y, int minWidth, int minHeight){
        this.button = button;
        button.setText(text);
        button.setMinHeight(minHeight);
        button.setMinWidth(minWidth);
        button.setLayoutX(x);
        button.setLayoutY(y);
    }
    public void setButton(Button button, String text, int x, int y, int minWidth, int minHeight, int maxWidth, int maxHeight){
        this.button = button;
        button.setText(text);
        button.setMinHeight(minHeight);
        button.setMinWidth(minWidth);
        button.setMaxHeight(maxHeight);
        button.setMaxWidth(maxWidth);
        button.setLayoutX(x);
        button.setLayoutY(y);
    }

    public void setHyperLinkURL(Hyperlink hyperlink, String text, int x, int y){
        this.hyperlink = hyperlink;
        hyperlink.setText(text);
        hyperlink.setLayoutX(x);
        hyperlink.setLayoutY(y);
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(text));
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
