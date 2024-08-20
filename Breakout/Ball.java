import java.awt.*;

public class Ball {
    private int x, y;
    private int xDir = -1, yDir = -2;
    private int diameter = 20;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += xDir;
        y += yDir;
    }

    public void reverseXDirection() {
        xDir = -xDir;
    }

    public void reverseYDirection() {
        yDir = -yDir;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void reset() {
        x = 400;
        y = 300;
        xDir = -1;
        yDir = -2;
    }
}
