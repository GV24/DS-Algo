class Solution {
    public int numSteps(String s) {
        
        int ret = 0;
        int rem = 0;
        for ( int i = s.length() - 1; i > 0 ; --i )
        {
            switch( (s.charAt(i) - '0') + rem )
            {
                case 0:
                    rem = 0;
                    break;
                case 1:
                    rem = 1;
                    ret += 1;
                    break;
                case 2:
                    rem = 1;
                    break;
            }
            ret++;
        }
        
        return ret + rem;
    }
    
}