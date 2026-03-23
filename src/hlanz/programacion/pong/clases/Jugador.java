package hlanz.programacion.pong.clases;

import java.awt.*;

public abstract class Jugador {
    private int puntos;
    private Raqueta raqueta;

    public Jugador(Color c, int x){
        this.puntos = 0;
        this.raqueta = new Raqueta(c,x);
    }
    public int getPuntos(){
        return this.puntos;
    }
    public void sumarPunto(){
        this.puntos ++;
    }
    public Raqueta getRaqueta(){
        return this.raqueta;
    }
    public abstract void realizarMovimiento();
}
