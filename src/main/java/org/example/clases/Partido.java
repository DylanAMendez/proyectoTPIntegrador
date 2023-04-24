package org.example.clases;

import org.example.enumeraciones.Resultado;

import javax.swing.*;

public class Partido {

    private int golesEquipoLocal = 2;
    private int golesEquipoVisitante = 3;


    public Partido() {

    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {

        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;

    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }


    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){

        // Muestro un mensaje con el resultado del partido

        JOptionPane.showMessageDialog(null,
                equipoLocal.getNombre() + " " + this.golesEquipoLocal + " - " + this.golesEquipoVisitante + "  " + equipoVisitante.getNombre()
                , "Resultado", JOptionPane.INFORMATION_MESSAGE);


        // Le suma los goles a los equipos

        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);


        // Logica de el partido

        if (this.golesEquipoLocal > this.golesEquipoVisitante){

            equipoVisitante.setAutorizacion(false);

            equipoLocal.setResultadoEnElPartido(Resultado.GANADOR);

            equipoVisitante.setResultadoEnElPartido(Resultado.PERDEDOR);

          //  JOptionPane.showMessageDialog(null, "Gano " + equipoLocal.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            return equipoLocal;

        } else if (this.golesEquipoLocal == this.golesEquipoVisitante) {

            JOptionPane.showMessageDialog(null,

                    "Se jugara el desempate entre: " +

                            equipoLocal.getNombre() + " - " + equipoVisitante.getNombre()

                    , "Resultado", JOptionPane.INFORMATION_MESSAGE);


            equipoLocal.setResultadoEnElPartido(Resultado.EMPATE);
            equipoVisitante.setResultadoEnElPartido(Resultado.EMPATE);

            simularPartido(equipoLocal, equipoVisitante);


        } else {


            equipoLocal.setAutorizacion(false);

            equipoVisitante.setResultadoEnElPartido(Resultado.GANADOR);

            equipoLocal.setResultadoEnElPartido(Resultado.PERDEDOR);

            JOptionPane.showMessageDialog(null, "Gano " + equipoVisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            return equipoVisitante;


        }


        return null;

    }


}
