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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }    
        return  makeTree(preorder,0,preorder.length-1,0,inorder.length-1,map);
    }
    public TreeNode makeTree(int[] preorder,int pre_st,int pre_end,int in_st,int in_end,HashMap<Integer,Integer> map){
        if(pre_st>pre_end || in_st>in_end){
            return null;
        }
        int temp=map.get(preorder[pre_st]);
        TreeNode node=new TreeNode(preorder[pre_st]);
        int left=temp-in_st;
        node.left=makeTree(preorder,pre_st+1,pre_st+left,in_st,temp-1,map);
        node.right=makeTree(preorder,pre_st+left+1,pre_end,temp+1,in_end,map);
        return node;
    }
}