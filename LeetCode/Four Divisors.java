/*
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
*/

class Solution {
    public int sumFourDivisors(int[] nums) {
        
        Set<Integer> divs = new HashSet<>();
        int sum = 0;
        for ( int num : nums )
        {
            divs.clear();
            divs.add(1);divs.add(num);
            
            for ( int i = 2; i <= Math.sqrt((double)num); ++i )
            {
                if ( num % i == 0 )
                    {divs.add(i); divs.add(num/i);}
                
                if ( divs.size() > 4 )
                    break;
            }
            
            if ( divs.size() == 4 )
                for ( int el : divs )
                    sum += el;
            
        }
        return sum;
    }
}