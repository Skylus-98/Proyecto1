package hlanz.programacion.pong.clases;

import java.awt.*;

public abstract class ObjetoGrafico {
    //variables de instancia
    private int x;
    private int y;
    private int altura;
    private int anchura;
    private Color color;

    //constructores
    public ObjetoGrafico(int x, int y, int anchura, int altura, Color color) {
        this.x = x;
        this.y = y;
        this.anchura = anchura;
        this.altura = altura;
        this.color = color;
    }

    //getters
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getAltura() {
        return this.altura;
    }
    public int getAnchura() {
        return this.anchura;
    }
    public Color getColor() {
        return this.color;
    }

    //métodos
    public boolean colisionaCon(ObjetoGrafico o) {
        return !(
                this.x > o.x + o.anchura ||
                o.x > this.x + this.anchura ||
                this.y > o.y + o.altura ||
                o.y > this.y + this.altura
                );
    }
    protected void incrementarX(int x) {
        if (this.x < 0 || this.x + this.anchura > 1920) {
            this.x += x;
        }
    }
    protected void incrementarY(int y) {
        if (this.y < 0 || this.y + this.altura > 1080) {
            this.y += y;
        }
    }

    //métodos abstractos
    public abstract void dibujar(Graphics g);
}
