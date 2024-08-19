import java.util.Random;

public class MazeGenerator {
    private final int rows; // Número de filas del laberinto
    private final int cols; // Número de columnas del laberinto
    private final int[][] maze;
    private final Random random = new Random();

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new int[rows][cols];
        generateMaze(0, 0);
    }

    private void generateMaze(int r, int c) {
        // Direcciones posibles: arriba, derecha, abajo, izquierda
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        shuffle(directions); // Desordenar las direcciones para que la generación del laberinto sea más aleatoria

        maze[r][c] = 1; // Marcar la celda actual como parte del camino

        for (int[] dir : directions) {
            int newR = r + dir[0] * 2; // Avanzar dos espacios para crear una pared entre celdas
            int newC = c + dir[1] * 2;

            if (isValid(newR, newC)) {
                maze[newR - dir[0]][newC - dir[1]] = 1; // Marcar el camino entre las celdas
                maze[newR][newC] = 1; // Marcar la celda destino como parte del camino
                generateMaze(newR, newC); // Generar recursivamente desde la nueva posición
            }
        }
    }

    private boolean isValid(int r, int c) {
        // Verificar que la celda está dentro del laberinto y que es una celda no visitada (es un muro)
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }
        return maze[r][c] == 0;
    }

    private void shuffle(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int[] temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] == 1 ? " " : "#");
            }
            System.out.println();
        }
    }
}
