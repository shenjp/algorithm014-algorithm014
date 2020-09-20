class Solution {
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins=coins;
        return dfs(amount,new int[amount+1]);
    }

    public int dfs(int leftAmount,int[] memo){
        if(leftAmount<0) return -1;
        if(leftAmount==0) return 0;
        if(memo[leftAmount]!=0) return memo[leftAmount];
        Integer minCount=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int subCount=dfs(leftAmount-coins[i], memo);
            if(subCount>=0&&subCount<minCount){
                minCount=Math.min(minCount,subCount+1);
            }
        }
        memo[leftAmount]=minCount!=Integer.MAX_VALUE?minCount:-1;
        return memo[leftAmount];
    }
}