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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
       
         boolean temp=false;
         List<Integer> f=new ArrayList<>();
         f.add(root.val);
         ans.add(f);
         if(root.left!=null){
             q.offer(root.left);
      
         }
         if(root.right!=null){
              q.offer(root.right);
         }

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            if(temp==true){
                for(int i=0;i<size;i++){
                    TreeNode curr=q.pollFirst();
                    list.add(curr.val);
                    if(curr.left!=null){
                        q.offerLast(curr.left);
                    }
                    if(curr.right!=null){
                        q.offerLast(curr.right);
                    }
                }
                temp=false;
            }else{
                for(int i=0;i<size;i++){
                    TreeNode curr=q.pollLast();
                    list.add(curr.val);
                    if(curr.right!=null){
                        q.offerFirst(curr.right);
                    }
                    if(curr.left!=null){
                        q.offerFirst(curr.left);
                    }
                    
                }
                temp=true;

            }
            ans.add(list);
        }
        return ans;
    }
}