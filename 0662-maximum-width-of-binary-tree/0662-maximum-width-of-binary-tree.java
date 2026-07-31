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
    public int widthOfBinaryTree(TreeNode root) {
        int max=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int st=0;
            int end=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode n=p.node;
                int temp=p.idx;
                if(i==0){
                    st=temp;
                }
                if(i==size-1){
                    end=temp;
                    max=Math.max(max,(end-st)+1);
                }
                if(n.left!=null){
                    q.offer(new Pair(n.left,(2*temp)+1));
                }
                if(n.right!=null){
                    q.offer(new Pair(n.right,(2*temp)+2));
                }
            }
        }
        return max;
            
    }
}
class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}