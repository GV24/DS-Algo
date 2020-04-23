/* Implement a trie with insert, search, and startsWith methods. */

class Trie {

    Trie[] root;
    boolean[] ends;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Trie[26];
        ends = new boolean[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        int length = word.length();
        Trie[] node = root;
        
        for ( int i = 0; i < length; ++i )
        {
            if ( node[word.charAt(i) - 97] == null )
                node[word.charAt(i) - 97] = new Trie();

            if ( i == length - 1 )
                node[word.charAt(i) - 97].ends[word.charAt(i) - 97] = true;
            
            node = node[word.charAt(i) - 97].root;
        }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Trie[] node = root;
        int length = word.length();
        
        for ( int i = 0; i < length; ++i )
        {
            if ( node[word.charAt(i) - 97] == null )
                return false;
            
            if ( (i == length - 1) && 
                (node[word.charAt(i) - 97].ends[word.charAt(i) - 97] == true) )
                return true;
            
            node = node[word.charAt(i) - 97].root;   
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Trie[] node = root;
        int length = prefix.length();
        
        for ( int i = 0; i < length; ++i )
        {
            if ( node[prefix.charAt(i) - 97] == null )
                return false;
            
            node = node[prefix.charAt(i) - 97].root;
        }
        return true;
    }
}