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
    public int maxSum;
    
    public int solve(TreeNode root){
        //post order traversal
        if(root == null){
            return 0;
        }
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        //condition 1 
        int sab_achha_hai = leftSum + rightSum + root.val;

        //condition 2
        int only_left_or_right_achha_hai = Math.max(leftSum,rightSum) + root.val;

        //condition 3 
        int only_root_achha_hai = root.val;

        maxSum = Math.max(maxSum,Math.max(sab_achha_hai,Math.max(only_left_or_right_achha_hai,only_root_achha_hai)));

        //very important line return the 2 and 3, do not return 1 because it forms a curve path
        //max of koi achha and only root
        return Math.max(only_left_or_right_achha_hai,only_root_achha_hai);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}