import java.util.ArrayList;

public class TrieMap implements TrieMapInterface {
    private final TrieMapNode root; // Root Node
    private ArrayList<String> subTreeValues = new ArrayList<String>(); // To store values of subtrees during recursion

    public TrieMap() {
        this.root = new TrieMapNode();
    }

    public void put(String key, String value) {
        put(root, key, value);
    }

    public void put(TrieMapNode node, String key, String value) {
        if (key.equals("")) { node.setValue(value); // Base Case
        } else { // Recursive Case
            node.addChildIfNotExists(key.charAt(0));
            put(node.getChildIfExists(key.charAt(0)), key.substring(1), value);
        }
    }

    public String get(String key) {
        return get(root, key, 0);
    }

    public String get(TrieMapNode node, String word, int idx) {
        if (idx == word.length()) { return node.getValue(); } // Base Case
        if (node.getChildIfExists(word.charAt(idx)) == null) { return null; } // Base case
        return get(node.getChildIfExists(word.charAt(idx)), word, idx + 1); // Recursive case
    }

    public boolean containsKey(String key) { return containsKey(root, key, 0); }

    public boolean containsKey(TrieMapNode current, String word, int idx) {
        if (idx == word.length()) { return current.getValue() != null; } // Base Case
        if (current.getChildIfExists(word.charAt(idx)) == null) { return false; } // Base case
        return containsKey(current.getChildIfExists(word.charAt(idx)), word, idx + 1); // Recursive case
    }

    // Helper method
    public TrieMapNode findNode(TrieMapNode node, String word, int idx) {
        if (idx == word.length()) { return node; } // Base Case
        if (node.getChildIfExists(word.charAt(idx)) == null) { return null; } // Base case
        return findNode(node.getChildIfExists(word.charAt(idx)), word, idx + 1); // Recursive case
    }

    // Helper method
    public ArrayList<String> getSubTreeKeys(TrieMapNode parentNode) {
        for (Character key : parentNode.getChildren().keySet()) { // Go over each key in the child
            if (parentNode.getChildren().get(key).getValue() != null) { // Edge case check
                subTreeValues.add(parentNode.getChildren().get(key).getValue()); // Add to a global Array
            }
            getSubTreeKeys(parentNode.getChildren().get(key)); // Recursive step
        }
        return subTreeValues; // return all the values in a subtree after the for-loop has ended
    }

    public ArrayList<String> getKeysForPrefix(String word) {
        ArrayList<String> prefixKeys = new ArrayList<String>(); // Store all the keys with the prefix
        TrieMapNode parentNode = findNode(root, word, 0); // Find the parentNode of interest

        if (parentNode == null) { return new ArrayList<String>(); } // Edge case check

        if (parentNode.getValue() != null) { // Edge case check
            if (parentNode.getValue().equals(word)) {
                prefixKeys.add(word);
                return prefixKeys;
            }
        }

        for (String key : getSubTreeKeys(parentNode)) { // Go over each key in the parent's children
            if (word.length() <= key.length()) { // Edge case check
                if (key.substring(0, word.length()).equals(word)) { // Edge case check
                    prefixKeys.add(key); // Add the key to the prefix array
                }
            }
        }
        return prefixKeys; // return all the keys in a subtree after the for-loop has ended
    }

    public void print() { print(root); }

    public void print(TrieMapNode root) {
        for (String value : getSubTreeKeys(root)) { // Go over all the parents and their children
            System.out.println(value); // Print the values
        }
    }

    public static void main(String[] args) {
        TrieMap map = new TrieMap();
        String test1 = "work";
        map.put(test1, test1);
        map.put("test", "test");

        String test2 = "word";
        map.put(test2, test2);
        System.out.println(map.get(test1));
        System.out.println(map.get(test2));
        System.out.println(map.get("wor"));
        System.out.println(map.containsKey("asd"));
        map.print();
    }
}