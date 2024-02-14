package com.vladickgeyinc.tic_tac_toe;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Objects;


public class GameMenuController {

    private boolean Turn = false, isSleeping = false;
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
        if (!Objects.equals(Butt.getText(), "X") && !Objects.equals(Butt.getText(), "O") && !isSleeping) {
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

        } else if(Objects.equals(Butt0.getText(), "") &&
                  Objects.equals(Butt1.getText(), "") &&
                  Objects.equals(Butt2.getText(), "") &&
                  Objects.equals(Butt3.getText(), "") &&
                  Objects.equals(Butt4.getText(), "") &&
                  Objects.equals(Butt5.getText(), "") &&
                  Objects.equals(Butt6.getText(), "") &&
                  Objects.equals(Butt7.getText(), "") &&
                  Objects.equals(Butt8.getText(), "") && !isSleeping) {
            winText.setText("Draw");
            winText.setVisible(true);
            delay(5000, this::ResetGame);
        }
    }
    public void M_checkWin(String s0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        if (Objects.equals(s0, s1) && Objects.equals(s1, s2)) {
            WinHandle(s0);
        }
        if (Objects.equals(s3, s4) && Objects.equals(s4, s5)) {
            WinHandle(s3);
        }
        if (Objects.equals(s6, s7) && Objects.equals(s7, s8)) {
            WinHandle(s6);
        }
        if (Objects.equals(s0, s3) && Objects.equals(s6, s3)) {
            WinHandle(s0);
        }
        if (Objects.equals(s4, s1) && Objects.equals(s4, s7)) {
            WinHandle(s1);
        }
        if (Objects.equals(s2, s5) && Objects.equals(s5, s8)) {
            WinHandle(s2);
        }
        if (Objects.equals(s0, s4) && Objects.equals(s4, s8)) {
            WinHandle(s0);
        }
        if (Objects.equals(s2, s4) && Objects.equals(s4, s6)) {
            WinHandle(s2);
        }
    }
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException ignored) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
    public void ResetGame(){
        Butt0.setText("0");
        Butt1.setText("1");
        Butt2.setText("2");
        Butt3.setText("3");
        Butt4.setText("4");
        Butt5.setText("5");
        Butt6.setText("6");
        Butt7.setText("7");
        Butt8.setText("8");
        winText.setVisible(false);
        Turn = false;
        TurnShow.setText("P1's хід");
        isSleeping = false;
    }
    public void WinHandle(String s){
        winText.setVisible(true);
        winText.setText("WIN FOR " + s);
        isSleeping = true;
        delay(5000, this::ResetGame);
    }

}

