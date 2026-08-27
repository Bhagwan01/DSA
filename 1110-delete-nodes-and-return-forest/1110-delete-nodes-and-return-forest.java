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
    List<TreeNode> ans=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        helper(root,set,null);
        if(!set.contains(root.val)){
            //deleteNode(root,null,set);
            ans.add(root);
        }
        for(int i=0;i<ans.size();i++){
                  System.out.println(ans.get(i).val);
            if(set.contains(ans.get(i).val)){
              
                ans.remove(ans.get(i));
            }
        }
        return ans;
    }
    public void helper(TreeNode node,HashSet<Integer> set,TreeNode parent){
        if(node==null){
            return;
        }
        
        helper(node.left,set,node);
        helper(node.right,set,node);
        if(set.contains(node.val)){
            if(node.left!=null){
                ans.add(node.left);
            }
            if(node.right!=null){
                ans.add(node.right);
            }
            if(parent!=null && parent.left==node){
            parent.left=null;
        }else if(parent!=null && parent.right==node){
            parent.right=null;
        }
        }
    }
    // public void deleteNode(TreeNode node,TreeNode parent,HashSet<Integer> set){
    //  if(node==null){
    //     return;
    //  }
    //  deleteNode(node.left,node,set);
    //  deleteNode(node.right,node,set);
    //  if(set.contains(node.val)){
        
    //  }

    
}