package hlanz.programacion.pong.programa;

import bpc.daw.consola.Consola;
import hlanz.programacion.pong.clases.Jugador;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        //crear consola
        Consola c = new Consola("Pong", 1920, 1080);

        //crear jugadores
        Jugador j1 = null;
        Jugador j2 = null;

        //menú de opciones
        boolean repetirMenu = true;
        while (repetirMenu) {
            System.out.println("""
                    Elige una opción
                    1. Jugador contra ordenador
                    2. Jugador contra jugador
                    3. Ordenador contra ordenador""");
            int opcion = new Scanner(System.in).nextInt();
            repetirMenu = false;
            switch (opcion) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                default -> {
                    System.out.println("Opción incorrecta, escríbalo de nuevo");
                    repetirMenu = true;
                }
            }
        }
    }
}
