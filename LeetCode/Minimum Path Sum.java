/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. */

class Solution {
    public int minPathSum(int[][] grid) {
        
        if ( grid == null || grid.length == 0 || grid[0].length == 0 )
            return 0;
        
        for ( int r = 0; r < grid.length; ++r )
            for ( int c = 0; c < grid[0].length; ++c )
            {
                if ( r == 0 && c != 0 )
                    grid[r][c] = grid[r][c] + grid[r][c-1];
                else if ( r != 0 && c == 0 )
                    grid[r][c] = grid[r][c] + grid[r-1][c];
                else if ( r == 0 && c == 0 )
                    grid[r][c] = grid[r][c];
                else
                    grid[r][c] = Math.min(grid[r-1][c], grid[r][c-1]) + grid[r][c];
            }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}