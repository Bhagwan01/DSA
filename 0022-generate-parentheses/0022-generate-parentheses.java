class Solution {
     List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left=n;
        int right=n;
       StringBuilder sb=new StringBuilder();
        helper(left,right,sb);
        return ans;
    }
    public void helper(int left,int right,StringBuilder temp){
        if(left==0 && right==0){
            ans.add(temp.toString());
            return;
        }
        if(left<0 || right<0){
            return;
        }
        if(left>right){
            return;
        }

        temp.append("(");
         helper(left-1,right,temp);
         temp.deleteCharAt(temp.length()-1);

       temp.append(")");
        helper(left,right-1,temp);
        temp.deleteCharAt(temp.length()-1);
    }
}