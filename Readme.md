# Maze Generator and Solver

Este proyecto implementa un generador de laberintos y varios algoritmos de búsqueda para encontrar rutas en el laberinto. El laberinto es representado como una matriz de caracteres donde `#` representa paredes y ` ` (espacio) representa caminos. Los algoritmos disponibles son DFS (Depth-First Search), BFS (Breadth-First Search) y A* Search.

## Características

- **Generador de Laberintos:** Utiliza un algoritmo de backtracking para generar un laberinto con caminos y paredes aleatorios.
- **Solución del Laberinto:** Implementa algoritmos DFS, BFS y A* para encontrar rutas a través del laberinto.
- **Visualización:** Muestra el laberinto generado y las rutas encontradas en la consola.

## Requisitos

- Java 8 o superior

## Instalación

1. **Clonar el repositorio:**

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Compilar los archivos Java:**

    ```bash
    javac MazeGenerator.java MazeSolverMenu.java
    ```

3. **Ejecutar el programa:**

    ```bash
    java MazeSolverMenu
    ```

## Uso

Cuando ejecutes el programa, se te presentará un menú para seleccionar el algoritmo de búsqueda que deseas utilizar para encontrar rutas en el laberinto. Cada opción calcula y muestra las rutas posibles utilizando el algoritmo seleccionado.

### Ejemplo de Ejecución

```bash
Selecciona el algoritmo para calcular y mostrar todas las rutas posibles:
1. Depth-First Search (DFS)
2. Breadth-First Search (BFS)
3. A* Search
```
El programa generará un laberinto aleatorio y mostrará todas las rutas posibles encontradas utilizando el algoritmo seleccionado.

