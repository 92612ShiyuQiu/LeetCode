/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }   
        maxPathSumHelper(root);
        int res = ans;
        ans = Integer.MIN_VALUE;
        return res;
    }
    
    private static int maxPathSumHelper(TreeNode nd){
        if (nd == null){return 0;}
        int l = Math.max(0, maxPathSumHelper(nd.left));
        int r = Math.max(0, maxPathSumHelper(nd.right));
        int sum = l+r+nd.val;
        ans = Math.max(ans, sum);
        return Math.max(l,r)+nd.val;
    }
}