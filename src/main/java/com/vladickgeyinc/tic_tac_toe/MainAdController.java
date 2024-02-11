package com.vladickgeyinc.tic_tac_toe;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;
import java.net.URI;


public class MainAdController {

    @FXML
    private ImageView adImageVulkan1, adImageVulkan2, adImageVulkan3, adImageFavbet;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button startButton, playButton, player_1, player_2, exitButton;
    @FXML
    private Text nameGameGradient;
    @FXML
    private ImageView player1, player2;


    public void initialize() {

        rootPane.setStyle("-fx-background-color: #150b23");

        playButton.setVisible(false);
        exitButton.setVisible(false);
        player_1.setVisible(false);
        player_2.setVisible(false);
        player1.setVisible(false);
        player2.setVisible(false);

        applyRainbowNeonEffectToText(nameGameGradient);

        startButton.setOnAction(event -> startGame());
        exitButton.setOnAction(event -> backToMainMenu());
        playButton.setOnAction(event -> openMenu());

        openLink(adImageVulkan1, "https://vulkancasino.ua/uk-ua");
        openLink(adImageVulkan2, "https://vulkancasino.ua/uk-ua");
        openLink(adImageVulkan3, "https://vulkancasino.ua/uk-ua");
        openLink(adImageFavbet, "https://favbet.com/");
    }

    private void openLink(ImageView imageView, String link){
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void startGame() {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.7), startButton);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> startButton.setVisible(false));


        fadeOut.play();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.7), playButton);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setOnFinished(event -> playButton.setVisible(true));

        FadeTransition fadeInPlayer1 = new FadeTransition(Duration.seconds(0.7), player_1);
        fadeInPlayer1.setFromValue(0.0);
        fadeInPlayer1.setToValue(1.0);
        fadeInPlayer1.setOnFinished(event -> player_1.setVisible(true));

        FadeTransition fadeInPlayer2 = new FadeTransition(Duration.seconds(0.7), player_2);
        fadeInPlayer2.setFromValue(0.0);
        fadeInPlayer2.setToValue(1.0);
        fadeInPlayer2.setOnFinished(event -> player_2.setVisible(true));

        FadeTransition fadeInPlayer1Image = new FadeTransition(Duration.seconds(0.7), player1);
        fadeInPlayer1Image.setFromValue(0.0);
        fadeInPlayer1Image.setToValue(1.0);
        fadeInPlayer1Image.setOnFinished(event -> player1.setVisible(true));

        FadeTransition fadeInPlayer2Image = new FadeTransition(Duration.seconds(0.7), player2);
        fadeInPlayer2Image.setFromValue(0.0);
        fadeInPlayer2Image.setToValue(1.0);
        fadeInPlayer2Image.setOnFinished(event -> player2.setVisible(true));

        FadeTransition fadeOutExit = new FadeTransition(Duration.seconds(0.7), exitButton);
        fadeOutExit.setFromValue(0.0);
        fadeOutExit.setToValue(1.0);
        fadeOutExit.setOnFinished(event -> exitButton.setVisible(true));

        fadeIn.play();
        fadeOutExit.play();
        fadeInPlayer1.play();
        fadeInPlayer2.play();
        fadeInPlayer1Image.play();
        fadeInPlayer2Image.play();
    }

    private void backToMainMenu() {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.7), playButton);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> playButton.setVisible(false));

        FadeTransition fadeOutExit = new FadeTransition(Duration.seconds(0.7), exitButton);
        fadeOutExit.setFromValue(1.0);
        fadeOutExit.setToValue(0.0);
        fadeOutExit.setOnFinished(event -> exitButton.setVisible(false));

        FadeTransition fadeOutPlayer1 = new FadeTransition(Duration.seconds(0.7), player_1);
        fadeOutPlayer1.setFromValue(1.0);
        fadeOutPlayer1.setToValue(0.0);
        fadeOutPlayer1.setOnFinished(event -> player_1.setVisible(false));

        FadeTransition fadeOutPlayer2 = new FadeTransition(Duration.seconds(0.7), player_2);
        fadeOutPlayer2.setFromValue(1.0);
        fadeOutPlayer2.setToValue(0.0);
        fadeOutPlayer2.setOnFinished(event -> player_2.setVisible(false));

        FadeTransition fadeOutPlayer1Image = new FadeTransition(Duration.seconds(0.7), player1);
        fadeOutPlayer1Image.setFromValue(1.0);
        fadeOutPlayer1Image.setToValue(0.0);
        fadeOutPlayer1Image.setOnFinished(event -> player1.setVisible(false));

        FadeTransition fadeOutPlayer2Image = new FadeTransition(Duration.seconds(0.7), player2);
        fadeOutPlayer2Image.setFromValue(1.0);
        fadeOutPlayer2Image.setToValue(0.0);
        fadeOutPlayer2Image.setOnFinished(event -> player2.setVisible(false));

        fadeOut.play();
        fadeOutExit.play();
        fadeOutPlayer1.play();
        fadeOutPlayer2.play();
        fadeOutPlayer1Image.play();
        fadeOutPlayer2Image.play();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.7), startButton);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setOnFinished(event -> startButton.setVisible(true));
        fadeIn.play();
    }

    private void openMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gameMenu.fxml"));
            Scene gameMenuScene = new Scene(fxmlLoader.load(), 800, 600);
            gameMenuScene.getStylesheets().add(getClass().getResource("/style/gameMenu.css").toExternalForm());

            Stage currentStage = (Stage)playButton.getScene().getWindow();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), currentStage.getScene().getRoot());
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setOnFinished(event -> {
                currentStage.setScene(gameMenuScene);

                FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.4), gameMenuScene.getRoot());
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeTransition.play();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void applyRainbowNeonEffectToText(Text text){
        Glow glow = new Glow();
        glow.setLevel(1);

        BoxBlur blur = new BoxBlur();
        blur.setWidth(5);
        blur.setHeight(5);
        blur.setIterations(3);

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setRadius(50.0);
        innerShadow.setBlurType(BlurType.GAUSSIAN);

        Blend blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);
        blend.setTopInput(glow);
        blend.setBottomInput(blur);

        text.setEffect(blend);
        innerShadow.setInput(blur);
        blur.setInput(glow);

        text.setEffect(innerShadow);

        Color[] colors = new Color[]{
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET, Color.RED
        };

        Timeline timeline = new Timeline();

        for (int i = 0; i < colors.length - 1; i++)
        {
            final Color startColor = colors[i];
            final Color endColor = colors[i + 1];
            final int framesPerColor = 120;

            for(int j = 0; j < framesPerColor; j++)
            {
                double progress = j * 1.0 / framesPerColor;
                Color frameColor = startColor.interpolate(endColor, progress);

                KeyFrame keyFrame = new KeyFrame(Duration.seconds((i + progress) * 7.0 / colors.length), event -> {
                    innerShadow.setColor(frameColor);
                    text.setFill(frameColor);
                });
                timeline.getKeyFrames().add(keyFrame);
            }
        }
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}