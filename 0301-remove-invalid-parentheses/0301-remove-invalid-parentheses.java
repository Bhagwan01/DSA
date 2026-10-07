class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int min_del = 0;
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open == 0) {
                    min_del++;
                } else {
                    open--;
                }
            }

        }
        min_del += open;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> set=new HashSet<>();
        helper(0, sb, min_del, ans, s, 0,0);
        for(int i=0;i<ans.size();i++){
            set.add(ans.get(i));
        }
        List<String> res=new ArrayList<>(set);
        

        return res;
    }

    public void helper(int idx, StringBuilder sb, int del, List<String> ans, String s, int op,int clo) {
        if (del == 0 && idx == s.length() && op == 0) {
            String temp = sb.toString();
            ans.add(temp);
            return;
        }
        if (idx == s.length() && op == clo) {
            String temp = sb.toString();
            ans.add(temp);
            return;
        }
        if(clo>op){
            return;
        }
        if(clo<0 || op<0){
            return;
        }

        if (del < 0 || idx >= s.length()) {
            return;
        }
        //add
        //System.out.println(idx);
        sb.append(s.charAt(idx));

        if (s.charAt(idx) == '(') {
            helper(idx + 1, sb, del, ans, s, op + 1,clo);
        } else if (s.charAt(idx) == ')') {
            helper(idx+1,sb,del,ans,s,op,clo+1);

        } else {
            helper(idx + 1, sb, del, ans, s, op,clo);
        }

        sb.deleteCharAt(sb.length() - 1);

        //remove
        if (s.charAt(idx) == '(' || s.charAt(idx) == ')') {
            helper(idx + 1, sb, del - 1, ans, s, op,clo);
        }
    }
}