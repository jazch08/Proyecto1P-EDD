/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Jorge
 */
public class Pixel {
    String cdX,cdY;
    String codColor;
    Color color= Color.WHITE;
    Rectangle rectangulo;
    Label lb;

    public Pixel(String color) {
        this.codColor=color;
        rectangulo = new Rectangle();
        lb = new Label("");
        lb.setMinSize(30, 30);
        anadirColorRec(color);
        anadirColorLb(color);
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
    
    private void anadirColorLb(String c){
        //lb.setStyle("-fx-border-color: #000000");
        String estilo = "-fx-border-color: #000000; -fx-background-color: ";
        switch(c){
            case "0":
                estilo+="#FFFFFF;";
                break;
            case "1":
                estilo+="#FFFF00;";
                break;
            case "2":
                estilo+="#FF0000;";
                break;
            case "3":
                estilo+="#00FF00;";
                break;
            case "4":
                estilo+="#0000FF";
                break;
            
        }
        lb.setStyle(estilo);
        
    }

    public Label getLb() {
        return lb;
    }

    public Rectangle getRectangulo() {
        return rectangulo;
    }

    @Override
    public String toString() {
        return "("+ cdX + "," + cdY + ')';
    }
    
    
}
