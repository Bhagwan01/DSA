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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int lhgt=height(root.left);
        int rhgt=height(root.right);
        if(Math.abs(lhgt-rhgt)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int l=height(node.left);
        int r=height(node.right);

        return 1+Math.max(l,r);
    }
}