package controlador;

import Main.Lectura;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    @FXML
    private ImageView play;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        crearMatriz(Lectura.leerArchivo("Matriz_Inicio"));
        crearMatrizColores(Lectura.leerArchivo("Matriz_Inicio"));
//        Crear();
    }

    private void Crear() {
        ImageView img = new ImageView();
        img.onMouseClickedProperty();
        Matriz = new GridPane();
        int numero = 0;
        for (int c = 0; c < Lectura.columnas; c++) {
            for (int f = 0; f < Lectura.filas; f++) {
                Rectangle rectangle = new Rectangle();
                if (numero == 0) {
                    rectangle.setFill(Color.RED);
                }
                Matriz.setConstraints(rectangle,f,c);
                Matriz.getChildren().add(rectangle);
            }
        }
        colores.getChildren().add(Matriz);
    }
    private void crearMatriz(ArrayList<ArrayList<Pixel>> cFilas) {
        Matriz = new GridPane();
        int f=0, c=0;
        for(ArrayList<Pixel> filas : cFilas){
            for(Pixel e : filas){
                Matriz.setConstraints(e.getLb(),c,f);
                Matriz.getChildren().add(e.getLb());
                c++;
            }
            f++;
        }
        colores.getChildren().add(Matriz);
        //Label lb = new Label("Hola");
        //colores.getChildren().add(lb);
    }
    
    private void crearMatrizColores(ArrayList<ArrayList<Pixel>> cFilas) {
        colores.setAlignment(Pos.CENTER);
        int f=0, c=0;
        for(ArrayList<Pixel> filas : cFilas){
            HBox elementos = new HBox();
            elementos.setAlignment(Pos.CENTER);
            for(Pixel e : filas){
                elementos.getChildren().add(e.getLb());
                c++;
            }
            colores.getChildren().add(elementos);
            f++;
        }
        //colores.getChildren().add(Matriz);
        //Label lb = new Label("Hola");
        //colores.getChildren().add(lb);
    }
    
     @FXML
    private void setAction(MouseEvent event) {
        ImageView pausa = new ImageView("/src/Archivos/pause.png");
        play.setImage(pausa.getImage());
    }
    
}
