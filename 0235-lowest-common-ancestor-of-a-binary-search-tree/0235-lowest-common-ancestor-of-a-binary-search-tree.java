/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
    public TreeNode dfs(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return null;
        }
       
        if(node.val>=p.val && node.val<=q.val || (node.val<=p.val && node.val>=q.val)){
            return node;
        }
        TreeNode left=dfs(node.left,p,q);
        if(left!=null){
            return left;
        }
        
        return dfs(node.right,p,q);

    }
}
