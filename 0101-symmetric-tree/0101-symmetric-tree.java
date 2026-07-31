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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode leftn,TreeNode rightn){
        if((leftn==null && rightn!=null) || (rightn==null && leftn!=null)){
            return false;
        }
        if(leftn==null && rightn==null){
            return true;
        }
        if(leftn.val!=rightn.val){
            return false;
        }
        return helper(leftn.left,rightn.right)&&helper(leftn.right,rightn.left);
    }
}