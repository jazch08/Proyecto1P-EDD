/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class Lectura {
    public static String[][] leerArchivo(String archivo){
         String[][] filas;
        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/Archivos/"+archivo+".txt"));
            int nFilas, nColumnas, contador=0;
            nFilas = Integer.parseInt(lineas.remove(0));
            nColumnas = Integer.parseInt(lineas.remove(0));
            filas = new String[nFilas][];
            for(String linea:lineas){
                    String[] lineaSep = linea.split(",");
                    filas[contador]=lineaSep;
                    contador++;
            }
        } catch (IOException ex) {
            filas = null;
            System.out.println(ex);
        }
        return filas;
    }
}
