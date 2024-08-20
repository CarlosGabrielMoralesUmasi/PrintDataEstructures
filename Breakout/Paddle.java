import java.awt.*;

public class Paddle {
    private int x, y;
    private int width = 100, height = 10;
    private int moveSpeed = 20;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        if (x - moveSpeed > 0) { // Asegura que la paleta no se salga del borde izquierdo
            x -= moveSpeed;
        } else {
            x = 0; // Establece la posición a 0 si está en el borde
        }
    }

    public void moveRight() {
        if (x + width + moveSpeed < 800) { // Asegura que la paleta no se salga del borde derecho
            x += moveSpeed;
        } else {
            x = 800 - width; // Ajusta la posición al borde derecho
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public void reset() {
        x = 350; // Centra la paleta al reiniciar
        y = 550;
    }
}
