import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private char[][] board;
    private JButton[][] buttons;
    private boolean playerTurn = true; // True: Player's turn, False: AI's turn

    public TicTacToe() {
        board = new char[3][3];
        buttons = new JButton[3][3];
        setLayout(new GridLayout(3, 3));
        initializeBoard();
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0'; // Empty cell
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (playerTurn) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j] == buttonClicked && board[i][j] == '\0') {
                        buttons[i][j].setText("X");
                        board[i][j] = 'X';
                        playerTurn = false;
                        if (!checkWin()) {
                            machineMove();
                        }
                        return;
                    }
                }
            }
        }
    }

    private void machineMove() {
        int[] bestMove = minimax(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        board[bestMove[1]][bestMove[2]] = 'O';
        buttons[bestMove[1]][bestMove[2]].setText("O");
        playerTurn = true;
        checkWin();
    }

    private int[] minimax(char[][] board, int depth, int alpha, int beta, boolean isMaximizing) {
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score;
        int[] bestMove = {-1, -1, -1};

        if (checkWinner(board, 'O')) return new int[]{10 - depth, -1, -1}; // Machine wins
        if (checkWinner(board, 'X')) return new int[]{depth - 10, -1, -1}; // Player wins
        if (isBoardFull(board)) return new int[]{0, -1, -1}; // Draw

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    board[i][j] = isMaximizing ? 'O' : 'X';
                    score = minimax(board, depth + 1, alpha, beta, !isMaximizing)[0];
                    board[i][j] = '\0';

                    if (isMaximizing) {
                        if (score > bestScore) {
                            bestScore = score;
                            bestMove = new int[]{score, i, j};
                        }
                        alpha = Math.max(alpha, score);
                    } else {
                        if (score < bestScore) {
                            bestScore = score;
                            bestMove = new int[]{score, i, j};
                        }
                        beta = Math.min(beta, score);
                    }

                    // Alpha-Beta Pruning
                    if (beta <= alpha) {
                        return bestMove;
                    }
                }
            }
        }
        return bestMove;
    }

    private boolean checkWin() {
        if (checkWinner(board, 'X')) {
            JOptionPane.showMessageDialog(this, "Player Wins!");
            resetBoard();
            return true;
        } else if (checkWinner(board, 'O')) {
            JOptionPane.showMessageDialog(this, "Machine Wins!");
            resetBoard();
            return true;
        } else if (isBoardFull(board)) {
            JOptionPane.showMessageDialog(this, "It's a Draw!");
            resetBoard();
            return true;
        }
        return false;
    }

    private boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0';
                buttons[i][j].setText("");
            }
        }
        playerTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
