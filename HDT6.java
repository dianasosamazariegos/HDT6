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
        
        //Menu de mapas a elegir
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
        
        //Da error si se ingresa un número diferente a 3 o si se ingresa algún otro caracter
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
        
        //Creacion de los mapas
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
        
        //Menú para elegir las opciones para manipular las cartas
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
        
        //Variables
        String inputNombre;
        String inputTipo;
            
        if (opcion == 1){
          //Agregar una carta a la coleccion
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
          //Mostrar tipo de una carta
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
          //Mostrar nombre, tipo y cantidad de cartas un su coleccion
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
          //Mostrar nombre, tipo y cantidad de cartas en orden de su coleccion
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
            // se van a imprimir Ordenadas por tipo Monstruo, luego Trampas y de ultimo hechizos 
            // Monstruos
            System.out.println("\n------------- MONSTRUOS (Total: " + monstruo.size() + ") -------------");
            for (int x=0; x<monstruo.size(); x++) {
                System.out.println("\t" + (x+1) + ". " + monstruo.get(x));
            }
            // Trampas
            System.out.println("\n------------- TRAMPAS (Total: " + trampa.size() + ") -------------");
            for (int y=0; y<trampa.size(); y++) {
                System.out.println("\t" + (y+1) + ". " + trampa.get(y));
            }
            // Hechizos
            System.out.println("\n------------- HECHIZOS (Total: " + hechizo.size() + ") -------------");
            for (int z=0; z<hechizo.size(); z++) {
                System.out.println("\t" + (z+1) + ". " + hechizo.get(z));
            }
            // Cantidades total
            System.out.println("\n>>> Cantidades Totales \n\t Monstruos: " + monstruo.size() + "\n\t Trampas: " + trampa.size() + "\n\t Hechizos: " + hechizo.size());
            System.out.println("\n\t  ENTER para continuar ");
            scan.nextLine();
            
        }else if (opcion == 5) { 
         // Mostrar nombre, tipo y cantidad de cartas en tCartas 
                
                System.out.println("\n CARTAS:");
                
                int cont = 0;
                int numMonstruos = 0;
                int numTrampas = 0; 
                int numHechizos = 0;
                
                // se imprimen todos los componentes en monstruos, trampas y hechizos
                for (Map.Entry<String, String> entry : tCartas.entrySet()) {
                    
                    // se lleva cuenta de cuantas hay de cada tipo
                    if (entry.getValue().equals("Monstruo")) {
                        numMonstruos++;
                    } else if (entry.getValue().equals("Trampa")) {
                        numTrampas++;
                    } else if (entry.getValue().equals("Hechizo")) {
                        numHechizos++;
                    } 
                    cont++;
                    
                    System.out.println(cont + ". Nombre: " + entry.getKey() + "\n\tTipo: " + entry.getValue());
                }
                
                // Cantidades totales
                System.out.println("\n>>> Cantidades Totales \n\t Monstruos: " + numMonstruos + "\n\t Trampas: " + numTrampas + "\n\t Hechizos: " + numHechizos);
                
                System.out.println("\n\t  ENTER para continuar ");
                scan.nextLine();
                
        } else if (opcion == 6) { 
        // Mostrar nombre, tipo y cantidad de cartas en ORDEN en tCartas
        
                System.out.println("\n");
                
                ArrayList<String> monstruos = new ArrayList<String>();
                ArrayList<String> trampas = new ArrayList<String>();
                ArrayList<String> hechizos = new ArrayList<String>();
                
                // se separan todos los componentes en monstruos, trampas y hechizos
                for (Map.Entry<String, String> entry : tCartas.entrySet()) {
                    
                    // se separan las cartas por tipo en arraylists
                    if (entry.getValue().equals("Monstruo")) {
                        monstruos.add(entry.getKey());
                        
                    } else if (entry.getValue().equals("Trampa")) {
                        
                        trampas.add(entry.getKey());
                        
                    } else if (entry.getValue().equals("Hechizo")) {
                        
                        hechizos.add(entry.getKey());
                    } else {
                        
                        System.out.println("<!> Error found in file (option 4)");
                    }
                }
                
                // se van a imprimir las cartas ordenadas por tipo Monstruo, luego Trampas y por ultimo hechizos
                // Monstruos
                System.out.println("\n------------- MONSTRUOS (Total: " + monstruos.size() + ") -------------");
                for (int x=0; x<monstruos.size(); x++) {
                    System.out.println("\t" + (x+1) + ". " + monstruos.get(x));
                }
                
                // Trampas
                System.out.println("\n------------- TRAMPAS (Total: " + trampas.size() + ") -------------");
                for (int y=0; y<trampas.size(); y++) {
                    System.out.println("\t" + (y+1) + ". " + trampas.get(y));
                }
                
                // Hechizos
                System.out.println("\n------------- HECHIZOS (Total: " + hechizos.size() + ") -------------");
                for (int z=0; z<hechizos.size(); z++) {
                    System.out.println("\t" + (z+1) + ". " + hechizos.get(z));
                }
                
                // Cantidades totales
                System.out.println("\n>>> Cantidades Totales \n\t Monstruos: " + monstruos.size() + "\n\t Trampas: " + trampas.size() + "\n\t Hechizos: " + hechizos.size());
                
                System.out.println("\n\t  ENTER para continuar ");
                scan.nextLine();
        }
    }
  }
}