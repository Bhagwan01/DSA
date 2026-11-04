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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        return dfs(root);
    }
    public TreeNode dfs(TreeNode node){
        if(node==null){
            return node;
        }
        TreeNode left=dfs(node.left);
        TreeNode right=dfs(node.right);
        TreeNode temp=left;
        node.left=right;
        node.right=left;
        return node;
    }
}