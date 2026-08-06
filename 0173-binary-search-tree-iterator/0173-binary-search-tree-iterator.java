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
class BSTIterator {
    TreeNode node=new TreeNode();
    List<Integer> list=new ArrayList<>();
    int idx=0;
    public BSTIterator(TreeNode root) {
        this.node=root;
        helper(node);
    }
    
    public int next() {
        int ans=list.get(idx);
        idx++;
        return ans;
    }
    
    public boolean hasNext() {
        if(idx==list.size()){
            return false;
        }
        return true;
        
    }
    public void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */