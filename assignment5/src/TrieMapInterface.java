import java.util.ArrayList;
public interface TrieMapInterface{
  //Adds the key/value pair to the TrieMap
  void put(String key, String value);
  
  //Returns the object value associated with the given key
  //If the key is not present in the TrieMap, returns null
  String get(String key);
  
  //Returns true if key is in the TrieMap, false otherwise
  boolean containsKey(String key);
  
  //Returns an ArrayList of objects containing all keys that start with prefix
  ArrayList<String> getKeysForPrefix(String prefix);
  
  //Prints all values stored inside the TrieMap
  void print();
  
}