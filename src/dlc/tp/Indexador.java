/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlc.tp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dani
 */
public class Indexador {

    public Indexador() {
        
    }
    
    public void indexar(String nombre){
        Documento doc = new Documento(nombre);
        doc.cargar();
        HashMap<String, Integer> ht = new HashMap<>();
        ht = doc.getHt();
        
        for (Map.Entry<String, Integer> entry : ht.entrySet()) {
            File f = new File(
                "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\archivos\\"+entry.getKey().toString()+".dat");
            if(f.exists()) {
                Reader<ArrayList<EntryPosteo>> reader = new Reader<>(
                "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\archivos\\"+entry.getKey().toString()+".dat");
                ArrayList<EntryPosteo> listaPosteo = reader.read();
                EntryPosteo entryPost = new EntryPosteo(nombre, entry.getValue());
                
                insert(listaPosteo,entryPost);
                //System.out.println("Actualizo");
                Writer<ArrayList<EntryPosteo>> writer = new Writer<>(
                "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\archivos\\"+entry.getKey().toString()+".dat");
                writer.write(listaPosteo);
            }else{
                ArrayList<EntryPosteo> listaPosteo = new ArrayList<>();
                EntryPosteo entryPost = new EntryPosteo(nombre, entry.getValue());
                listaPosteo.add(entryPost);
                Writer<ArrayList<EntryPosteo>> writer = new Writer<>(
                "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\archivos\\"+entry.getKey().toString()+".dat");
                //System.out.println(listaPosteo);
                writer.write(listaPosteo);
            }
        }
    }
    
    public void insert(ArrayList<EntryPosteo> lista, EntryPosteo x){
        for (int i = 0; i < lista.size(); i++) {
            if (x.getTf() >= lista.get(i).getTf()) {
                lista.add(i, x);
                return;
            }   
        }
        lista.add(x);
    }
     
}
