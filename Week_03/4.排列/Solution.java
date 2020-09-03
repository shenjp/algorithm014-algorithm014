//递归思路：关键点在于如何剪枝
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,nums,new ArrayList<>());
        return result;
    }

    public void helper(List<List<Integer>> result,int[] nums,List<Integer> curList){
        //terminate
        if(curList.size()==nums.length){
            result.add(new ArrayList<>(curList));
            return;
        }
        //current logic
        for(int i=0;i<nums.length;i++){
            //剪枝
            if(curList.contains(nums[i])) continue;
            curList.add(nums[i]);
            //drill down
            helper(result,nums,curList);
            //reverse status(回溯)
            curList.remove(curList.size()-1);
        }
    }
}