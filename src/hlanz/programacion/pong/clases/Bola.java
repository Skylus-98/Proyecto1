package hlanz.programacion.pong.clases;

import java.awt.*;
import java.util.Random;

public class Bola extends ObjetoGrafico {
    //variables de instancia
    private int velocidadX;
    private int velocidadY;

    //constructores
    public Bola() {
        super(960 - 15, 540 - 15, 30, 30, Color.WHITE);
        this.velocidadX = -5;
        this.velocidadY = 5;
    }

    //métodos
    public void incrementarVelocidad() {
        this.velocidadX += 3;
    }
    public void mover() {
        this.incrementarX(this.velocidadX);
        this.incrementarY(this.velocidadY);
        if (this.getY() <= 0 | this.getY() + this.getAltura() >= 1080) {
            this.velocidadY *= -1;
        }
    }
    public void rebotarRaqueta() {
        this.incrementarVelocidad();
        this.velocidadX *= -1;
        this.velocidadY = -3 + new Random().nextInt(7);
    }

    //métodos del padre abstracto
    @Override
    public void dibujar(Graphics g) {
        g.fillOval(this.getX(), this.getY(), this.getAnchura(), this.getAltura());
    }
}
