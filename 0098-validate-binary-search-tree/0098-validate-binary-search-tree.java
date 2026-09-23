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
    long min=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode node){
        if(node==null){
            return true;
        }
        if(!helper(node.left)){
            return false;
        }
        if(min>=node.val){
            return false;
        }
        min=(long)node.val;
        if(!helper(node.right)){
            return false;
        }
        return true;
    }
}