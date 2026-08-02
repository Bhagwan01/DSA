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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,postorder.length-1,0,0,inorder.length-1,map);
        
    }
    public TreeNode helper(int[] postorder,int ps,int pe,int is,int ie,HashMap<Integer,Integer> map){
     if(ps<pe || is>ie){
        return null;
     }
        int temp=map.get(postorder[ps]);
        TreeNode node=new TreeNode(postorder[ps]);
        int right=ie-temp;
        node.left=helper(postorder,ps-right-1,pe,is,temp-1,map);
        node.right=helper(postorder,ps-1,ps-right,temp+1,ie,map);
        return node;
    }
}