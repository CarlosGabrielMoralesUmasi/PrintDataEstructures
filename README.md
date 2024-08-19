# Print Data Structures

Este proyecto en Java implementa y visualiza tres estructuras de datos diferentes: Patricia Trie, Ternary Search Tree y Red-Black Tree. Los usuarios pueden elegir una de estas estructuras para realizar búsquedas en un dataset de palabras en inglés y ver una representación gráfica de la búsqueda directamente en la consola.

## Estructuras de Datos Implementadas

- **Patricia Trie**: Una versión compacta del Trie que almacena las palabras de manera más eficiente.
- **Ternary Search Tree**: Un árbol donde cada nodo puede tener tres hijos y es útil para almacenar cadenas de manera eficiente.
- **Red-Black Tree**: Un tipo de árbol binario de búsqueda balanceado que se auto-balancea.

## Dataset

El dataset utilizado es un conjunto de palabras en inglés, disponible en el archivo \`resources/words_alpha.txt\`.

## Cómo Ejecutar el Proyecto

### Requisitos Previos

- Java Development Kit (JDK) 8 o superior.
- [Git](https://git-scm.com/).

### Compilación y Ejecución

1. Clona el repositorio:

   \`\`\`bash
   git clone https://github.com/CarlosGabrielMoralesUmasi/PrintDataEstructures.git
   cd PrintDataEstructures
   \`\`\`

2. Compila el proyecto:

   \`\`\`bash
   javac -d out src/datastructures/*.java src/model/*.java src/main/*.java
   \`\`\`

3. Ejecuta la aplicación:

   \`\`\`bash
   java -cp out main.SearchApplication
   \`\`\`

4. Sigue las instrucciones en la consola para seleccionar la estructura de datos y realizar la búsqueda.

## Representación Gráfica

Durante la búsqueda, se muestra una representación gráfica en la consola de cómo cada estructura de datos maneja la búsqueda.

## Autor

**Carlos Gabriel Morales Umasi**  
[GitHub](https://github.com/CarlosGabrielMoralesUmasi)
