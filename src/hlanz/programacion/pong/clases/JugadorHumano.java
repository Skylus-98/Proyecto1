package hlanz.programacion.pong.clases;

import bpc.daw.consola.Teclado;

import java.awt.*;

public class JugadorHumano extends Jugador{
    private int teclaArriba;
    private int teclaAbajo;
    private Teclado teclado;

    public JugadorHumano(Teclado t, Color c, int x, int tAr, int tAb){
        super(c,x);
        this.teclado = t;
        this.teclaArriba = tAr;
        this.teclaAbajo = tAb;
    }

    public int getTecladoAbajo() {
        return teclaAbajo;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public int getTeclaArriba() {
        return teclaArriba;
    }

    @Override
    public void realizarMovimiento() {
        if(this.teclado.teclaPulsada(this.teclaArriba)){
            this.getRaqueta().moverArriba();
        }else if(this.teclado.teclaPulsada(this.teclaAbajo)){
            this.getRaqueta().moverAbajo();
        }

    }
}
