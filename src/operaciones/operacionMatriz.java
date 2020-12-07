/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Main.Proyecto1P;
import controlador.PantallaPrincipalController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Slider;


/**
 *
 * @author Jorge
 */
public class operacionMatriz implements Runnable{
    private Slider velocidad;

    public operacionMatriz(Slider velocidad) {
        this.velocidad = velocidad;
    }
    
    @Override
    public void run() {
        while(PantallaPrincipalController.continuar && Proyecto1P.Seguir){
            try {
                long factor = (long)velocidad.getValue();
                PantallaPrincipalController.Next();
                Thread.sleep(2000/factor);
            } catch (InterruptedException ex) {
                Logger.getLogger(operacionMatriz.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
    }
}
