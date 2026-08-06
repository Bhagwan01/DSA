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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int st,int end){
        if(st>end){
            return null;
        }
        TreeNode node=new TreeNode(preorder[st]);
        int temp=st;
        while(temp<=end){
            if(preorder[temp]>preorder[st]){
                break;
            }
            temp++;
        }
        node.left=helper(preorder,st+1,temp-1);
        node.right=helper(preorder,temp,end);
        return node;

    }
}