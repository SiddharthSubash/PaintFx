/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

/**
 *
 * @author zubha
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PaintManager {
    
    private MyShape selectedShape;
    private MyColor selectedColor;
    WhiteBoard wb;

    public PaintManager() {
        selectedColor = MyColor.RED;
        selectedShape = MyShape.LINE;
        wb = new WhiteBoard(this);
    }

    public VBox getShapeToolBar() {
        VBox shapeToolbar = new VBox();
        for (MyShape shapeType : MyShape.values()) {
            Button shapeButton = new Button(shapeType.name());
            shapeButton.setOnAction(e -> selectedShape = shapeType);
            shapeToolbar.getChildren().add(shapeButton);
        }
        shapeToolbar.setSpacing(10);
        return shapeToolbar;
    }

    public HBox getColorPalette() {
        HBox colorToolbar = new HBox();
        for (MyColor paintColor : MyColor.values()) {
            Button colorButton = new Button();
            colorButton.setStyle("-fx-background-color: " + paintColor.name().toLowerCase() + ";");
            colorButton.setOnAction(e -> selectedColor = paintColor);
            colorToolbar.getChildren().add(colorButton);
        }
        colorToolbar.setSpacing(10);
        return colorToolbar;
    }

    
    public WhiteBoard getWhiteBoard() {
        return this.wb;
    }

    MyShape getSelectedShape() {
        return selectedShape;
    }

    MyColor getSelectedColor() {
        return selectedColor;
    }

    void save(Stage primaryStage) {
        List<Node> nodes = wb.getNodes();
        List<Shapeserializable> snodes = new ArrayList<>();
        for(Node node : nodes) {
            Shapeserializable ss = FileUtilty.nodeToSerializable(node);
            snodes.add(ss);
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        
        File file = fileChooser.showSaveDialog(primaryStage);
        try {
            FileUtilty.saveNodes(snodes, file);
        } catch (Exception ex) {
            Logger.getLogger(PaintManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void load(Stage primaryStage) throws Exception {
        List<Node> nodes = new ArrayList<>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        File file = fileChooser.showOpenDialog(primaryStage);

        List<Shapeserializable> snodes = FileUtilty.getNodes(file);
        for(Shapeserializable sn: snodes) {
            Node n= FileUtilty.SerializableToNode(sn);
            nodes.add(n);
        }
        this.wb.drawNodes(nodes);
        
    }
}