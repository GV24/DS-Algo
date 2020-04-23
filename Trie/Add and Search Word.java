/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
*/

class Node
{
    Node[] nodes;
    boolean wordEnds;
    
    Node()
    {
        nodes = new Node[26];
    }
}

class WordDictionary {

    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        int length = word.length();
        Node node = root;
        int i = 0;
        for ( ; i < length; ++i )
        {
            if ( node.nodes[word.charAt(i) - 'a'] == null )
                node.nodes[word.charAt(i) - 'a'] = new Node();

            node = node.nodes[word.charAt(i) - 'a'];
        }
        node.wordEnds = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word)
    {
        int length = word.length();
        Node node = root;
        
        return recurSearch ( node, 0, word );
    }
    
    private boolean recurSearch ( Node node, int idx, String word)
    {
        if ( node == null )
            return false;
        
        if ( word.charAt(idx) <= 122 && word.charAt(idx) >= 97 )
        {
            if ( node.nodes[word.charAt(idx) - 'a'] == null )
                return false;

            if ( word.length() - 1 == idx )
            {
                return node.nodes[word.charAt(idx) - 'a'].wordEnds;
            }
        }
        
        
        if ( word.charAt(idx) == '.' )
        {   
            if ( idx == word.length() - 1 )
            {
                for ( int j = 0; j < 26; ++j)
                    if (node.nodes[j] != null && node.nodes[j].wordEnds)
                        return true;
            return false;
            }
            
            boolean found = false;
            for ( int j = 0; j < 26; ++j )
            {
                found = recurSearch( node.nodes[j], idx+1,  word);
                if ( found )
                    break;
            }
            return found;
        }
        else
        {
            return recurSearch( node.nodes[word.charAt(idx) - 'a'],
                               idx + 1, word );
        }
    }
}