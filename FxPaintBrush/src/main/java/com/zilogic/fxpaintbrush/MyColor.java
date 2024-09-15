/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zilogic.fxpaintbrush;

/**
 *
 * @author zubha
 */
import javafx.scene.paint.Color;

public enum MyColor {
    RED(Color.RED), GREEN(Color.GREEN), BLUE(Color.BLUE), VIOLET(Color.VIOLET);

    private final Color color;

    MyColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public String getColorAsText(){
        return "-fx-stroke: " + this.name().toLowerCase() + ";";
    }
}