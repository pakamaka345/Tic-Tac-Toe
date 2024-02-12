package com.vladickgeyinc.tic_tac_toe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Objects;


public class GameMenuController {

    private boolean Turn = false;
    @FXML
    private Button Butt1, Butt2, Butt0, Butt3, Butt4, Butt5, Butt6, Butt7, Butt8;
    @FXML
    private Text winText, TurnShow;
    public void initialize() {
        Butt0.setOnAction(event -> set(Butt0));
        Butt1.setOnAction(event -> set(Butt1));
        Butt2.setOnAction(event -> set(Butt2));
        Butt3.setOnAction(event -> set(Butt3));
        Butt4.setOnAction(event -> set(Butt4));
        Butt5.setOnAction(event -> set(Butt5));
        Butt6.setOnAction(event -> set(Butt6));
        Butt7.setOnAction(event -> set(Butt7));
        Butt8.setOnAction(event -> set(Butt8));

    }

    public void set(Button Butt) {
        if (!Objects.equals(Butt.getText(), "X") && !Objects.equals(Butt.getText(), "O")) {
            if (!Turn) {
                Butt.setText("X");
                TurnShow.setText("P2's хід");
            }
            else {
                Butt.setText("O");
                TurnShow.setText("P1's хід");
            }
            Turn = !Turn;
            M_checkWin(Butt0.getText(),
                    Butt1.getText(),
                    Butt2.getText(),
                    Butt3.getText(),
                    Butt4.getText(),
                    Butt5.getText(),
                    Butt6.getText(),
                    Butt7.getText(),
                    Butt8.getText());
        }
    }
    public void M_checkWin(String s0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8){
        if(Objects.equals(s0, s1) && Objects.equals(s1, s2))
            winText.setVisible(true);
        if(Objects.equals(s3, s4) && Objects.equals(s4, s5))
            winText.setVisible(true);
        if(Objects.equals(s6, s7) && Objects.equals(s7, s8))
            winText.setVisible(true);
        if(Objects.equals(s0, s3) && Objects.equals(s6, s3))
            winText.setVisible(true);
        if(Objects.equals(s4, s1) && Objects.equals(s4, s7))
            winText.setVisible(true);
        if(Objects.equals(s2, s5) && Objects.equals(s5, s8))
            winText.setVisible(true);
        if(Objects.equals(s0, s4) && Objects.equals(s4, s8))
            winText.setVisible(true);
        if(Objects.equals(s2, s4) && Objects.equals(s4, s6))
            winText.setVisible(true);
    }
}

