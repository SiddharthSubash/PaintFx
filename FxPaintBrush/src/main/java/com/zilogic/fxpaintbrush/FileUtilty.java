/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ja
 */
public class FileUtilty {

    public static void saveNodes(List<Shapeserializable> nodes, File file) throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(nodes);
    }

    public static List<Shapeserializable> getNodes(File file) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        List<Shapeserializable> nodes = (List<Shapeserializable>) inputStream.readObject();
        return nodes;
    }

    public static Shapeserializable nodeToSerializable(Node node) {
        Shapeserializable sn = null;
        if (node instanceof Line) {
            Line line = (Line) node;
            sn = new Shapeserializable("LINE", line.getStartX(), line.getStartY(),
                    line.getEndX(), line.getEndY(), 0, (Color) line.getStroke());
        } else if (node instanceof Circle) {
            Circle circle = (Circle) node;
            sn = new Shapeserializable("CIRCLE", circle.getCenterX(), circle.getCenterY(),
                    0, 0, circle.getRadius(), (Color) circle.getStroke());
        } else if (node instanceof Rectangle) {
            Rectangle square = (Rectangle) node;
            sn = new Shapeserializable("RECTANGLE", square.getX(), square.getY(),
                    square.getX() + square.getWidth(), square.getY() + square.getHeight(), 0,
                    (Color) square.getStroke());
        }
        return sn;
    }

    public static Node SerializableToNode(Shapeserializable sn) {
        switch (sn.getShapeType()) {
            case "LINE":
                Line line = new Line(sn.getStartX(), sn.getStartY(), sn.getEndX(), sn.getEndY());
                line.setStroke(sn.getColor());
                return line;
            case "CIRCLE":
                Circle circle = new Circle(sn.getStartX(), sn.getStartY(), sn.getRadius());
                circle.setStroke(sn.getColor());
                circle.setFill(Color.TRANSPARENT);
                return circle;
            case "RECTANGLE":
                Rectangle rect = new Rectangle(sn.getStartX(), sn.getStartY(),
                        sn.getEndX() - sn.getStartX(), sn.getEndY() - sn.getStartY());
                rect.setStroke(sn.getColor());
                rect.setFill(Color.TRANSPARENT);
                return rect;
        }
        return null;
    }
}

