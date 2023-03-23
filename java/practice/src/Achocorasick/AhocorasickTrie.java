package Achocorasick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

public class AhocorasickTrie {
    Node root;
    public AhocorasickTrie(){
        this.root =new Node(null);
    }

    public void add(String text){
        Node currentNode = this.root;
        for (int i =0; i<text.length();i++){
            Character c = text.charAt(i);
            if (!currentNode.child.containsKey(c)){
                currentNode.child.put(c,new Node(c));
            }
            currentNode = currentNode.child.get(c);
        }
        currentNode.output = text;
        currentNode.last = true;
    }

    public void setFail(){
        Queue<Node> queue = new LinkedList<>();
        Iterator keySet = this.root.child.keySet().iterator();
        while(keySet.hasNext()){
            Character c = (Character) keySet.next();
            Node node = this.root.child.get(c);
            node.fail = this.root;
            queue.add(node);
        }
        Node currentNode;
        while((currentNode = queue.poll())!=null){
            Iterator childKeyset = currentNode.child.keySet().iterator();
            while(childKeyset.hasNext()){
                Character childText = (Character) childKeyset.next();
                Node childNode = currentNode.child.get(childText);
                Node fail_node = currentNode.fail;
                while (fail_node !=null && !fail_node.child.containsKey(childText)){
                    fail_node = fail_node.fail;
                }
                if (fail_node!=null){
                    childNode.fail = fail_node.child.get(childText);
                }else{
                    childNode.fail = this.root;
                }
                queue.add(childNode);
            }

        }
    }

    public String search(String text){
        Node currentNode = this.root;
        for(int i =0; i<text.length();i++){
            Character c = text.charAt(i);
            

            while (currentNode.text !=null && !currentNode.child.containsKey(c)){
                currentNode = currentNode.fail;
            }
            // System.out.println(currentNode.text);
            if (currentNode.child.containsKey(c)){
                currentNode = currentNode.child.get(c);
                if (!currentNode.output.isEmpty()){
                    System.out.println(currentNode.output);
                };
            }
        }
        return "";
    }

    public static void main(String[] args) {
        AhocorasickTrie trie = new AhocorasickTrie();
        trie.add("he");
        trie.add("her");
        trie.add("hers");
        trie.add("she");
        trie.setFail();
        trie.search("he likes hers");
    }

}
