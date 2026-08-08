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
class NodeValue{
    int minval;
    int maxval;
    int value;
    NodeValue(int a,int b,int c){
        this.minval=a;
        this.maxval=b;
        this.value=c;
    }
}
class Solution {
    int maxsum=0;
    public int maxSumBST(TreeNode root) {
         helper(root);
         return maxsum;
    }
    public NodeValue helper(TreeNode node){
        if(node==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeValue left=helper(node.left);
        NodeValue right=helper(node.right);

        if(left.maxval<node.val && node.val<right.minval){
            int currsum=left.value+right.value+node.val;
            maxsum=Math.max(maxsum,currsum);
            return new NodeValue(Math.min(node.val,left.minval),Math.max(node.val,right.maxval),currsum);
        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.value,right.value));
    }
}