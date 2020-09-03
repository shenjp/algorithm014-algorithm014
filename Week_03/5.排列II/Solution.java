//递归思路：关键点在于如何剪枝
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        boolean[] visit=new boolean[nums.length];
        helper(result,nums,visit,new ArrayList<Integer>());
        return result;
    }
    public void helper(List<List<Integer>> result,int[] nums,boolean[] visit,List<Integer> curList){
        //ternimate
        if(curList.size()==nums.length){
            result.add(new ArrayList<>(curList));
            return;
        }
        //current logic
        for(int i=0;i<nums.length;i++){
            //剪枝
            if(visit[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&visit[i-1]) continue;
            curList.add(nums[i]);
            visit[i]=true;
            //drill down
            helper(result,nums,visit,curList);
            //reverse status(回溯)
            visit[i]=false;
            curList.remove(curList.size()-1);
        }
    }
}