/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.Pixel;

/**
 *
 * @author Jorge
 */
public class Lectura {
    public static int filas, columnas;
    public static ArrayList<ArrayList<Pixel>> leerArchivo(String archivo){
        ArrayList<ArrayList<Pixel>> cFilas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/Archivos/"+archivo+".txt"));
            filas = Integer.parseInt(lineas.remove(0));
            columnas = Integer.parseInt(lineas.remove(0));
            for(String linea:lineas){
                String[] lineaSep = linea.split(",");
                ArrayList<Pixel> elementosF = new ArrayList<>();
                for(String li : lineaSep){
                    elementosF.add(new Pixel(li));
                    System.out.print(li+" ");
                }
                System.out.println("");
                cFilas.add(elementosF);   
            }
        } catch (IOException ex) {
            System.out.println("Hola");
            System.out.println(ex);
        }
        return cFilas;
    }
}
