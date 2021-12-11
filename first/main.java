import java.util.ArrayList;
import java.util.List;

/*
    Implement auto-completion. Given a large set of words (for instance 1,000,000 words)
    and then a single word prefix, find all words that it can complete to.

    input:  amazon
    input:  [amaz, amazonian,amazonn,amaz,amn,trouble,armenia]
    output: [amaz,amazonian,amazonn,amaz]
 */

public class main {
    public static class TrieNode{
        char data;
        TrieNode[] children = new TrieNode[128];
        boolean isEnd = false;
        public TrieNode(char c){
            this.data = c;
        }
    }
    public static class Trie{
        TrieNode root = new TrieNode(' ');
        public void insert(String word){
            TrieNode node = root;
            for(var ch:word.toCharArray()){
                if(node.children[ch] == null)
                    node.children[ch] = new TrieNode(ch);
                node = node.children[ch];
            }
            node.isEnd = true;
        }
        void helper(TrieNode node,List<String> results,String prefix) {
            if (node == null)
                return;
            if (node.isEnd) {
                results.add(prefix + node.data);
            }
            for (var child : node.children) {
                helper(child, results, prefix + node.data);
            }
        }
        List<String> autocomplete(String prefix){
            var node = root;
            var results = new ArrayList<String>();
            for(char ch:prefix.toCharArray()){
                node = node.children[ch];
                if(node == null)
                    return new ArrayList<String>();
            }
            helper(node,results,prefix.substring(0,prefix.length()-1));
            return results;
        }
    }
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("amazon");
        trie.insert("amazon prime");
        trie.insert("amazon spider man");
        System.out.println(trie.autocomplete("amaz"));
    }
}
