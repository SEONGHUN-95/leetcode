class Solution {
    public int maxProfit(int[] prices) {
        int min = 10000;
        int max_profit = 0;
        for(int i = 0; i < prices.length ; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            if(prices[i]-min>max_profit){
                max_profit = prices[i]-min;
            }
        }
        return max_profit;
    }
}