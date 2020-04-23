/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
*/

class Solution {
    public int closedIsland(int[][] grid) {
        
        int cnt = 2;
        
        //col wise
        for ( int i = 0 ; i < grid.length; ++i )
        {
            if ( grid[i][0] == 0 )
                DFS( i, 0, grid, 1);
            if ( grid[i][grid[0].length -1] == 0 )
                DFS( i, grid[0].length -1, grid, 1);
        }
        
        //row wise
        for ( int i = 0 ; i < grid[0].length; ++i )
        {
            if ( grid[0][i] == 0 )
                DFS(0, i,grid, 1);
            if ( grid[grid.length-1][i] == 0 )
                DFS(grid.length-1, i,grid, 1);
        }
        
        for ( int i = 1; i < grid.length -1; ++i )
        {
            for ( int j = 1; j < grid[0].length - 1; ++j )
            {
                if ( grid[i][j] == 0 )
                    DFS(i,j,grid,cnt++);
            }
        }
        return cnt - 2;
    }
    
    void DFS(int x, int y, int[][] grid, int flag)
    {
        if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0 )
        {
            grid[x][y] = flag;
            DFS(x+1, y, grid,flag);
            DFS(x-1, y, grid,flag);
            DFS(x, y+1, grid,flag);
            DFS(x, y-1, grid,flag);
        }
    }
}