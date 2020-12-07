/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.util.Comparator;
import java.util.Iterator;
import modelo.Cluster;
import modelo.Pixel;

/**
 *
 * @author Jorge
 */
public class OrdenamientoCluster implements Comparator<Cluster>{

    @Override
    public int compare(Cluster o1, Cluster o2) {
        int operacion = o2.getTamano()-o1.getTamano();
        
        if(operacion > 0){
            return 1;
        }
        else if(operacion < 0){
            return -1;
        }
        else{
            int minimo1,minimo2,incremento=0,maximo;
            maximo = o1.getPixeles().size()-o2.getPixeles().size()>=0? o1.getPixeles().size():o2.getPixeles().size();
            Iterator iter1 = o1.getPixeles().iterator();
            Iterator iter2 = o2.getPixeles().iterator();
            minimo1 = ((Pixel)iter1.next()).getCoordenada().getX();
            minimo2 = ((Pixel)iter2.next()).getCoordenada().getX();
            while(incremento<=maximo){
                if(iter1.hasNext()){
                    minimo1 = ((Pixel)iter1.next()).getCoordenada().getX();
                }
                if(iter2.hasNext()){
                    minimo2 = ((Pixel)iter2.next()).getCoordenada().getX();
                }
                incremento++;
            }
            if(minimo2-minimo1>0){
                return 1;
            }
            else if(minimo2-minimo1<0){
                return -1;
            }
            else{
                return 0;
            }
            
        }
        
    }
    
}
