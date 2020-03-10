/*
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos
Autor: Diana Sosa -Fecha: 10/03/2020
 */
package hdt6;

/**
 *
 * @author diana
 */
import java.util.*;

public class Factory <K,V> {
    
    public Factory(){
    }
    
    public Map<K,V> getMap(int tipo){
    // seleccioin de la implementacion a usar
        if (tipo == 1){
            return new HashMap<K,V>();//regresa un HashMap
        }
        else if (tipo == 2){
            return new TreeMap<K,V>(); //regresa un TreeMap
        }
        else{
            return new LinkedHashMap<K,V>();//regresa un LinkedHashMap
        }
    }
}
