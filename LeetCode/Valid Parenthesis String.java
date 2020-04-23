/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
5. An empty string is also valid.
*/

class Solution {
    public boolean checkValidString(String s) {

        int hi = 0;
        int lo = 0;
        
        for ( char c : s.toCharArray() )
        {
            if ( c == '(' )
            {
                ++lo;
                ++hi;
            }
            else if ( c == ')' )
            {
                if ( lo > 0)
                    --lo;
                --hi;
            }
            else
            {
                if ( lo > 0)
                    --lo;
                ++hi;
            }
            
            if ( hi < 0 )
                return false;
        }
        
        return  (lo == 0);  
    }
}