/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.mycompany.p_grupo06.App;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * Clase la cual va a manejar los datos del archivo
 */
public class DataManager{
    public static final String SEPARADOR = ",";
    //anadido 11082022
    public static final String SEPARATOR = " ";
    /////////////////
    public static List<String> attributes = new ArrayList<String>();
    Map<String, Set<String>> possibleValues = new HashMap<String, Set<String>>();
    List<List<String>> recordMatrix = new ArrayList<List<String>>();
    
    /*
    Agregado 04082022
    Probando metiendolos en un diccionario. 
    La clave es el animal y como Value estan las caracateristicas que se pone como 1 o 0
    */
    public static Map<String, List<String>> individualsAnimal = new HashMap<String, List<String>>();
    /////////////////////////////////
    /*
    Agregado 11082022
    de igual manera coo la anterior imlementacion, lo metemos en un diccionario pero usando como separador " "
    La clave es el animal y como Value estan las caracateristicas que se pone como si o no
    Corregir haciendolo privado
    */
    public static Map<String, List<String>> animalsResponses = new HashMap<String, List<String>>();
    
    
    // Parametro 
    public DataManager(String path){
        Scanner sc;
        try {
            sc = new Scanner(new File(path));
            loadAttributes(sc.nextLine());
            loadAnimalsResponses(sc);
            //loadAnimalCharacteristics(sc);
            //loadData(sc);
            
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
    }
    
    // Cargar la primera linea del archivo que contiene los nombres de los aributos
    private void loadAttributes(String line) {
        String[] atts = line.split(SEPARADOR);
        String animal = atts[0];


        for (String s : atts) {
            attributes.add(s);
            possibleValues.put(s, new HashSet<String>());
        }
    }
    

	private void loadData(Scanner sc) {
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] instanceValues = line.split(SEPARADOR);

			List<String> record = new ArrayList<String>();
			for (int i = 0; i < instanceValues.length; i++) {
				record.add(instanceValues[i]);

				String attribute = attributes.get(i);
				Set<String> pValues = possibleValues.get(attribute);
				if (!pValues.contains(instanceValues[i])) {
					pValues.add(instanceValues[i]);
				}
			}

			recordMatrix.add(record);
		}
	}
        
        //Agregado 11082022
        private void loadAnimalsResponses(Scanner sc){
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] instanceValues = line.split(SEPARATOR);
                String animal = instanceValues[0];
                List<String> characteristics = new ArrayList<String>();
                
		for (int i = 1; i < instanceValues.length; i++) {
                    characteristics.add(instanceValues[i]);
                }
                
                animalsResponses.put(animal, characteristics);
            }
            

        }
}
