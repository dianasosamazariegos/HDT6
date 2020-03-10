/*
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos
Autor: Diana Sosa y Martin España -Fecha: 10/03/2020
 */
package hdt6;

/**
 *
 * @author diana
 */
import java.util.*;
import java.io.*;
import java.lang.*;

public class HDT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Factory<String,String> mapFactory = new Factory<String, String>();
        
        String FILENAME = "cards_desc.txt";
        
        BufferedReader br = null;
        FileReader fr = null;
        String output = "";
        
        //empezo el programa
        
        Scanner scan = new Scanner(System.in);
        int tipoMap = 0;
        
        //Menu de 
        System.out.println("   *** Menu de Mapas *** ");
        System.out.println(" 1. HashMap  ");
        System.out.println(" 2. TreeMap  ");
        System.out.println(" 3. LinkedHashMap  ");
        System.out.println(" -- Ingrese el número del mapa que desea utilizar: ");
        
        //programación defensiva
        try{
            tipoMap = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e){
            scan.nextLine();
            System.out.println(" ## No ingreso un número! ##");
        }
        
        while (tipoMap < 1 || tipoMap >3){
            System.out.println(" ## No ingreso una opción valida! ## ");
            System.out.println(" -- Ingrese el número del mapa que desea utilizar: ");
            
            try{
                tipoMap = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){ 
                scan.nextLine();
                System.out.println(" ## No ingreso un número! ##");
            }
        }
        
        //creacion de los mapas
        Map<String,String> tCartas = mapFactory.getMap(tipoMap);
        Map<String,String> coleccion = mapFactory.getMap(tipoMap);
        
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while ((output = br.readLine()) != null) {
		
                String[] outputArray = output.split("\\|");
		
                tCartas.put(outputArray[0], outputArray[1]);
            } 
            
        } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (br != null)
                        br.close();
                    
                    if (fr != null)
			fr.close();

		} catch (IOException ex) {
                    
                    ex.printStackTrace();
	
                    }
	}
        
        String menu = "\n\tMenú de Opciones: \n 1. Agregar una carta a la coleccion \n 2. Mostrar tipo de una carta \n 3. Mostrar nombre, tipo y cantidad de cartas un su coleccion \n 4. Mostrar nombre, tipo y cantidad de cartas en orden de su coleccion \n 5. Mostrar nombre y tipo de todas las cartas \n 6. Mostrar nombre y tipo de todas las cartas en orden \n 7. Salir";
        
        int opcion = 0;
        while (opcion != 7){
            System.out.println(menu);
            System.out.println(" -- Ingrese la opción que desea elegir: ");
            try {
                opcion = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                scan.nextLine();
                System.out.println(" ## No ingreso un número! ##");
            }
        
            while (opcion < 1 || opcion >7){
                System.out.println(" ## No ingreso una opción valida! ## ");
                System.out.println(" -- Ingrese el número del mapa que desea utilizar: ");
            
                try{
                    opcion = scan.nextInt();
                    scan.nextLine();
                } catch (InputMismatchException e){ 
                    scan.nextLine();
                    System.out.println(" ## No ingreso un número! ##");
            }
        }
        
        String inputNombre;
        String inputTipo;
            
        if (opcion == 1){
            System.out.println(" -- Ingresar el nombre de la carta: ");
            inputNombre = scan.nextLine();
            
            if (tCartas.containsKey(inputNombre)){
                inputTipo = tCartas.get(inputNombre);
                coleccion.put(inputNombre, inputTipo);
                System.out.println(" $$ CARTA AGREGADA $$ ");
                
            } else {
                System.out.println(" No se encontró la carta... ");
            }
            
            System.out.print(" ENTER para continuar ");
            scan.nextLine();
            
        } else if (opcion == 2) {
            System.out.println(" -- Ingresar el nombre de la carta: ");
            inputNombre = scan.nextLine();
            
            if (tCartas.containsKey(inputNombre)){
               
                inputTipo = tCartas.get(inputNombre);
                
                System.out.println("Tipo de carta: "+inputTipo);
                
            } else {
                System.out.println(" No se encontró la carta... ");
            }
            
            System.out.print(" ENTER para continuar ");
            scan.nextLine();   
            
        } else if (opcion == 3){
            System.out.println(" *** TODAS LAS CARTAS *** ");
            
            int cont = 0;
            int numMonstruo = 0; 
            int numTrampa = 0; 
            int numHechizo = 0;
            
            //for para contabilizar los tipos de cartas que existen
            for (Map.Entry<String, String> entry: coleccion.entrySet()){
                if (entry.getValue().equals("Monstruo")){
                    numMonstruo++;
                } else if (entry.getValue().equals("Trampa")){
                    numTrampa++;
                } else if (entry.getValue().equals("Hechizo")){
                    numHechizo++;
                }
                
                cont++;
                System.out.println(cont+ " Nombre: "+entry.getKey()+ " Tipo: "+entry.getValue());
            }
            
            //imprimir num de monstrous, trampas o hechizos
            System.out.println("");
            
        } else if (opcion == 4){
            ArrayList<String> monstruo = new ArrayList<String>();
            ArrayList<String> trampa = new ArrayList<String>();
            ArrayList<String> hechizo = new ArrayList<String>();
            
            for (Map.Entry<String, String> entry: coleccion.entrySet()){
                if (entry.getValue().equals("Monstruo")){
                    monstruo.add(entry.getKey());
                } else if (entry.getValue().equals("Trampa")){
                    trampa.add(entry.getKey());
                } else if (entry.getValue().equals("Hechizo")){
                    hechizo.add(entry.getKey());
                }
            
            }
    }
    

