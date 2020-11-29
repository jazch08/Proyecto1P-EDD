/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Jorge
 */
public class Pixel {
    String codColor;
    Color color= Color.WHITE;
    Rectangle rectangulo;

    public Pixel(String color) {
        this.codColor=color;
        rectangulo = new Rectangle();
        anadirColorRec(color);
    }
    
    private void anadirColorRec(String c){
        switch(c){
            case "0":
                color = Color.WHITE;
                break;
            case "1":
                color = Color.AQUA;
                break;
            case "2":
                color = Color.BLUEVIOLET;
                break;
            case "3":
                color = Color.GOLD;
                break;
            case "4":
                color = Color.ORANGE;
                break;
            
        }
        rectangulo.setFill(color);
    }

    public Rectangle getRectangulo() {
        return rectangulo;
    }
    
    
    
}
