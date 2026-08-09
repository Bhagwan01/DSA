class Solution {
    public double minPrice(int[] prices, int[] discounts) {
         double ans=0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i=discounts.length-1;
        int j=prices.length-1;
        while(i>=0 && j>=0){
            ans+=(prices[j]*(100-discounts[i]))/100.0;
            i--;
            j--;
        }
        while(j>=0){
            ans+=prices[j];
            j--;
        }
        return ans;

    }
}