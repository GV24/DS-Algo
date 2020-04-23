/*
Reverse bits of a given 32 bits unsigned integer.
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int ret = 0;
        int j = 0;
        
        for (int i = 0; i < 32; ++i )
        {
            ret += n & 1;
            if ( i <= 30 )
                ret = ret << 1;
            n = n >>> 1;
        }
        
        return ret;
    }
}