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
    PriorityQueue<Pair> pq = new PriorityQueue<>((t1, t2) -> {
    if (t1.b != t2.b) {
        return Integer.compare(t1.b, t2.b);
    }
    if (t1.a != t2.a) {
        return Integer.compare(t1.a, t2.a);
    }
    return Integer.compare(t1.c, t2.c);
});
    public List<List<Integer>> verticalTraversal(TreeNode root) {
         
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        boolean flag=true;
        helper(root,0,0);
        Integer last=null;
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
         Pair p=pq.poll();

         if(last!=null && p.b!=last){
            ans.add(list);
            list=new ArrayList<>();
         }
         list.add(p.c);
         last=p.b;
        }
        ans.add(list);
        
        return ans;

    }
    public void helper(TreeNode node,int c,int r){
        if(node==null){
            return;
        }
        pq.offer(new Pair(r,c,node.val));
        helper(node.left,c-1,r+1);
        helper(node.right,c+1,r+1);
    }
}
class Pair{
    int a;
    int b;
    int c;
    Pair(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}