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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    map.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
        visited.put(target,true);
        q.offer(target);
        int dist=0;

        while(!q.isEmpty()){
            if(dist==k) break;
            dist++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null){
                    q.offer(map.get(curr));
                    visited.put(map.get(curr),true);
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            list.add(node.val);
        }
        return list;
    }
}