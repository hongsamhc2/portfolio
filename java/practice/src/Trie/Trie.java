package Trie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Trie {

    Node root = null;

    public void insert(String text){
        if(root==null){
            root = new Node();
        }
        Node currentNode = root;
        for (int i = 0;i<text.length();i++){
            char c = text.charAt(i);
            Map<Character,Node> childeNode = currentNode.childeNode;
            if(childeNode.containsKey(c)){
                System.out.println(c);
                Iterator keySet = childeNode.keySet().iterator();
                while(keySet.hasNext()){
                    Character key = (Character) keySet.next();
                    currentNode = (Node) childeNode.get(key).childeNode;
                }
            }else{
                currentNode.childeNode.put(c,new Node());
                currentNode = currentNode.childeNode.get(c);
            }
        }
        currentNode.end=true;
        currentNode.text = text;
    }
    
    public boolean search(String text){
        Node currentNode = root;
        for (int i =0; i<text.length();i++){
            char c = text.charAt(i);
            Map<Character,Node> childeNode = currentNode.childeNode;

            if(childeNode.containsKey(c)){
                currentNode = (Node) childeNode.get(c);

            }

        }
        return currentNode.end;
        
    }
    
}
