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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root,subRoot);
    }
    public boolean helper(TreeNode node,TreeNode subnode){
        if(node==null){
            return false;
        }
        if(isidentical(node,subnode)){
            return true;
        }
        return helper(node.left,subnode) || helper(node.right,subnode);
       
    }
    public boolean isidentical(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null || a.val!=b.val){
            return false;
        }
        return isidentical(a.left,b.left) && isidentical(a.right,b.right);
    }
}