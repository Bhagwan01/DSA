class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(map.containsKey(ch)){
                int val=map.get(ch);
                map.put(ch,val+1);
            }else{
                map.put(ch,1);
            }
        }
        char[] c2=s1.toCharArray();
        Arrays.sort(c2);
        int len=s1.length();
        int i=0;
        boolean ans=false;
        while(i<=(s2.length()-s1.length())){
            char ch=s2.charAt(i);
            System.out.println(ch);
            if(map.containsKey(ch)){
               int j=i+len-1;
               String temp=s2.substring(i,j+1);
               
               char[] c1=temp.toCharArray();
               Arrays.sort(c1);
               ans=Arrays.equals(c1,c2);
            }
            if(ans==true){
                break;
            }
            i++;
        }
        return ans;

    }
    
}