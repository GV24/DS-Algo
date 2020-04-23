/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
     
           if (nums.length == 0) {
            return null;
        }
        return maxBinTree(nums, 0, nums.length - 1);
    }
    
    TreeNode maxBinTree(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return new TreeNode(nums[lo]);
        }
        int mx = nums[lo];
        int mi = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > mx) {
                mx = nums[i];
                mi = i;
            }
        }
        
        TreeNode node = new TreeNode(mx);
        node.left = maxBinTree(nums, lo, mi -1);
        node.right = maxBinTree(nums, mi + 1, hi);
        return node;
        
    }
}