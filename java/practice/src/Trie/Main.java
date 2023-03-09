package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("text");
        System.out.println(trie.search("text"));
        System.out.println(trie.search("tex"));
    }
}
