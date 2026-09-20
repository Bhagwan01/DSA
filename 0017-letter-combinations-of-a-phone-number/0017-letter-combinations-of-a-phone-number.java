class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        int idx=0;
        char ch='a';
        for(int i=2;i<=9;i++){
           char num=(char)(i+'0');
           String str="";
           if(i!=9 && i!=7){
            for(int j=0;j<3;j++){
               str+=(char)(ch+idx);
               idx++;
            }
           }else{
            for(int j=0;j<4;j++){
                str+=(char)(ch+idx);
                idx++;
            }
           }
           map.put(num,str);
        }
        //System.out.println(map.get('2'));
         List<String> list=new ArrayList<>();
         StringBuilder sb=new StringBuilder();
        helper(0,sb,map,list,digits);
        return list;
    }
    public void helper(int idx,StringBuilder combi,HashMap<Character,String> map,List<String> list,String digits){
        
        if(combi.length()==digits.length()){
            list.add(combi.toString());
            return;
        }
            String temp=map.get(digits.charAt(idx));
            for(int i=0;i<temp.length();i++){
                char ch=temp.charAt(i);
                combi.append(ch);
                helper(idx+1,combi,map,list,digits);
                combi.deleteCharAt(combi.length()-1);
            }

    }
}