package org.example.clases;


import java.util.ArrayList;
import java.util.List;

public class Llave {

    private List<Equipo> equiposDeLaLlave;
    private String nombreDeLaLlave;


    public Llave() {

    }

    public Llave(List<Equipo> equiposDeLaLlave, String nombreDeLaLlave) {

        this.equiposDeLaLlave = equiposDeLaLlave;
        this.nombreDeLaLlave = nombreDeLaLlave;

    }

    public List<Equipo> getEquiposDeLaLlave() {
        return equiposDeLaLlave;
    }

    public void setEquiposDeLaLlave(List<Equipo> equiposDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
    }

    public String getNombreDeLaLlave() {
        return nombreDeLaLlave;
    }

    public void setNombreDeLaLlave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }


    // Creamos el metodo armarLlave para Armar las llaves del torneo
    public void armarLlave(List<Equipo> listaGeneral, int indiceInicial){

        List<Equipo> equiposLlave = new ArrayList<>();

        for ( int i = indiceInicial; i < indiceInicial+4; i++ ){

            equiposLlave.add(listaGeneral.get(i));


        }

        this.equiposDeLaLlave = equiposLlave;


    }

}
