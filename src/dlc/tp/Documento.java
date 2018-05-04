package dlc.tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Representa un archivo
 */
public class Documento {

    // Tabla hash
    private String nombre;
    private HashMap<String, Integer> ht = new HashMap<>();

    public Documento(String nombre) { 
        this.nombre = nombre;
        ht = new HashMap<>();
    }

    public void limpiar() {
        ht.clear();
    }

    public void cargar() {

        //StringBuilder sb = new StringBuilder();
        
        try( Scanner sc = new Scanner(new FileReader(nombre))){
            while (sc.hasNext())
            {
                String palabra = sc.next();
                palabra = palabra.replaceAll("[-+.^:,?$&`|%@=¿¡'!_1234567890/*#():;><~]","");
                palabra = palabra.replaceAll("\\[", "").replaceAll("\\]","");
                palabra = palabra.replaceAll("\"", "");
                palabra = palabra.replaceAll("\\{", "");
                palabra = palabra.replaceAll("\\}", "");
                palabra = palabra.replaceAll("	", "");

                palabra = palabra.toUpperCase();

                if(ht.get(palabra)== null){
                    ht.put(palabra, 1);
                    //sb.append(palabra + "\n");
                }
                else{
                    int valorActual = ht.get(palabra);
                    int nuevoValor = valorActual + 1;
                    ht.put(palabra, nuevoValor);
                }           
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("No existe el archivo...");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Integer> getHt() {
        return ht;
    }

    public int buscar(String palabra) {
        Integer cantidad = ht.get(palabra);

        if (cantidad == null) return -1;
        return cantidad;
    }

}
