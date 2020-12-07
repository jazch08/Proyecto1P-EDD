/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Cluster;
import operaciones.OperacionesCluster;

/**
 *
 * @author Matias Vasconez
 */
public class Proyecto1P extends Application {
    public static boolean Seguir = true;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/PantallaPrincipal.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Seguir=false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        launch(args);
        
        OperacionesCluster.dividirPorCluster(Lectura.leerArc("Matriz_Inicio"));
        System.out.println("----------------------------------");
        for(Cluster c: OperacionesCluster.cluters){
            System.out.println(c);
        } 
        System.out.println("----------------------------------");
    }
    
}
