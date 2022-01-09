package fr.lookzay.components;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Components {

    private Label label;
    private TextField textField;


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

    public void setLabel(Label label, String text, int x1, int y1){
        this.label = label;
        label.setText(text);
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(x1);
        label.setLayoutY(y1);
    }
    public void setLabel(Label label, String text, int x1, int y1, String css){

        this.label = label;
        label.setText(text);
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(x1);
        label.setLayoutY(y1);
        label.setStyle(css);
    }
    public void setLabel(Label label, String text, int x1, int y1, String nameOfFont, int sizeOfFont){
        this.label = label;
        label.setText(text);
        label.setFont(new Font(nameOfFont, sizeOfFont));
        label.setLayoutX(x1);
        label.setLayoutY(y1);
    }
    public void setLabel(Label label, String text, int x1, int y1, String css, String nameOfFont, int sizeOfFont){
        this.label = label;
        label.setText(text);
        label.setFont(new Font(nameOfFont, sizeOfFont));
        label.setLayoutX(x1);
        label.setLayoutY(y1);
        label.setStyle(css);
    }

}
