class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) 
    {
        boolean[] visited = new boolean[n];
        
        int iteratedNodes = 0;
        
        if ( n == 1)
            return true;
            
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(0);
        int levelSize = 0;
        
        while( !q.isEmpty() )
        {
            int node = q.poll();
            ++iteratedNodes;
            
            if ( iteratedNodes > n )
                return false;
            
            if ( !visited[node] )
            {
                visited[node] = true;

                if ( leftChild[node] != -1)
                    q.add(leftChild[node]);

                if ( rightChild[node] != -1)
                    q.add(rightChild[node]);
            }
            else
                return false;
        }
        if ( iteratedNodes == n )
            return true;
        else
            return false;
    }
}