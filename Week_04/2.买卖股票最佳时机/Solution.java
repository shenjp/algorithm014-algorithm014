//贪心算法：只要当天的价格比前一天高便可出售
class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit=0;
        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-prices[i-1];
            if(profit>0){
                totalProfit+=profit;
            }
        }
        return totalProfit;
    }
}