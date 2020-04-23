/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible
so that each letter appears in at most one part, and return a list of integers representing the size of
these parts.
*/

class Solution {
    public List<Integer> partitionLabels(String S)
    {
        int[] count = new int[26];
        List<Integer> result = new ArrayList<>();
        
        for ( char c : S.toCharArray() )
            ++count[c-'a'];
        
        int[] occr = new int[26];
        char c = ' ';
        int prevLen = 0;
        
        for ( int i = 0; i < S.length(); ++i )
        {
            c = S.charAt(i);
            ++occr[c-'a'];
            
            if ( freqCheck(count, occr) )
            {
                int len = (i + 1) - prevLen;
                result.add(len);
                prevLen += len;
            }
        }
        return result;
    }
    
    boolean freqCheck(int[] src, int[] dest)
    {
        for ( int i = 0; i < src.length; ++i )
            if ( (dest[i] != 0) && (src[i] != dest[i]) )
                return false;
        return true;
    }
}
