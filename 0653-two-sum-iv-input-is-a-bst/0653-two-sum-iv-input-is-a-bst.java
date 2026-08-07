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
    public boolean findTarget(TreeNode root, int k) {
        List<TreeNode> list=new ArrayList<>();
        helper(root,list);
        boolean ans=false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i).val,i);
        }
        for(int i=0;i<list.size()-1;i++){
            int temp=k-list.get(i).val;
            if(map.containsKey(temp)){
                int idx=map.get(temp);
                if(idx==i){
                    continue;
                }
                ans=true;
                break;
            }
            
        }
        return ans;
    }
    public void helper(TreeNode node,List<TreeNode> list){
        if(node==null){
            return;
        }
        helper(node.left,list);
        list.add(node);
        helper(node.right,list);
    }
}