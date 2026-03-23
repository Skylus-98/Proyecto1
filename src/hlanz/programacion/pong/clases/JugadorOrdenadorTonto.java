package hlanz.programacion.pong.clases;

import java.awt.*;

public class JugadorOrdenadorTonto extends JugadorOrdenador{
    public boolean subir;

    public JugadorOrdenadorTonto(Color c, int x, Bola b){
        super(c,x,b);
    }

    @Override
    public void realizarMovimiento() {
        if(this.getRaqueta().getAltura() <= 0){
            this.subir = false;
        }
        if(this.getRaqueta().getAltura() >= 1080){
            this.subir = true;
        }
        if(this.subir){
            this.getRaqueta().moverArriba();
        }else{
            this.getRaqueta().moverAbajo();
        }
    }
}
