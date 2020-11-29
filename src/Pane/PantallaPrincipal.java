/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pane;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matias Vasconez
 */
public class PantallaPrincipal {

    private GridPane ventanaMatriz = new GridPane();
    private BorderPane ventanaPrincipal;

    public PantallaPrincipal() {
        ventanaPrincipal = new BorderPane();
    }

    public BorderPane getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    private void CrearMatriz(int fila, int columna) {
        ventanaMatriz = new GridPane();
        int numero = 0;
        for (int c = 0; c < fila; c++) {
            for (int f = 0; f < fila; f++) {
                Rectangle rectangle = new Rectangle();
                if (numero == 0) {
                    rectangle.setFill(Color.WHITE);
                }
                ventanaMatriz.setConstraints(rectangle,f,c);
                ventanaMatriz.getChildren().add(rectangle);

            }

        }
    }

}
