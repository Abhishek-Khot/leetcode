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
    public int inOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = inOrder(root.left);
        int rightDepth = inOrder(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    public int maxDepth(TreeNode root) {
        return inOrder(root);
    }
}