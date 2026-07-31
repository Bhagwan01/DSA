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
    List<TreeNode> t1=new ArrayList<>();
    List<TreeNode> t2=new ArrayList<>();
    List<TreeNode> pe=new ArrayList<>();
    List<TreeNode> qu=new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        helper1(root,p);
        helper2(root,q);
        int i=0;
        int j=0;
        TreeNode node=new TreeNode();
        while(i<pe.size() && j<qu.size()){
            if(pe.get(i)==qu.get(j)){
               node=pe.get(i);
            }
            i++;j++;
        }
        return node;
    
    }
    public void helper1(TreeNode node,TreeNode p){
        if(node==null){
            return;
        }
        if(node==p){
            pe.addAll(t1);
            pe.add(node);
            return;
        }
        t1.add(node);
        helper1(node.left,p);
        helper1(node.right,p);
        t1.remove(t1.size()-1);
    }
    public void helper2(TreeNode node,TreeNode p){
        if(node==null){
            return;
        }
        if(node==p){
            qu.addAll(t2);
            qu.add(node);
            return;
        }
        t2.add(node);
        helper2(node.left,p);
        helper2(node.right,p);
        t2.remove(t2.size()-1);
    }
}