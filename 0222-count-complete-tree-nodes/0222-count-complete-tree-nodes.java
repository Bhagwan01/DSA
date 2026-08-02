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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(heightLeft(root)==heightright(root)){
            return ((int)Math.pow(2,heightLeft(root)))-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);

    }
    public int heightLeft(TreeNode node){
        if(node==null){
            return 0;
        }
        // int left=height(node.left);
        // int right=height(node.left);
        return 1+heightLeft(node.left);
    }
    public int heightright(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+heightright(node.right);
    }
    
}