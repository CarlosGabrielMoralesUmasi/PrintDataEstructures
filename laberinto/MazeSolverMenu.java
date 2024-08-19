import java.util.*;

public class MazeSolverMenu {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Derecha, Abajo, Izquierda, Arriba
    private static final Scanner scanner = new Scanner(System.in);
    private static final int ROWS = 30;
    private static final int COLS = 30;

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(ROWS, COLS);
        int[][] maze = mazeGenerator.getMaze();

        // Detectar las posiciones de todos los espacios vacíos
        Map<String, List<int[]>> graph = detectEmptySpaces(maze);

        // Mostrar el grafo creado a partir del laberinto
        System.out.println("Grafo de posiciones vacías en el laberinto:");
        for (String key : graph.keySet()) {
            System.out.println("Nodo (" + key + ") conectado con: " + formatNeighbors(graph.get(key)));
        }

        System.out.println("\nSelecciona el algoritmo para calcular y mostrar todas las rutas posibles:");
        System.out.println("1. Depth-First Search (DFS)");
        System.out.println("2. Breadth-First Search (BFS)");
        System.out.println("3. A* Search");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                calculateAndPrintRoutesDFS(graph);
                break;
            case 2:
                calculateAndPrintRoutesBFS(graph);
                break;
            case 3:
                calculateAndPrintRoutesAStar(graph);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static Map<String, List<int[]>> detectEmptySpaces(int[][] maze) {
        Map<String, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (maze[i][j] == 1) {  // Si es un espacio vacío
                    String key = i + "," + j;
                    List<int[]> neighbors = new ArrayList<>();
                    for (int[] direction : DIRECTIONS) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (isValidPosition(newX, newY, maze)) {
                            neighbors.add(new int[]{newX, newY});
                        }
                    }
                    graph.put(key, neighbors);
                }
            }
        }
        return graph;
    }

    private static boolean isValidPosition(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < ROWS && y < COLS && maze[x][y] == 1;
    }

    private static void calculateAndPrintRoutesDFS(Map<String, List<int[]>> graph) {
        System.out.println("Calculando y mostrando todas las rutas posibles usando DFS...");
        for (String startNode : graph.keySet()) {
            Set<String> visited = new HashSet<>();
            List<String> path = new ArrayList<>();
            dfs(startNode, visited, graph, path);
        }
    }

    private static void dfs(String node, Set<String> visited, Map<String, List<int[]>> graph, List<String> path) {
        visited.add(node);
        path.add(node);

        // Imprimir la ruta actual
        System.out.println("Ruta DFS: " + path);

        for (int[] neighbor : graph.get(node)) {
            String neighborKey = neighbor[0] + "," + neighbor[1];
            if (!visited.contains(neighborKey)) {
                dfs(neighborKey, visited, graph, path);
            }
        }
        path.remove(path.size() - 1);  // Retira el nodo actual para retroceder
    }

    private static void calculateAndPrintRoutesBFS(Map<String, List<int[]>> graph) {
        System.out.println("Calculando y mostrando todas las rutas posibles usando BFS...");
        for (String startNode : graph.keySet()) {
            bfs(startNode, graph);
        }
    }

    private static void bfs(String startNode, Map<String, List<int[]>> graph) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String node = path.get(path.size() - 1);

            // Imprimir la ruta actual
            System.out.println("Ruta BFS: " + path);

            for (int[] neighbor : graph.get(node)) {
                String neighborKey = neighbor[0] + "," + neighbor[1];
                if (!visited.contains(neighborKey)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighborKey);
                    queue.add(newPath);
                    visited.add(neighborKey);
                }
            }
        }
    }

    private static void calculateAndPrintRoutesAStar(Map<String, List<int[]>> graph) {
        System.out.println("Calculando y mostrando todas las rutas posibles usando A*...");
        for (String startNode : graph.keySet()) {
            astar(startNode, graph);
        }
    }

    private static void astar(String startNode, Map<String, List<int[]>> graph) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Set<String> closedSet = new HashSet<>();
        Map<String, Node> allNodes = new HashMap<>();

        Node start = new Node(startNode, 0, heuristic(startNode));
        openSet.add(start);
        allNodes.put(startNode, start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (closedSet.contains(current.id)) continue;
            closedSet.add(current.id);

            List<String> path = reconstructPath(current);
            System.out.println("Ruta A*: " + path);

            for (int[] neighbor : graph.get(current.id)) {
                String neighborKey = neighbor[0] + "," + neighbor[1];
                if (closedSet.contains(neighborKey)) continue;

                int tentativeG = current.g + 1;
                Node neighborNode = allNodes.getOrDefault(neighborKey, new Node(neighborKey, Integer.MAX_VALUE, 0));
                allNodes.put(neighborKey, neighborNode);

                if (tentativeG < neighborNode.g) {
                    neighborNode.g = tentativeG;
                    neighborNode.f = tentativeG + heuristic(neighborKey);
                    neighborNode.parent = current;
                    if (!openSet.contains(neighborNode)) {
                        openSet.add(neighborNode);
                    }
                }
            }
        }
    }

    private static List<String> reconstructPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node.id);
            node = node.parent;
        }
        return path;
    }

    private static int heuristic(String node) {
        return 0;  // Se usa heurística constante (0). Se puede mejorar para casos reales.
    }

    private static String formatNeighbors(List<int[]> neighbors) {
        StringBuilder sb = new StringBuilder();
        for (int[] neighbor : neighbors) {
            sb.append("(").append(neighbor[0]).append(",").append(neighbor[1]).append(") ");
        }
        return sb.toString().trim();
    }

    static class Node {
        String id;
        Node parent;
        int g, f;

        public Node(String id, int g, int f) {
            this.id = id;
            this.g = g;
            this.f = f;
        }
    }
}
