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
    int count=1;
    //int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        helper(root,k,map);
        int ans=map.get(k);
        return ans;

    }
    public void helper(TreeNode node,int k,Map<Integer,Integer> map){
        if(node==null ||count>k){
            return;
        }
        helper(node.left,k,map);
       if(count<=k){
         map.put(count,node.val);
        count++;
       }
        helper(node.right,k,map);
        
    }
}