# Breakout Game en Java

Este proyecto es una implementación del clásico juego Breakout (Arkanoid) en Java utilizando la biblioteca Swing para la interfaz gráfica. El juego incluye dos modos: uno en el que el jugador controla la paleta manualmente, y otro en el que la máquina juega automáticamente.

## Características

- **Modo Jugador**: Controla la paleta utilizando las teclas `A` y `D` para moverla a la izquierda y derecha, respectivamente.
- **Modo Máquina**: La máquina controla automáticamente la paleta, siguiendo la pelota para mantenerla en juego.
- **Interfaz Gráfica**: El juego cuenta con una interfaz gráfica simple pero funcional, creada con Swing.
- **Bloques Destructibles**: La pelota rebota en la paleta y las paredes, destruyendo bloques a medida que los golpea.

## Requisitos

- **Java 8** o superior debe estar instalado en tu máquina.

## Instalación y Ejecución

1. **Clonar el repositorio (si es necesario):**

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Crear los Archivos Java:**

   Asegúrate de que los siguientes archivos `.java` estén presentes en el directorio de trabajo:
   - `BreakoutGame.java`
   - `GamePanel.java`
   - `Ball.java`
   - `Paddle.java`
   - `Brick.java`

3. **Compilar los archivos Java:**

    Abre PowerShell o una terminal y navega al directorio donde están tus archivos `.java`. Luego, compila todos los archivos con el siguiente comando:

    ```bash
    javac *.java
    ```

4. **Ejecutar el programa:**

    Después de compilar, ejecuta el juego con el siguiente comando:

    ```bash
    java BreakoutGame
    ```

## Uso

Al iniciar el juego, se te presentará una ventana donde puedes seleccionar entre dos modos:

- **Jugador**: Controla la paleta usando las teclas `A` y `D`.
- **Máquina**: La máquina controla automáticamente la paleta.

### Instrucciones:

1. **Selecciona el Modo de Juego**:
   - Al iniciar el programa, se te pedirá que elijas si quieres jugar manualmente o dejar que la máquina juegue por ti.

2. **Modo Jugador**:
   - Usa la tecla `A` para mover la paleta a la izquierda.
   - Usa la tecla `D` para mover la paleta a la derecha.
   - Presiona la tecla `Espacio` para iniciar el juego si no comienza automáticamente.

3. **Modo Máquina**:
   - Si seleccionas el modo máquina, la paleta se moverá automáticamente siguiendo la pelota.

4. **Objetivo**:
   - Destruye todos los bloques con la pelota sin dejar que la pelota caiga por debajo de la paleta.

## Estructura del Código

- **BreakoutGame.java**: Es la clase principal que inicia el juego. Gestiona la interfaz gráfica y los eventos del teclado para mover la paleta.
- **GamePanel.java**: Maneja el panel de juego, el movimiento de la pelota, y la detección de colisiones. También gestiona el modo de juego de la máquina.
- **Ball.java**: Representa la pelota del juego, incluyendo su movimiento y colisiones.
- **Paddle.java**: Representa la paleta controlada por el jugador o la máquina.
- **Brick.java**: Representa los bloques destructibles en el juego.

## Modo Automático (Máquina)

El modo automático es una característica destacada en la que la máquina toma el control de la paleta. Cuando eliges esta opción al inicio del juego, el código en `GamePanel.java` hace que la paleta siga automáticamente la posición de la pelota, asegurándose de que siempre esté debajo de ella para evitar que caiga.

Esta funcionalidad es útil si quieres observar cómo se desarrolla el juego sin tener que controlarlo manualmente.

## Contribuciones

Las contribuciones son bienvenidas. Si tienes ideas para mejorar el juego o añadir nuevas características, por favor, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.
