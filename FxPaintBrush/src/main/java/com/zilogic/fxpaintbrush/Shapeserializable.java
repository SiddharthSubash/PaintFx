/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

/**
 *
 * @author zubha
 */

import java.io.Serializable;
import javafx.scene.paint.Color;

public class Shapeserializable implements Serializable {
    private static final long serialVersionUID = 10L;

    private String shapeType;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double radius;
    private String color;

    public Shapeserializable(String shapeType, double startX, double startY, double endX, double endY, double radius, Color color) {
        this.shapeType = shapeType;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.radius = radius;
        this.color = color.toString();
    }

    public String getShapeType() {
        return shapeType;
    }
    public double getStartX() {
        return startX;
    }
    public double getStartY() {
        return startY;
    }
    public double getEndX() {
        return endX;
    }
    public double getEndY() {
        return endY;
    }
    public double getRadius() {
        return radius;
    }
    public Color getColor() {
        return Color.valueOf(color);
    }
}
