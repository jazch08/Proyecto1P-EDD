package modelo;


import java.util.LinkedList;


/**
 *
 * @author Jorge
 */
public class Cluster {

    private String codColor;
    private int tamano;
    private LinkedList<Pixel> pixeles;

    public Cluster(LinkedList<Pixel> pixeles) {
        this.pixeles = pixeles;
        codColor = pixeles.get(0).getCodColor();
        tamano = this.pixeles.size();
    }

    public String getCodColor() {
        return codColor;
    }

    public int getTamano() {
        return tamano;
    }

    public LinkedList<Pixel> getPixeles() {
        return pixeles;
    }

    @Override
    public String toString() {
        return "{" + "Color=" + codColor + ", tamano=" + tamano + ", " + pixeles + '}';

    }
    


}
