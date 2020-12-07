package controlador;

import Main.Lectura;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cluster;
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

    @FXML
    private VBox colores;
    @FXML
    private ImageView play;
    @FXML
    private ImageView siguiente;   
    @FXML
    private Slider velocidad;
    @FXML
    private VBox PilaDinamica;
    @FXML
    private Button cargar;
    
    public static boolean continuar = true,cambioPlay = true,cargado = false;
    static PriorityQueue<Cluster> c = OperacionesCluster.cluters;
    public static Iterator iter;
    public static VBox pila;
    Thread th;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pila=PilaDinamica;
        cargar.setOnMouseClicked(e->cargar());
        
        play.setOnMouseClicked(e -> cargadoPlay());
        
        siguiente.setOnMouseClicked(e -> cargadoNext());
    }
    
    private void cargar(){
        continuar = false;
        cargado=true;
        play.setImage(new Image("Archivos/play.png"));
        cambioPlay = true;
        OperacionesCluster.cluters.clear();
        colores.getChildren().clear();
        PilaDinamica.getChildren().clear();
        HashMap<Punto, Pixel> m = Lectura.leerArc("Matriz_Inicio");
        crearMatrizColor(m);
        OperacionesCluster.dividirPorCluster(m);
        iter=obtenerIterator();
    }
    
    private void cargadoPlay(){
        if(!cargado){
            mostrarAlerta("Error de Carga","Error: Aun no ha cargado la matriz",AlertType.ERROR);
        }
        else{
            clickPlay();
        }
    }
    
    private void cargadoNext(){
        if(!cargado){
            mostrarAlerta("Error de Carga","Error: Aun no ha cargado la matriz",AlertType.ERROR);
        }
        else{
            clicNext();
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
            imagen = new Image("Archivos/pause.png");
            cambioPlay = false;
            continuar=true;
            th = new Thread(new operacionMatriz(velocidad));
            th.start();       
        }
        else{
            imagen = new Image("Archivos/play.png");
            cambioPlay = true;
            continuar= false;
        }
        play.setImage(imagen);
    }
   
    private void clicNext(){
       play.setImage(new Image("Archivos/play.png"));
       cambioPlay = true;
       continuar = false ;
       Next();
    }
    
    public static void Next(){
        if(iter!=null && iter.hasNext()){
            Pixel pix = (Pixel)iter.next();
            Label lb = pix.getLb();
            Platform.runLater(()->lb.setStyle("-fx-border-color: #000000; -fx-background-color: #ffa500;"));
            Platform.runLater(()->pila.getChildren().add(new Label(pix.toString())));       
        }
        else{
            iter=obtenerIterator();
        }
    }
    
    private static Iterator obtenerIterator(){
        Iterator iter0=null;
        if(!c.isEmpty()){
            LinkedList<Pixel> listaP = c.poll().getPixeles();
            iter0 = listaP.iterator();
        }
        return iter0;
    }
    
    public static void mostrarAlerta(String titulo, String mensaje, Alert.AlertType e){
        Alert alert = new Alert(e);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
