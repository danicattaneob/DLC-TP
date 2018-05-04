/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlc.tp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Dani
 */
public class DLCTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            PrintStream out = new PrintStream(new FileOutputStream("log.txt"));
            System.setOut(out);
        }catch(Exception e){
            System.out.println("Error en el grabado del log");
        }
        
        Indexador indexador = new Indexador();
        File folder = new File("C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\libros");
        int i = 0;
        for (final File fileEntry : folder.listFiles()) {
            i++;
            indexador.indexar(
                    "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\libros\\"+fileEntry.getName());
            
            System.out.println("------------------------------------------");
            System.out.println("listo el archiv: "+ fileEntry.getName() + " nro: " + i);
            System.out.println("------------------------------------------");
        }


        Reader<ArrayList<EntryPosteo>> reader = new Reader<>(
                "C:\\Users\\Dani\\Documents\\NetBeansProjects\\DLC-TP\\archivos\\"+"AND.dat");
        ArrayList<EntryPosteo> listaPosteo = reader.read();
        System.out.println(listaPosteo);
        System.out.println("Listo wachin, hicimos " + i + " libros!!");

    }    
}
