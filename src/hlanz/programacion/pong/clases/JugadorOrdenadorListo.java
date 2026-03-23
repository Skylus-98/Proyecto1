package hlanz.programacion.pong.clases;

import java.awt.*;

public class JugadorOrdenadorListo extends JugadorOrdenador{
    public JugadorOrdenadorListo(Color c, int x, Bola b){
        super(c,x,b);
    }

    @Override
    public void realizarMovimiento() {
        int bolaP = this.getBola().getAltura();
        int raquetaP = this.getRaqueta().getAltura();
        if(bolaP > raquetaP){
            this.getRaqueta().moverAbajo();
        }
        if(bolaP < raquetaP){
            this.getRaqueta().moverArriba();
        }
    }
}
