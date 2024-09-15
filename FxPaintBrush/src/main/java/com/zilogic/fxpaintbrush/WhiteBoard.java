/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author zubha
 */
public class WhiteBoard {

    Node currentNode;
    private Pane pane;
    PaintManager pm;

    public WhiteBoard(PaintManager pm) {
        this.pm = pm;
        this.pane = new Pane();
        pane.setStyle("-fx-background-color: white;");
        initListener();
    }

    public Pane getPane() {
        return pane;
    }

    void initListener() {
        pane.setOnMousePressed(e -> {
            MyShape cs = pm.getSelectedShape();
            MyColor clr = pm.getSelectedColor();
            currentNode = cs.createNode(e.getX(), e.getY());
            currentNode.setStyle(clr.getColorAsText());
            
            pane.getChildren().add(currentNode);

        });

        pane.setOnMouseDragged(e -> {
            updateCurrentNode(e.getX(), e.getY());

        });
        
        pane.setOnMouseReleased(e -> {

        });
    }

    void updateCurrentNode(double x2, double y2) {
        switch (pm.getSelectedShape()) {
            case LINE:
                Line l = (Line)currentNode;
                l.setEndX(x2);
                l.setEndY(y2);
                break;

            case CIRCLE:
                Circle c = (Circle)currentNode;
                double radius = Math.sqrt(Math.pow(x2 - c.getCenterX(), 2) + Math.pow(y2 - c.getCenterY(), 2));
                c.setRadius(radius);
                break;

            case RECTANGLE:
                Rectangle r = (Rectangle)currentNode;
                r.setWidth(Math.abs(x2 - r.getX()));
                r.setHeight(Math.abs(y2 - r.getY()));
                break;
            default:
                throw new IllegalArgumentException("Unknown shape: " + this);
        }
        
    }
    
    List<Node> getNodes(){
        return this.pane.getChildren();
    }        
    
    void drawNodes(List<Node> nodes) {
        pane.getChildren().clear();
        pane.getChildren().addAll(nodes);
    }
}
