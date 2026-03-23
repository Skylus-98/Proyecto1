package hlanz.programacion.pong.clases;

import java.awt.*;
import java.util.Random;

public class Raqueta extends ObjetoGrafico {
    //variables de instancia
    private int velocidad;

    //constructores
    public Raqueta(Color c, int x) {
        super(x, 540, 50, 50 + new Random().nextInt(150), c);
        this.velocidad = 3 + new Random().nextInt(12);
    }

    //métodos
    public void moverArriba() {
        super.incrementarY(-this.velocidad);
    }
    public void moverAbajo() {
        super.incrementarY(this.velocidad);
    }

    //métodos del padre abstracto
    @Override
    public void dibujar(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getX(), this.getY(), this.getAnchura(), this.getAltura());
    }
}
