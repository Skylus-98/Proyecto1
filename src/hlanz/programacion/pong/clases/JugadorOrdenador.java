package hlanz.programacion.pong.clases;

import java.awt.*;

public abstract class JugadorOrdenador extends Jugador{
    private Bola bola;

    public jugadorOrdenador(Color c, int x, Bola b){
        super(c,x);
    }
    public Bola getBola(){
        return this.bola;
    }
}
