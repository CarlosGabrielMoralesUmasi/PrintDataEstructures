import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;
    private boolean isMachinePlaying;

    public GamePanel(boolean isMachinePlaying) {
        this.isMachinePlaying = isMachinePlaying;
        initGame();
    }

    private void initGame() {
        setFocusable(true);
        setBackground(Color.BLACK);
        ball = new Ball(400, 300);
        paddle = new Paddle(350, 550);
        bricks = new ArrayList<>();
        initBricks();
        timer = new Timer(10, this);
    }

    private void initBricks() {
        int brickWidth = 60;
        int brickHeight = 20;
        int rows = 5;
        int cols = 10;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                bricks.add(new Brick(50 + j * (brickWidth + 10), 50 + i * (brickHeight + 10), brickWidth, brickHeight));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        paddle.draw(g);
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

    public void startGame() {
        if (!timer.isRunning()) { // Asegura que el temporizador solo se inicia si no está ya corriendo
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        if (isMachinePlaying) {
            machineMove();
        }
        checkCollisions();
        repaint();
    }

    private void machineMove() {
        if (ball.getX() < paddle.getX() + paddle.getWidth() / 2) {
            paddle.moveLeft();
        } else if (ball.getX() > paddle.getX() + paddle.getWidth() / 2) {
            paddle.moveRight();
        }
    }

    public void movePaddleLeft() {
        paddle.moveLeft();
        repaint(); // Redibuja la pantalla para reflejar la nueva posición de la paleta
    }

    public void movePaddleRight() {
        paddle.moveRight();
        repaint(); // Redibuja la pantalla para reflejar la nueva posición de la paleta
    }

    private void checkCollisions() {
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseYDirection();
        }
        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = bricks.get(i);
            if (ball.getBounds().intersects(brick.getBounds())) {
                ball.reverseYDirection();
                bricks.remove(i);
                break;
            }
        }
        if (ball.getX() <= 0 || ball.getX() >= getWidth() - ball.getDiameter()) {
            ball.reverseXDirection();
        }
        if (ball.getY() <= 0) {
            ball.reverseYDirection();
        }
        if (ball.getY() >= getHeight()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over", "Breakout", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
    }

    private void resetGame() {
        ball.reset();
        paddle.reset();
        bricks.clear();
        initBricks();
        timer.start();
    }

    public void setMachinePlaying(boolean isMachinePlaying) {
        this.isMachinePlaying = isMachinePlaying;
    }
}
