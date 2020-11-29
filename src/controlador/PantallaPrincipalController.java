package controlador;

import Main.Lectura;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Pixel;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class PantallaPrincipalController implements Initializable {

    
    private GridPane Matriz;
    @FXML
    private VBox colores;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz(Lectura.leerArchivo("Matriz_Inicio"));
    }

    private void Crear(int fila, int columna) {
        Matriz = new GridPane();
        int numero = 0;
        for (int c = 0; c < fila; c++) {
            for (int f = 0; f < fila; f++) {
                Rectangle rectangle = new Rectangle();
                if (numero == 0) {
                    rectangle.setFill(Color.WHITE);
                }
                Matriz.setConstraints(rectangle,f,c);
                Matriz.getChildren().add(rectangle);

            }

        }
    }
    private void crearMatriz(ArrayList<ArrayList<Pixel>> cFilas) {
        Matriz = new GridPane();
        int f=0, c=0;
        for(ArrayList<Pixel> filas : cFilas){
            for(Pixel e : filas){
                Matriz.add(e.getRectangulo(),c,f);
                c++;
            }
            f++;
        }
        //colores.getChildren().add(Matriz);
        Label lb = new Label("Hola");
        colores.getChildren().add(lb);
    }
    
}
