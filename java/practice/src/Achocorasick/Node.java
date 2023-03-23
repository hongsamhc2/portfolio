package Achocorasick;

import java.util.HashMap;

public class Node {
    Character text;
    boolean last;
    String output;
    HashMap<Character,Node> child;
    Node fail;
    public Node(Character text){
        this.text = text;
        this.last = false;
        this.output = "";
        this.child = new HashMap<>();
        this.fail = null;
    }

}
