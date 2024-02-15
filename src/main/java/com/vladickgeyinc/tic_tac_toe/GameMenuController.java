package com.vladickgeyinc.tic_tac_toe;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Objects;


public class GameMenuController {

    private boolean Turn = false, isSleeping = false;
    public int lastMove = -1;
    @FXML
    private Button Butt1, Butt2, Butt0, Butt3, Butt4, Butt5, Butt6, Butt7, Butt8, UndoButton;
    @FXML
    private Text winText, TurnShow;
    public void initialize() {
        Butt0.setOnAction(event -> set(Butt0, 0));
        Butt1.setOnAction(event -> set(Butt1, 1));
        Butt2.setOnAction(event -> set(Butt2, 2));
        Butt3.setOnAction(event -> set(Butt3, 3));
        Butt4.setOnAction(event -> set(Butt4, 4));
        Butt5.setOnAction(event -> set(Butt5, 5));
        Butt6.setOnAction(event -> set(Butt6, 6));
        Butt7.setOnAction(event -> set(Butt7, 7));
        Butt8.setOnAction(event -> set(Butt8, 8));
        UndoButton.setOnAction(event -> UndoMove());
    }

    public void set(Button Butt, int last) {
        if (!Objects.equals(Butt.getText(), "X") && !Objects.equals(Butt.getText(), "O") && !isSleeping) {
            if (!Turn) {
                animateAppearance(Butt, "X");
                TurnShow.setText("P2's хід");
                UndoButton.setVisible(true);
                lastMove = last;
            }
            else {
                animateAppearance(Butt, "O");
                TurnShow.setText("P1's хід");
                UndoButton.setVisible(true);
                lastMove = last;
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
    private void animateAppearance(Button button, String text) {
        // Налаштування анімації зміни прозорості
        FadeTransition fadeTransition = new FadeTransition(Duration.ZERO, button);
        fadeTransition.setToValue(0); // Встановлення прозорості на 0
        fadeTransition.setOnFinished(event -> {
            button.setText(text); // Встановлення тексту кнопки після анімації
            // Налаштування анімації масштабу
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
            scaleTransition.setFromX(0);
            scaleTransition.setFromY(0);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play(); // Запуск анімації масштабу
        });
        fadeTransition.play(); // Запуск анімації зміни прозорості
    }
    public void M_checkWin(String s0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        if (Objects.equals(s0, s1) && Objects.equals(s1, s2) && (Objects.equals(s0, "X") || Objects.equals(s0, "O")))
            WinHandle(s0);
        if (Objects.equals(s3, s4) && Objects.equals(s4, s5) && (Objects.equals(s3, "X") || Objects.equals(s3, "O")))
            WinHandle(s3);
        if (Objects.equals(s6, s7) && Objects.equals(s7, s8) && (Objects.equals(s6, "X") || Objects.equals(s6, "O")))
            WinHandle(s6);
        if (Objects.equals(s0, s3) && Objects.equals(s6, s3) && (Objects.equals(s0, "X") || Objects.equals(s0, "O")))
            WinHandle(s0);
        if (Objects.equals(s4, s1) && Objects.equals(s4, s7) && (Objects.equals(s1, "X") || Objects.equals(s1, "O")))
            WinHandle(s1);
        if (Objects.equals(s2, s5) && Objects.equals(s5, s8) && (Objects.equals(s2, "X") || Objects.equals(s2, "O")))
            WinHandle(s2);
        if (Objects.equals(s0, s4) && Objects.equals(s4, s8) && (Objects.equals(s0, "X") || Objects.equals(s0, "O")))
            WinHandle(s0);
        if (Objects.equals(s2, s4) && Objects.equals(s4, s6) && (Objects.equals(s2, "X") || Objects.equals(s2, "O")))
            WinHandle(s2);
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
        Butt0.setText("");
        Butt1.setText("");
        Butt2.setText("");
        Butt3.setText("");
        Butt4.setText("");
        Butt5.setText("");
        Butt6.setText("");
        Butt7.setText("");
        Butt8.setText("");
        winText.setVisible(false);
        Turn = false;
        TurnShow.setText("P1's хід");
        isSleeping = false;
        UndoButton.setVisible(false);
    }
    public void WinHandle(String s){
        winText.setVisible(true);
        winText.setText("WIN FOR " + s);
        isSleeping = true;
        delay(5000, this::ResetGame);
    }

    public void UndoMove(){
        Button[] buttons = {Butt0, Butt1, Butt2, Butt3, Butt4, Butt5, Butt6, Butt7, Butt8};

        if (lastMove >= 0 && lastMove < buttons.length) {
            animateAppearance(buttons[lastMove], "");
        }
        Turn = !Turn;
        if (!Turn) TurnShow.setText("P1's хід"); else TurnShow.setText("P2's хід");
        UndoButton.setVisible(false);
    }

}

