package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Ronda {

    private int nroDeRonda;
    private int cantidadDeEquiposEnRonda;
    private int cantidadDeEquiposEnLlave;


    public Ronda() {

    }

    public Ronda(int nroDeRonda, int cantidadDeEquiposEnRonda, int cantidadDeEquiposEnLlave) {

        this.nroDeRonda = nroDeRonda;
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;

    }

    public int getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }


    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){

        // numero de ronda
        this.nroDeRonda = 1;

        // numeros de equipos por llave
        this.cantidadDeEquiposEnLlave = 4;

        // creamos el objeto partido para usar el metodo simularPartido()
        Partido partido = new Partido();

        // Mostramos por pantalla el mensaje de que se inicia los cuartos de final
        JOptionPane.showMessageDialog(null, "Se jugaran los cuartos de final", "Cuartos de Final", JOptionPane.INFORMATION_MESSAGE);


        // Simulacion de los partidos
        /* Creamos el for para que jueguen en la misma llave 2 partidos en total
        para que:
        equipo[0] versus equipo[1]
        y
        equipo[2] versus equipo[3]
        */
        for ( int i = 0; i < cantidadDeEquiposEnLlave; i+= 2 ) {

        partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i), llaveIzquierda.getEquiposDeLaLlave().get(i+1));

        partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i), llaveDerecha.getEquiposDeLaLlave().get(i+1));

        }

        // Remuevo a los equipos que perdieron

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        // Setear la cantidad actual de equipos por llave

        this.cantidadDeEquiposEnLlave = 2;


    }

    public void removerEquipos(List<Equipo> equipos){

        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;

        for ( int i = 0; i < contadorEquiposPorLlave; i++ ){

            Equipo auxiliar = equipos.get(i);

            if ( !auxiliar.isAutorizacion() ){

                equipos.remove(auxiliar);

                contadorEquiposPorLlave--;


            }


        }


    }

    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha){

        // numero de ronda
        this.nroDeRonda = 2;



        Partido partido = new Partido();

        // Mensaje de semifinales
        JOptionPane.showMessageDialog(null, "Se jugaran las semifinales", "Semifinal", JOptionPane.INFORMATION_MESSAGE);

        // Simulamos los partidos

            partido.simularPartido( llaveIzquierda.getEquiposDeLaLlave().get(0), llaveIzquierda.getEquiposDeLaLlave().get(1) );

            partido.simularPartido( llaveDerecha.getEquiposDeLaLlave().get(0), llaveDerecha.getEquiposDeLaLlave().get(1) );



        // Remuevo los equipos que perdieron

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        // Cantidad actual de equipos por llave

        this.cantidadDeEquiposEnLlave = 1;

    }

    public void finalDelTorneo(Llave llaveIzquierda, Llave llaveDerecha) {

        this.nroDeRonda = 3;


        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null, "Se jugara la final", "Final", JOptionPane.INFORMATION_MESSAGE);

        // Simulamos el partido final

        Equipo equipo = partido.simularPartido(
                llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(0) );

        // Muestro un mensaje demostrando quien gano

        JOptionPane.showMessageDialog(null, "El ganador del torneo es: " + equipo.getNombre(), "Ganador del torneo", JOptionPane.INFORMATION_MESSAGE);

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());


    }



}
