package main;

import datastructures.PatriciaTrie;
import datastructures.TernarySearchTree;
import datastructures.RedBlackTree;
import model.WordDataset;

import java.util.Scanner;

public class SearchApplication {
    public static void main(String[] args) {
        WordDataset dataset = new WordDataset("resources/words_alpha.txt");

        PatriciaTrie patriciaTrie = new PatriciaTrie();
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        RedBlackTree redBlackTree = new RedBlackTree();

        // Insert all words into each data structure
        for (String word : dataset.getWords()) {
            patriciaTrie.insert(word);
            ternarySearchTree.insert(word);
            redBlackTree.insert(word);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la estructura de datos para búsqueda:");
        System.out.println("1. Patricia Trie");
        System.out.println("2. Ternary Search Tree");
        System.out.println("3. Red-Black Tree");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.print("Ingrese la palabra a buscar: ");
        String searchWord = scanner.nextLine();

        boolean found = false;
        switch (choice) {
            case 1:
                found = patriciaTrie.search(searchWord);
                break;
            case 2:
                found = ternarySearchTree.search(searchWord);
                break;
            case 3:
                found = redBlackTree.search(searchWord);
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        if (found) {
            System.out.println("Palabra encontrada.");
        } else {
            System.out.println("Palabra no encontrada.");
        }

        scanner.close();
    }
}
    