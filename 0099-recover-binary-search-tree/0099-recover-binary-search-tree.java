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
    public void recoverTree(TreeNode root) {
        TreeNode curr=root;
        TreeNode prev=null;

        TreeNode first=null;
        TreeNode second=null;
        while(curr!=null){
            if(curr.left==null){
                if(prev!=null && prev.val>curr.val){
                    if(first==null){
                        first=prev;
                    }
                    second=curr;
                }
                prev=curr;
                curr=curr.right;
            }else{
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==curr){
                    temp.right=null;
                    if(prev!=null && prev.val>curr.val){
                    if(first==null){
                        first=prev;
                    }
                    second=curr;
                }
                    prev=curr;
                    curr=curr.right;
                }else{
                    temp.right=curr;
                    curr=curr.left;
                }
            }
        }
        if(first!=null && second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
}