package Trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public Map<Character,Node> childeNode = new HashMap<>();
    public boolean end;
    public String text;
}
