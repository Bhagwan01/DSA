class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int max=1;
        
         HashMap<Character,Integer> map=new HashMap<>();
         map.put(s.charAt(0),1);
         int i=0;
         int j=1;
         while(j<s.length()){
            char ch=s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch,1);
                 
            }else{
                while(map.get(ch)!=0){
                    if(ch==s.charAt(i)){
                        int val=map.get(ch);
                        val=val-1;
                        map.put(ch,val);
                    }else{
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                map.put(ch,1);
                
            }
            max=Math.max(max,j-i+1);
           
            j++;
         }
         return max;
    }
}