/*
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.
*/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] xors = new int[arr.length];
        int[] res = new int[queries.length];
        
        xors[0] = arr[0];
        for(int i = 1; i < arr.length; ++i)
            xors[i] = xors[i-1] ^ arr[i];
        
        for ( int i = 0; i < queries.length; ++i )
        {
            int first = queries[i][0];
            int sec = queries[i][1];

            if ( first == sec )
                res[i] = arr[first];
            else
                res[i] = xors[sec] ^ (first > 0 ? (xors[first - 1]) : 0);
        }
        
        return res;
    }
}