class Solution {
    public String reverseVowels(String s) {
        
        int i = 0;
        int j  = s.length() - 1;
        char[] str = s.toCharArray();
        
        while ( i < j )
        {
            if ( i >= j )
                break;
            
            while ( i < j && !isVowel(str[i]) ) {
                    ++i;
            }
                   
            while ( i < j && !isVowel(str[j]) ) {
                    --j;
            }
            
            
            if ( i < j )
            {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;
            }
            
            ++i; --j;
        }
        return new String(str);
        
    }
    
    boolean isVowel ( char c )
    {
        switch ( c )
        {
            case 'a':case 'e':case'i':case'o':case 'u': case 'A': case'E' : case 'I':
                case'O': case'U':
                return true;
            default:
                return false;
        }
    }
}