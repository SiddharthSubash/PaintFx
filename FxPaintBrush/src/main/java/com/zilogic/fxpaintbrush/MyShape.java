/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

/**
 *
 * @author zubha
 */

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public enum MyShape {
    LINE, CIRCLE, RECTANGLE;
    
    public Node createNode(double x, double y) {
        switch (this) {
            case LINE:
                Line l = new Line(x,y,x,y);
                return l;

            case CIRCLE:
                Circle c = new Circle(x,y,1);
                c.setFill(Color.TRANSPARENT);
                return c;

            case RECTANGLE:
                Rectangle r = new Rectangle(x,y,1,1);
                r.setFill(Color.TRANSPARENT);
                return r;
            default:
                throw new IllegalArgumentException("Unknown shape: " + this);
        }
    }
}