//dp[i]=Math.max(dp[i-1]+nums[i],nums[i])，i表示已第i个元素结尾的最大子序和
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }
}