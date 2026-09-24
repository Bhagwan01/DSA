class Solution {
    public int reverse(int x) {
       if(x==0){
        return 0;
       }
       String max="2147483647";
       String min="2147483648";
        boolean negative=false;
        if(x<0){
     negative =true;
     x=-x;
        }
        if(x==Integer.MIN_VALUE){
            return 0;
        }
         String str=Integer.toString(x);
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        str=sb.toString();
        if(str.length()==10){
            if(negative==false){
            int res=str.compareTo(max);
            if(res>0){
                return 0;
            }
        }else{
            int res=str.compareTo(min);
            if(res>0){
                return 0;
            }
        }
        }
         
        str=Integer.toString(Integer.parseInt(str));
        int ans=Integer.parseInt(str);
        if(negative){
            return -ans;
        }
        return ans;
    }
}