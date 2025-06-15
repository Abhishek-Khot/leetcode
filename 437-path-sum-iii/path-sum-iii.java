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
    public int count;
    public void solve(TreeNode root,int targetSum,HashMap<Long,Integer> map,long cSum){
        if(root == null){
            return;
        }
        cSum+=root.val;
        // if(map.containsKey(targetSum)){
        //     count++;
        // }
        if(map.containsKey(cSum - targetSum)){
            count+=map.get(cSum - targetSum);
        }
        map.put(cSum,map.getOrDefault(cSum,0)+1);
        solve(root.left,targetSum,map,cSum);
        solve(root.right,targetSum,map,cSum);
        map.put(cSum,map.get(cSum)-1);//backtracking
    }
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;

        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L, 1);
        solve(root,targetSum,map,0);
        return count;
    }
}