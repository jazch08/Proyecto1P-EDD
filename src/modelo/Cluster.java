package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Cluster {

    String Color;
    int tamano;
    String[] Pixeles;
    public static ArrayList<ArrayList<Cluster>> listadoCluster;

    private ArrayList<ArrayList<Pixel>> lista = new ArrayList<>();

    public static void detectarClusters(ArrayList<ArrayList<Pixel>> lista) {
        listadoCluster = new ArrayList();
        for (ArrayList<Pixel> filas : lista) {
            for (Pixel px : filas) {
                Pixel pix = px;
                ArrayList<Pixel> cluster = new ArrayList();
                if(px.getCdX()==1 || px.getCdX()==8 || px.getCdY()==1 || px.getCdY()==7){
//                    px.getCdX()
                }
            }
        }
    }
    


}
