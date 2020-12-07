/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import modelo.Cluster;
import modelo.Pixel;

/**
 *
 * @author Jorge
 */
public class operacionMatriz implements Runnable{
    Slider velocidad;

    public operacionMatriz(Slider velocidad) {
        this.velocidad = velocidad;
    }
    
    @Override
    public void run() {
       PriorityQueue<Cluster> c = OperacionesCluster.cluters;
       while(!c.isEmpty()){
           
           LinkedList<Pixel> listaP = c.poll().getPixeles();
           Iterator iter = listaP.iterator();
           while(iter.hasNext()){
               Pixel pix = (Pixel)iter.next();
               try {
                   long factor = (long)velocidad.getValue();
                   
                   Label lb = pix.getLb();
                   Platform.runLater(()->lb.setStyle("-fx-border-color: #000000; -fx-background-color: #ffa500;"));
                   
                   Thread.sleep(2000/factor);
               } catch (InterruptedException|NullPointerException ex) {
                   Logger.getLogger(operacionMatriz.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }
    }
    
}
