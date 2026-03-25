package hlanz.programacion.pong.programa;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;
import hlanz.programacion.pong.clases.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Programa {
    public static void main(String[] args) {
        //crear consola y capas
        Consola c = new Consola("Pong", 1920, 1080);
        CapaTexto texto = c.getCapaTexto();
        Teclado t = c.getTeclado();
        CapaCanvas canvas = c.getCapaCanvas();
        Graphics g = canvas.getGraphics();

        //crear jugadores
        Jugador j1 = null;
        Jugador j2 = null;

        //crear bola
        Bola b = new Bola();

        //menú de opciones
        boolean repetirMenu = true;
        while (repetirMenu) {
            texto.println("""
                    Elige una opción
                    1. Jugador contra ordenador
                    2. Jugador contra jugador
                    3. Ordenador contra ordenador""");
            int opcion = t.leerNumeroEntero();
            repetirMenu = false;
            switch (opcion) {
                case 1 -> {
                    j1 = new JugadorHumano(t, Color.RED, 50, KeyEvent.VK_W, KeyEvent.VK_S);
                    texto.cls();
                    texto.println("¿Quieres que el ordenador sea tonto o listo?");
                    String opcion2 = t.leerCadenaCaracteres();
                    texto.cls();
                    j2 = switch (opcion2) {
                        case "tonto" -> new JugadorOrdenadorTonto(Color.BLUE, 1820, b);
                        case "listo" -> new JugadorOrdenadorListo(Color.BLUE, 1820, b);
                        default -> null;
                    };
                    if (j2 == null) {
                        j1 = null;
                        texto.println("Opción incoorecta");
                    }
                }
                case 2 -> {
                    j1 = new JugadorHumano(t, Color.RED, 50, KeyEvent.VK_W, KeyEvent.VK_S);
                    j2 = new JugadorHumano(t, Color.RED, 1820, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
                }
                case 3 -> {
                    Random r = new Random();
                    j1 = r.nextInt(2) == 0? new JugadorOrdenadorTonto(Color.RED, 50, b) : new JugadorOrdenadorListo(Color.RED, 50, b);
                    j2 = r.nextInt(2) == 0? new JugadorOrdenadorTonto(Color.BLUE, 1820, b) : new JugadorOrdenadorListo(Color.BLUE, 1820, b);
                }
                default -> {
                    texto.cls();
                    texto.println("Opción incorrecta, escríbalo de nuevo");
                    repetirMenu = true;
                }
            }
        }

        //sacar raquetas
        Raqueta r1 = j1.getRaqueta();
        Raqueta r2 = j2.getRaqueta();

        //bucle principal
        texto.cls();
        boolean repetir = true;
        while (repetir) {
            //limpiar pantalla
            canvas.cls();

            //información
            g.drawString("Jugador 1: " + j1.getPuntos(), 20, 50);
            g.drawString("Jugador 2: " + j2.getPuntos(), 20, 65);

            //dibujar elementos
            r1.dibujar(g);
            r2.dibujar(g);
            b.dibujar(g);

            //movimiento
            j1.realizarMovimiento();
            j2.realizarMovimiento();
            b.mover();

            //comprobar que salga la bola
            if (b.getX() <= 0) {
                j2.sumarPunto();
                b = new Bola();
            }
            if (b.getX() + b.getAnchura() >= 1920) {
                j1.sumarPunto();
                b = new Bola();
            }

            //salir
            if (t.teclaPulsada(KeyEvent.VK_ESCAPE)) {
                repetir = false;
            }

            //esperar siguiente frame
            c.esperarSiguienteFrame();
        }
    }
}
