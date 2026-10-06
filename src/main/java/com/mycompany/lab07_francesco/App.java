package com.mycompany.lab07_francesco;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        HBox buttonBox = new HBox();
        Button startB = new Button("Start");
        Button restB = new Button("Restart");
        Button exitB = new Button("Exit");
        
        Circle object = new Circle(160,120,15);
        Rectangle pathMarker = new Rectangle(160,120,340,200);
        pathMarker.setFill(Color.TRANSPARENT);
        object.setFill(Color.AQUA);
        pathMarker.setStrokeWidth(2.0);
        pathMarker.setStroke(Color.BLACK);
        pane.getChildren().addAll(pathMarker,object);
        
        
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(pathMarker);
        pt.setNode(object);
        pt.setCycleCount(Timeline.INDEFINITE);

        
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(startB, restB, exitB);
        root.setBottom(buttonBox);
        root.setCenter(pane);
        
        startB.setOnAction(e ->
        {
            pt.play();
        });
        
        restB.setOnAction(e ->
        {
            pt.playFromStart();
        });
        
        exitB.setOnAction(e ->
        {
            pt.pause();
        });



        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}