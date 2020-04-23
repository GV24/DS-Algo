/*
1 - land, 0 - water
*/

class Solution {
    public int numIslands(char[][] grid) {
        
        int lastTag = (int)'2';
        for ( int row = 0; row < grid.length; ++row )
        {
            for ( int col = 0; col < grid[0].length; ++col )
            {
                if ( isValid ( row, col, grid) ) {
                    DFS(row, col, grid, lastTag);
                    lastTag++;
                }
            }
        }
        return (lastTag - '0') - 2;
    }
    
    void DFS(int x, int y, char[][] grid, int lastTag)
    {
        int[][] dirs = { {0,1}, {1,0}, {-1,0}, {0,-1}};
        int nextX = 0;
        int nextY = 0;
        
        for( int[] d : dirs )
        {
            nextX = x + d[0];
            nextY = y + d[1];
            
            if ( isValid(nextX, nextY, grid) )
            {
                grid[nextX][nextY] = (char)lastTag;
                DFS(nextX, nextY, grid, lastTag);
            }
        }
    }
    
    boolean isValid( int x, int y, char[][] grid )
    {
        if ( x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == (int)'1')
            return true;
        return false;
    }
}