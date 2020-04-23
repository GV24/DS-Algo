/*
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.
*/

class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> numToCnt = new HashMap<>();
        
        for ( int el : arr )
        {
            if ( !numToCnt.containsKey(el) )
                numToCnt.put(el, 1);
            else
                numToCnt.put(el, numToCnt.get(el) + 1);
        }
        
        List<Integer> list = new ArrayList<>(numToCnt.values());
        list.sort( (a,b) -> b -a );
        int sum = 0;
        int cnt = 0;
        
        for ( int i : list )
        {
            sum += i;
            cnt++;
            if ( sum >= arr.length / 2 )
                break;
        }
        return cnt;
    }
}