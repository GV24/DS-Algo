/*
Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
*/

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        int levelOfLabel = 0;
        int sum = (int)Math.pow( 2, levelOfLabel );
        List<Integer> list = new ArrayList<>();
        
        while ( sum < label )
        {
            ++levelOfLabel;
            sum += Math.pow( 2, levelOfLabel );
        }
        
        int target = label;
        int level = levelOfLabel;
        list.add(label);
        
        while ( level > 0 )
        {
            if ( (level & 1) == 1 ) // odd level
            {
                int cnt = 0;
                int starter = ((int)Math.pow(2, level+1)) -1;
                cnt = starter - target;
                
                target = ((int)Math.pow(2, level-1)) + (cnt/2);
                list.add( 0, target );
                --level;
            }
            else // even level
            {
                int cnt = 0;
                int starter = (int)Math.pow(2, level);
                cnt = target - starter;
                
                target = ((int)Math.pow(2, level)) - 1 - (cnt/2);
                list.add( 0, target );
                --level;
            }
        }
        
        return list;
    }
}