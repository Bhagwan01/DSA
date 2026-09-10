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
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return res;
    }
    public void helper(TreeNode node,int k){
        if(node==null || count>k){
            return;
        }
        helper(node.left,k);
        count++;
        if(count==k){
            res=node.val;
            return;
        }
        helper(node.right,k);
    }
}