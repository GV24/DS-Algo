/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        if (n == 0)
            return new ArrayList<String>();
        DFS(n ,res, 0, 0, "");
        return res;
    }
    
    void DFS ( int n , List<String> list, int opened, int closed, String str )
    {
        if ( closed == n && opened == n) {
            list.add(str);
            return;
        }
        
        if ( opened < n )
            DFS(n, list, opened+1, closed, str + "(");
        if ( closed < opened )
            DFS(n, list, opened, closed+1, str + ")");
        
    }
    
    
}