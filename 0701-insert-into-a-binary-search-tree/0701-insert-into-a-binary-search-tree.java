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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode node=new TreeNode(val);
            return node;
        }
        return helper(root,val);
    }
    public TreeNode helper(TreeNode node,int val){
        // if()
        // if(node.left==null && node.right==null){
        //     TreeNode curr=new TreeNode(val);
        //   if(val<node.val){
        //     node.left=curr;
        //   }else if(val>node.val){
        //     node.right=curr;
        //   }
        //   return node;
        // }
        if(node.left==null){
            if(val<node.val){
                TreeNode curr=new TreeNode(val);
                node.left=curr;
                return node;
            }
        } 
        if(node.right==null){
            if(val>node.val){
                TreeNode curr=new TreeNode(val);
                node.right=curr;
                return node;
            }
        }
        if(val<node.val){
             node.left=helper(node.left,val);
        }else{
            node.right=helper(node.right,val);
        }
        return node;
         
    }

}