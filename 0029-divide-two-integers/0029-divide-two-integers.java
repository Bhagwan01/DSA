class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int ans=0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        while(a>=b){
            long div=b;
            int ls=0;
            while(a>=div){
                ls++;
                div=div<<1;
            }
            ans+=1<<(ls-1);
            a=a-(b<<(ls-1));
        }
        if(dividend<0 && divisor<0 || dividend>=0 && divisor>0){
            return ans;
        }
        return -ans;
    }
}