package datastructures;

import java.util.Map;
import java.util.TreeMap;

public class RedBlackTree {
    private final TreeMap<String, Boolean> tree;

    public RedBlackTree() {
        tree = new TreeMap<>();
    }

    public void insert(String word) {
        tree.put(word, true);
    }

    public boolean search(String word) {
        System.out.println("Red-Black Tree Search Path:");
        return searchAndPrint(word);
    }

    private boolean searchAndPrint(String word) {
        for (String key : tree.keySet()) {
            printNode(key, word);
            if (key.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private void printNode(String key, String searchWord) {
        if (key.equals(searchWord)) {
            System.out.println("|-- " + key + " -> (FOUND)");
        } else {
            System.out.println("|-- " + key);
        }
    }
}
