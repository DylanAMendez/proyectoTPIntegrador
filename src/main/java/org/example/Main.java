package org.example;

import org.example.clases.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenidos");

                menu();

    }
    public static void mostrarOpciones(){

        JOptionPane.showMessageDialog(null,"Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir","Opciones",JOptionPane.INFORMATION_MESSAGE);

    }
    public static void menu() {

        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\nSelecciona una de las siguientes opciones:");

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.

        boolean salir = true;
        ArrayList<Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llave llaveDerecha = null;
        Llave llaveIzquierda = null;
        Ronda ronda = null;
        String opcion="";

        do {

            mostrarOpciones();

            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.

            opcion = JOptionPane.showInputDialog(null,"Ingrese la opcion: ",
                    "Ingreso opcion",JOptionPane.INFORMATION_MESSAGE);

            switch (opcion) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso invalido");
            }

        } while (salir);
    }



    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {

        // verificamos que la lista este vacia para crear una nueva

        if ( listaDeEquipos == null ){

            JOptionPane.showMessageDialog(null,"Creando Lista de Equipos...", "Lista de equipos", JOptionPane.INFORMATION_MESSAGE);

            return new ArrayList();

        } else {

            // si ya existiese una lista, retornamos esa lista para no volver a crearla

            JOptionPane.showMessageDialog(null, "Ya existe una lista creada. \n" +
                    "Proceda a cargar los equipos", "Lista Existente", JOptionPane.WARNING_MESSAGE);

            return listaDeEquipos;

        }


    }

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {

        String cargarEquipos = "";

        // verificamos si la lista tiene almacenado los equipos
        // para preguntar al usuario si se desea limpiar la lista para crear otra nueva

        if ( ! listaDeEquipos.isEmpty() ){

            cargarEquipos = JOptionPane.showInputDialog(null, "Ya hay equipos cargados en la lista " +
                                "\n ¿Desea limpiar la lista de equipos existentes?", "Lista de Equipos", JOptionPane.WARNING_MESSAGE);

            // caso de indicar que "SI", limpiamos la lista creada y volvemos al menu

            if ( cargarEquipos.equalsIgnoreCase("SI") ){

                // .clear() remueve TODOS los elementos de la lista que le indicamos

                 listaDeEquipos.clear(); // la lista quedara vacia

            }

        }

        // verificamos si la lista esta vacia
        // para cargar equipos manualmente o automaticamente

        if ( listaDeEquipos.isEmpty() ){

            cargarEquipos = "";

            do {

                cargarEquipos = JOptionPane.showInputDialog(null, "Bienvenido a la carga de equipos " +
                        "\n ¿Desea cargar los equipos manualmente? SI | NO","Carga de equipos", JOptionPane.INFORMATION_MESSAGE);

                if (cargarEquipos == null || cargarEquipos.equals("")) {

                    JOptionPane.showMessageDialog(null, "Ingrese un valor permitido", "Error", JOptionPane.ERROR_MESSAGE);

                }


            } while ( cargarEquipos == null || cargarEquipos.equals(""));

            // si el usuario desea agregar los equipos manualmente

            if (cargarEquipos.equalsIgnoreCase("si")) {

                // utilizamos el metodo cargarEquipoManualmente() para cargar los equipos manualmente

                cargarEquipoManualmente(listaDeEquipos);

                // equipos creados automaticamente

            } else {

                listaDeEquipos.add(new Equipo("Belgica") );
                listaDeEquipos.add(new Equipo("Francia"));
                listaDeEquipos.add(new Equipo("Portugal"));
                listaDeEquipos.add(new Equipo("Alemania"));
                listaDeEquipos.add(new Equipo("Brasil"));
                listaDeEquipos.add(new Equipo("Italia"));
                listaDeEquipos.add(new Equipo("Argelia"));
                listaDeEquipos.add(new Equipo("Argentina"));

            }


        }


    }

    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {

        // creamos tipo Jugador

        Jugador jugador = new Jugador();

        // verificamos que la lista de equipos no este vacia

        if ( listaDeEquipos == null || listaDeEquipos.isEmpty() ){

            JOptionPane.showMessageDialog(null, "La lista de equipos esta vacia", "ERROR", JOptionPane.ERROR_MESSAGE);

            // si esta vacia la lista de equipos, retornamos null para que se pueda crear dicha lista

            return null;

        }

        // Seleccionamos un equipo llamando al metodo elegirEquipo() y su valor sera listaDeEquipos que se creo en el metodo

        jugador.elegirEquipo(listaDeEquipos);

        return jugador;

        }



    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {

        // creamos tipo de dato Llave LlaveDerecha que empiece de [0] a [3]
        // para luego poder usar el metodo armarLlave() con dicha variable creada

        Llave llaveDerecha = new Llave(null, "Llave Derecha");

        llaveDerecha.armarLlave(listaDeEquipos, 0);

        // retornamos dicha variable creada y asignada

        return llaveDerecha;

    }

    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {

        // creamos tipo de dato Llave LlaveDerecha que empiece de [4] a [7]
        // para luego poder usar el metodo armarLlave() con dicha variable creada

        Llave llaveIzquierda = new Llave(null, "Llave Izquierda");

        llaveIzquierda.armarLlave(listaDeEquipos, 4);

        // retornamos dicha variable creada y asignada

        return llaveIzquierda;

    }

    public static Ronda crearRondas() {

        // Crea una Ronda

        return new Ronda();


    }

    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {

        // utiliza las llaves de la izquierda y la derecha para armar los cuartos de final,
        // luego llama al método "sumarPuntos" del jugador y repite el proceso para las semifinales y la final.

        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();

        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();

        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();


    }

    public static void resultadoDelTorneo(Jugador jugador) {

        // Mostramos un mensaje con los puntos ganados

        JOptionPane.showMessageDialog( null, "Has conseguido : " + jugador.getPuntaje() + " por elegir a " + jugador.getEquipoSeleccionado().getNombre(),"Puntos", JOptionPane.INFORMATION_MESSAGE );


    }

    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){


        String nombreEquipo = null;

        // Utilizamos un for para crear los equipos manualmente -> [8 equipos]

        for ( int i = 0; i < 8; i++ ){

            do {

            nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo: " + (i+1));

            // verificamos que el nombre del equipo no sea null o valor vacio

            if ( nombreEquipo == null || nombreEquipo.equals("") ){

                JOptionPane.showMessageDialog( null, "ERROR! Ingrese un valor valido", "Error", JOptionPane.ERROR_MESSAGE );

            }

        } while ( nombreEquipo == null || nombreEquipo.equals("") );

            // Agregamos los equipos creados manualmente al tipo de dato Equipo

        listaDeEquipos.add( new Equipo(nombreEquipo) );

        }


    }






}