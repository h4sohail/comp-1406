import java.util.HashMap;

public class TrieMapNode {
    //Keys are characters
    //Values are other TrieMapNodes
    //This way, you can use the next character in a String to determine the next node
    //This allows you to progress deeper into the tree
    private HashMap<Character, TrieMapNode> children;
    private String value;

    public TrieMapNode() {
        children = new HashMap<Character, TrieMapNode>();
        value = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newVal) {
        value = newVal;
    }

    public TrieMapNode getChildIfExists(Character letter) { // Helper method
        return children.getOrDefault(letter, null);
    }

    public void addChildIfNotExists(Character key) { // Helper method
        TrieMapNode child = new TrieMapNode();
        if (!children.containsKey(key)) {
            children.put(key, child);
        }
    }

    public HashMap<Character, TrieMapNode> getChildren() {
        return children;
    }

}