/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Objects;
import javafx.scene.control.Label;
/**
 *
 * @author Jorge
 */
public class Pixel {

    private Punto coordenada;
    String codColor;
    private Label lb;

    public Pixel(Punto punto, String color) {
        this.coordenada = punto;
        this.codColor = color;
        lb = new Label("");
        lb.setMinSize(30, 30);
        anadirColorLb(color);
    }
    
    private void anadirColorLb(String c){
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

    public String getCodColor() {
        return codColor;
    }

    public Punto getCoordenada() {
        return coordenada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.coordenada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pixel other = (Pixel) obj;
        if (!Objects.equals(this.coordenada, other.coordenada)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return coordenada.toString();
    }
    
    
}
