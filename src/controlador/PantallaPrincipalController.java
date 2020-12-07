package controlador;

import Main.Lectura;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Pixel;
import modelo.Punto;
import operaciones.OperacionesCluster;
import operaciones.operacionMatriz;

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
    @FXML
    private ImageView siguiente;
    
    boolean cambioPlay = false;
    @FXML
    private Slider velocidad;
    
    Thread th;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ArrayList<ArrayList<Pixel>> matrizColores = Lectura.leerArchivo("Matriz_Inicio");
        HashMap<Punto, Pixel> m = Lectura.leerArc("Matriz_Inicio");
        crearMatrizColor(m);
        OperacionesCluster.dividirPorCluster(m);
        //crearMatrizColores(matrizColores);
        th = new Thread(new operacionMatriz());
        play.setOnMouseClicked(e -> clickPlay());
    }

    
    private void crearMatrizColores(ArrayList<ArrayList<Pixel>> cFilas) {
        colores.setAlignment(Pos.CENTER);
        int f=1;
        for(ArrayList<Pixel> filas : cFilas){
            HBox elementos = new HBox();
            elementos.setAlignment(Pos.CENTER);
            int c=0;
            for(Pixel e : filas){
                elementos.getChildren().add(e.getLb());
                c++;
            }
            colores.getChildren().add(elementos);
            f++;
        }
    }
    
    private void crearMatrizColor(HashMap<Punto, Pixel> matrizColor) {
        colores.setAlignment(Pos.CENTER);
        for(int f=0; f<=Lectura.filas ; f++){
            HBox elementos = new HBox();
            elementos.setAlignment(Pos.CENTER);
            for(int c=0; c<=Lectura.columnas ; c++){
                elementos.getChildren().add((matrizColor.get(new Punto(f,c))).getLb());
            }
            colores.getChildren().add(elementos);
        }
        
    }
    
    private void clickPlay(){
        Image imagen = null;
        if(cambioPlay){
            imagen = new Image("Archivos/play.png");
            cambioPlay = false;
            th.start();       
        }
        else{
            imagen = new Image("Archivos/pause.png");
            cambioPlay = true;
        }
        play.setImage(imagen);
    }
   
    
}
