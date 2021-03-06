/* Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values. */

class Solution {
    public boolean hasAlternatingBits(int n) {

        n = n ^ (n >> 1);
        return (n & (n+1)) == 0;
    }
}