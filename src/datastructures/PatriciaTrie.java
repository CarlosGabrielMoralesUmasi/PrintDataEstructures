package datastructures;

import java.util.HashMap;
import java.util.Map;

public class PatriciaTrie {
    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final Node root;

    public PatriciaTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new Node());
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        System.out.println("Patricia Trie Search Path:");
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int level) {
        if (node == null) {
            return false;
        }

        if (level < word.length()) {
            char ch = word.charAt(level);
            Node nextNode = node.children.get(ch);
            printNode(nextNode, ch, level);
            return search(nextNode, word, level + 1);
        }

        return node.isEndOfWord;
    }

    private void printNode(Node node, char ch, int level) {
        String prefix = "  ".repeat(level);
        if (node == null) {
            System.out.println(prefix + "|-- " + ch + " -> NULL");
        } else {
            System.out.println(prefix + "|-- " + ch + " -> " + (node.isEndOfWord ? "(END)" : ""));
        }
    }
}
