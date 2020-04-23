class Solution {
    public int[][] transpose(int[][] A) {
        
        int[][] res = new int[A[0].length][A.length];
        
        for ( int row = 0; row < A.length; ++row )
            for ( int col = 0; col < A[0].length; ++col )
                res[col][row] = A[row][col];
        return res;
    }
}