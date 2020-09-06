//贪心算法：优先按照大面值兑换，如果不满足在依次减少大面值更换为小面值
class Solution {
    private int ans=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins,amount,coins.length-1,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public void helper(int[] coins,int amount,int index,int count){
        //terminate
        if(amount==0){
            ans=Math.min(ans, count);
            return;
        }
        if(index<0) return;
        for(int i=amount/coins[index];i>=0&&count+i<ans;i--){
            helper(coins, amount-i*coins[index], index-1, count+i);
        }
    }
}

//动态规划：F(S)=F(S-C)+1 S总金额,C面值。用Map记忆存储。
class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> memoMap=new HashMap<>();
        return helper(coins,amount,memoMap);
    }

    public int helper(int[] coins,int amount,Map<Integer,Integer> memoMap){
        //terminate
        if(amount<0) return -1;
        if(amount==0) return 0;
        if(memoMap.containsKey(amount)) return memoMap.get(amount);
        //current logic
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            //drill down
            int curCount=helper(coins, amount-coins[i], memoMap);
            if(curCount>=0&&minCount>curCount){
                minCount=curCount+1;
            }
        }
        memoMap.put(amount,(minCount==Integer.MAX_VALUE)?-1:minCount);
        return memoMap.get(amount);
    }
}