package hlanz.programacion.pong.clases;

import bpc.daw.consola.Teclado;

import java.awt.*;

public class JugadorHumano extends Jugador{
    private int teclaArriba;
    private int tecladoAbajo;
    private Teclado teclado;

    public Jugador(Teclado t, Color c, int x, int tAr, int tAb){
        super(c,x);
    }

    public int getTecladoAbajo() {
        return tecladoAbajo;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public int getTeclaArriba() {
        return teclaArriba;
    }
}
