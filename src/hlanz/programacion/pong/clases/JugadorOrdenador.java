package hlanz.programacion.pong.clases;

import java.awt.*;

public abstract class JugadorOrdenador extends Jugador{
    private Bola bola;

    public JugadorOrdenador(Color c, int x, Bola b){
        super(c,x);
        this.bola = b;
    }

    public Bola getBola(){
        return this.bola;
    }
}
