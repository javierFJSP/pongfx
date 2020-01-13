package com.mycompany.pongfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    int ballCenterX = 500;
    int ballCurrentSpeedX = 3;
    int ballDirectionX = 1;
    int ballCenterY = 0;
    int ballCurrentSpeedY = 3;
    int ballDirectionY = 1;
    
    @Override        
    public void start (Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, 640, 480);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    
        //
        Circle circleBall = new Circle();
        circleBall.setCenterX(10);
        circleBall.setCenterY(30);
        circleBall.setRadius(7);
        circleBall.setFill(Color.WHITE);

        root.getchildren().add(circleBall);

        Timeline timeline = new Timeline(
            // 0.017 = 60 fps
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    System.out.println(ballCenterX);
                    circleBall.setCenterX(ballCenterX);
                    ballCenterX+=ballCurrentSpeedX * ballDirectionX;
                    ballCenterY+=ballCurrentSpeedY * ballDirectionY;
                    if(ballCenterX >= 640) {
                        ballDirectionX = -3;
                    } else if(ballCenterX <= 0){
                        ballDirectionX = 3;
                    }
                    if(ballCenterY >= 480) {
                        ballDirectionY = -3;
                    } else if(ballCenterY <= 0){
                        ballDirectionY = 3;
                    }
                }
            })
        );
        timeline.setCyrcleCount(timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args){
        Launch();
    }


}
