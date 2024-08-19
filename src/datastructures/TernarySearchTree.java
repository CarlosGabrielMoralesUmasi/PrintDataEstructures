package datastructures;

public class TernarySearchTree {
    private static class Node {
        char character;
        Node left, middle, right;
        boolean isEndOfWord = false;

        Node(char character) {
            this.character = character;
        }
    }

    private Node root;

    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    private Node insert(Node node, char[] word, int index) {
        char ch = word[index];
        if (node == null) {
            node = new Node(ch);
        }
        if (ch < node.character) {
            node.left = insert(node.left, word, index);
        } else if (ch > node.character) {
            node.right = insert(node.right, word, index);
        } else {
            if (index + 1 < word.length) {
                node.middle = insert(node.middle, word, index + 1);
            } else {
                node.isEndOfWord = true;
            }
        }
        return node;
    }

    public boolean search(String word) {
        System.out.println("Ternary Search Tree Search Path:");
        return search(root, word.toCharArray(), 0, 0);
    }

    private boolean search(Node node, char[] word, int index, int level) {
        if (node == null) {
            printNode(node, '\0', level);
            return false;
        }

        char ch = word[index];
        printNode(node, ch, level);

        if (ch < node.character) {
            return search(node.left, word, index, level + 1);
        } else if (ch > node.character) {
            return search(node.right, word, index, level + 1);
        } else {
            if (index + 1 == word.length) {
                return node.isEndOfWord;
            }
            return search(node.middle, word, index + 1, level + 1);
        }
    }

    private void printNode(Node node, char ch, int level) {
        String prefix = "  ".repeat(level);
        if (node == null) {
            System.out.println(prefix + "|-- NULL");
        } else {
            System.out.println(prefix + "|-- " + node.character + (node.isEndOfWord ? " (END)" : ""));
        }
    }
}
