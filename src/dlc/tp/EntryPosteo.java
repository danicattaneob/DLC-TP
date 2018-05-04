/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlc.tp;

import java.io.Serializable;

/**
 *
 * @author Dani
 */
public class EntryPosteo implements Serializable{

    @Override
    public String toString() {
        return "EntryPosteo{" + "nombreLibro=" + nombreLibro + ", tf=" + tf + '}';
    }
    private String nombreLibro;
    private int tf;

    public EntryPosteo(String nombreLibro, int tf) {
        this.nombreLibro = nombreLibro;
        this.tf = tf;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getTf() {
        return tf;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }
    
    
}
