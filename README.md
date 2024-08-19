# Tic-Tac-Toe (Tres en Raya)

Este es un juego de Tres en Raya implementado en Java utilizando la biblioteca Swing para la interfaz gráfica. El jugador compite contra una inteligencia artificial (IA) que utiliza el algoritmo Minimax con poda alfa-beta para tomar decisiones óptimas.

## Características

- **Modo de Juego**: El jugador humano juega contra la máquina.
- **Algoritmo Minimax con Poda Alfa-Beta**: La IA toma decisiones basadas en un análisis profundo del tablero, optimizando su estrategia para ganar o empatar.
- **Interfaz Gráfica**: Implementada con Swing, proporcionando una experiencia visual y de juego interactiva.

## Requisitos

- **Java 8** o superior debe estar instalado en tu máquina.

## Instalación y Ejecución

1. **Clonar el repositorio (si es necesario):**

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Guardar el Código:**

   Asegúrate de que el código de `TicTacToe.java` esté guardado en el directorio principal del proyecto.

3. **Compilar los archivos Java:**

    ```bash
    javac TicTacToe.java
    ```

4. **Ejecutar el programa:**

    ```bash
    java TicTacToe
    ```

## Uso

- **Interfaz de Usuario**: Se abrirá una ventana de juego. El jugador comienza haciendo clic en cualquier celda vacía del tablero para colocar su "X".
- **IA**: La máquina responde automáticamente colocando una "O" en el tablero utilizando el mejor movimiento disponible basado en Minimax con poda alfa-beta.
- **Final del Juego**: El juego termina cuando un jugador gana, pierde o se produce un empate. Al final de cada partida, el tablero se reinicia automáticamente.

## Estructura del Código

- **TicTacToe.java**: 
  - Contiene la lógica completa del juego y la interfaz gráfica.
  - Implementa el algoritmo Minimax con poda alfa-beta para la toma de decisiones de la máquina.
  - Maneja eventos de clic en el tablero y actualiza el estado del juego en consecuencia.

## Ejemplo de Ejecución

Una vez que ejecutes el programa, verás una ventana de juego con una cuadrícula 3x3. El jugador comienza la partida, y la máquina responde automáticamente después de cada movimiento.
