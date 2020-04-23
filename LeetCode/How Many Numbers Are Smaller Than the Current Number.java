/* How Many Numbers Are Smaller Than the Current Number

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]

*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums)
    {
        int[] freqMap = new int[101];
        int freqSum = 0;
        int t = 0;
        int[] res = new int[nums.length];
        
        for ( int i = 0; i < nums.length; ++i )
            ++freqMap[nums[i]];
        
        for ( int i = 0; i < freqMap.length; ++i )
        {
            if ( freqMap[i] == 0 )
                continue;
            else
            {
                t = freqMap[i];
                freqMap[i] = freqSum;
                freqSum += t;
            }
        }
        
        for ( int i = 0; i < res.length; ++i)
        {
            res[i] = freqMap[nums[i]];
        }
        
        return res;
    }
}