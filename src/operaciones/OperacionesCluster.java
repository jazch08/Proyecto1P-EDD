/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Main.Lectura;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import modelo.Cluster;
import modelo.Pixel;
import modelo.Punto;

/**
 *
 * @author Lizbeth
 */
public class OperacionesCluster {

    public static final PriorityQueue<Cluster> cluters = new PriorityQueue<>(new OrdenamientoCluster()); //(Cluster c1, Cluster c2) -> c1.getTamano()-c2.getTamano()

    private static ArrayList<Pixel> pixelesUsados = new ArrayList<>();

    private static Pixel nulo = new Pixel(new Punto(-2, -2), "-2");

    public static void dividirPorCluster(HashMap<Punto, Pixel> matrizColores) {
        for (int f = 0; f <= Lectura.filas; f++) {
            for (int c = 0; c <= Lectura.columnas; c++) {
                Pixel pix = matrizColores.get(new Punto(f, c));
                if (!pixelesUsados.contains(pix) && !pix.equals(nulo)) {
                    Cluster cluster = new Cluster(crearCluster(pix, matrizColores));
                    cluters.add(cluster);
                }
            }
        }
    }

    private static LinkedList<Pixel> crearCluster(Pixel pixel, HashMap<Punto, Pixel> matrizColores) {
        ArrayDeque<Pixel> pila = new ArrayDeque<>();
        LinkedList<Pixel> camino = new LinkedList<>();
        pila.push(pixel);
        Pixel piTemp = pila.pop();
        camino.add(piTemp);
        pixelesUsados.add(piTemp);
        do {
            Punto punto = piTemp.getCoordenada();
            matrizColores.put(punto, nulo);
            if ((punto.getY() - 1) >= 0 && matrizColores.get(new Punto(punto.getX(), punto.getY() - 1)).getCodColor().equals(piTemp.getCodColor())) {
                Pixel p = matrizColores.get(new Punto(punto.getX(), punto.getY() - 1));
                pila.push(p);
                camino.add(p);
                pixelesUsados.add(p);
                piTemp = p;
                matrizColores.put(p.getCoordenada(), nulo);
                
            } else if ((punto.getY() + 1) <= Lectura.columnas && matrizColores.get(new Punto(punto.getX(), punto.getY() + 1)).getCodColor().equals(piTemp.getCodColor())) {
                Pixel p = matrizColores.get(new Punto(punto.getX(), punto.getY() + 1));
                pila.push(p);
                camino.add(p);
                pixelesUsados.add(p);
                piTemp = p;
                matrizColores.put(p.getCoordenada(), nulo);

            } else if ((punto.getX() - 1) >= 0 && matrizColores.get(new Punto(punto.getX() - 1, punto.getY())).getCodColor().equals(piTemp.getCodColor())) {
                Pixel p = matrizColores.get(new Punto(punto.getX() - 1, punto.getY()));
                pila.push(p);
                camino.add(p);
                pixelesUsados.add(p);
                piTemp = p;
                matrizColores.put(p.getCoordenada(), nulo);

            } else if ((punto.getX() + 1) <= Lectura.filas && matrizColores.get(new Punto(punto.getX() + 1, punto.getY())).getCodColor().equals(piTemp.getCodColor())) {
                Pixel p = matrizColores.get(new Punto(punto.getX() + 1, punto.getY()));
                pila.push(p);
                camino.add(p);
                pixelesUsados.add(p);
                piTemp = p;
                matrizColores.put(p.getCoordenada(), nulo);

            } else {
                if (!pila.isEmpty()) {
                    piTemp = pila.pop();
                }
            }
        } while (!pila.isEmpty());
        return camino;
    }
}
