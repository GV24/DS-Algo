/*
Given an array of integers arr and two integers k and threshold.
Return the number of sub-arrays of size k and average greater than or equal to threshold.
*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int[] sums = new int[arr.length + 1];
        int cnt = 0;
        
        for ( int i = 0 ;i < arr.length; ++i)
            sums[i+1] = sums[i] + arr[i];
        
        for( int i = 0; i + k < sums.length; ++i )
        {
            if ( sums[i+k] - sums[i] >= k * threshold )
                ++cnt;
        }
        return cnt;
    }
}