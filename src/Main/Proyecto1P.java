/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.Cluster;
import modelo.Pixel;
import modelo.Punto;
import operaciones.OperacionesCluster;

/**
 *
 * @author Matias Vasconez
 */
public class Proyecto1P extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/PantallaPrincipal.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //HashMap<Punto, Pixel> m = Lectura.leerArc("Matriz_Inicio");
      
        launch(args);
        
        OperacionesCluster.dividirPorCluster(Lectura.leerArc("Matriz_Inicio"));
        System.out.println("----------------------------------");
        for(Cluster c: OperacionesCluster.cluters){
            System.out.println(c);
        } 
        System.out.println("----------------------------------");
    }
    
}
