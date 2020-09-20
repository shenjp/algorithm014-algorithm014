
class Solution {
    public int maxProduct(int[] nums) {
        int dpMin[]=new int[nums.length];
        int dpMax[]=new int[nums.length];
        dpMin[0]=nums[0];
        dpMax[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i]=Math.min(dpMax[i-1]*nums[i],Math.min(dpMin[i-1]*nums[i],nums[i]));
        }
        int maxAns=dpMax[0];
        for(int i=1;i<dpMax.length;i++){
            maxAns=Math.max(dpMax[i],maxAns);
        }
        return maxAns;
    }
}