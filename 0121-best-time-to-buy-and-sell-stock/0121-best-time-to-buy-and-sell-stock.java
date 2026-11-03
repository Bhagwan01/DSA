class Solution {
    public int maxProfit(int[] prices) {
        int temp=prices[prices.length-1];
        int ans=0;
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>temp){
                temp=prices[i];
            }else{
                ans=Math.max(ans,(temp-prices[i]));
            }
        }
        
        return ans;
    }
}