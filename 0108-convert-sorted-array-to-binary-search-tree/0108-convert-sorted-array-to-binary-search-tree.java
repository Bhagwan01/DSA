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
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(0,nums.length-1,nums);
    }
    public TreeNode helper(int i,int j,int[] nums){
        if(i>j){
            return null;
        }
        int mid=(j+i)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=helper(i,mid-1,nums);
        node.right=helper(mid+1,j,nums);
        return node;

    }
}