package com.zilogic.fxpaintbrush;



import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class App extends Application {

    private PaintManager paintManager;
    private Pane drawingArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        paintManager = new PaintManager();

        VBox shapeToolbar = paintManager.getShapeToolBar();
        HBox colorPalette = paintManager.getColorPalette();
        WhiteBoard whiteBoard = paintManager.getWhiteBoard();
        
        VBox fileBox = builtFileBox(primaryStage);
        drawingArea = whiteBoard.getPane();

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(shapeToolbar);
        borderPane.setBottom(colorPalette);
        borderPane.setCenter(drawingArea);
        borderPane.setRight(fileBox);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing App");
        primaryStage.show();
    }



    private VBox builtFileBox(Stage primaryStage) {
        VBox fb = new VBox(10);
        Button s = new Button("Save");
        s.setOnAction((event) -> {
            this.paintManager.save(primaryStage);
        });
        fb.getChildren().add(s);
        
        Button l = new Button("Load");
        l.setOnAction((event) -> {
            try {
                this.paintManager.load(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fb.getChildren().add(l);
            
        return fb;
                
    }
}