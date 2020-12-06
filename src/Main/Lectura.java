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
import java.util.HashMap;
import java.util.List;
import modelo.Pixel;
import modelo.Punto;

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
                    elementosF.add(new Pixel(new Punto(filas,columnas),li));
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
    
    public static HashMap<Punto, Pixel> leerArc(String archivo){
        HashMap<Punto, Pixel> m = new HashMap<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/Archivos/"+archivo+".txt"));
            filas = Integer.parseInt(lineas.remove(0))-1;
            columnas = Integer.parseInt(lineas.remove(0))-1;
            int f=0,c=0;
            for(String linea:lineas){
                c=0;
                String[] lineaSep = linea.split(",");
                for(String li : lineaSep){
                    Punto p = new Punto(f,c);
                    m.put(p,new Pixel(p,li));
                    c++;
                }
                f++; 
            }
        } catch (IOException ex) {
            System.out.println("Hola");
            System.out.println(ex);
        }
        return m;
    }
}
