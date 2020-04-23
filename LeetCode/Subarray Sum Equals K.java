/* Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k. */

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int[] sum = new int[nums.length+1];
        int ret = 0;
        
        for ( int i = 1; i <= nums.length; ++i )
            sum[i] = nums[i-1] + sum[i-1];
        
        for ( int i = 0; i < nums.length; ++i )
        {
            for ( int j = i+1; j <= nums.length; ++j )
            {
                if ( sum[j] - sum[i] == k )
                    ++ret;
            }
        }
        return ret;
    }
}