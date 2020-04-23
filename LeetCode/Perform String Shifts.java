class Solution {
    public String stringShift(String s, int[][] shift) {
        
        int rightShft = 0;
        StringBuilder strBld = new StringBuilder(s);
        int len = s.length();
        
        for ( int[] sh : shift )
        {
            if ( sh[0] == 0 )
                rightShft -= sh[1];
            else
                rightShft += sh[1];
        }
        
        rightShft %= len;
        if ( rightShft < 0 )
            rightShft += len;
        
        for ( int i = 0; i < len; ++i )
            strBld.setCharAt( (i+rightShft) % len, s.charAt(i) );
            
        return strBld.toString();
    }
}