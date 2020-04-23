class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dirs = new int[m][n];
        dirs[0][0] = 1;
        
        for ( int i = 0; i < m; ++i )
            dirs[i][0] = 1;
        
        for ( int i = 0; i < n; ++i )
            dirs[0][i] = 1;
        
        for ( int i = 1; i < m; ++i )
            for ( int j = 1; j < n; ++j )
                dirs[i][j] += dirs[i-1][j] + dirs[i][j-1];
        return dirs[m-1][n-1];
    }
}