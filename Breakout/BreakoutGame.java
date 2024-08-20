import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BreakoutGame extends JFrame implements KeyListener {
    private GamePanel gamePanel;
    private boolean isMachinePlaying;

    public BreakoutGame(boolean isMachinePlaying) {
        this.isMachinePlaying = isMachinePlaying;
        gamePanel = new GamePanel(isMachinePlaying);
        add(gamePanel);
        addKeyListener(this);
        setTitle("Breakout Game");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isMachinePlaying) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                gamePanel.movePaddleLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                gamePanel.movePaddleRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            gamePanel.startGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        // Opción para seleccionar modo de juego
        String[] options = {"Jugador", "Máquina"};
        int choice = JOptionPane.showOptionDialog(null, "¿Quién jugará?", "Selecciona el Modo de Juego",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    
        boolean isMachinePlaying = (choice == 1); // Si elige "Máquina", isMachinePlaying será true
    
        SwingUtilities.invokeLater(() -> {
            BreakoutGame breakoutGame = new BreakoutGame(isMachinePlaying);
            breakoutGame.gamePanel.startGame(); // Asegura que el juego comience inmediatamente
        });
    }
    
}
