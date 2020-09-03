//递归思路：关键点在于begin、回溯
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,n,k,1,new ArrayList<Integer>());
        return result;
    }

    public void helper(List<List<Integer>> result,int n,int k,int begin,List<Integer> curList){
        //terminate
        if(curList.size()==k){
            result.add(new ArrayList<>(curList));
            return;
        }
        //current logic
        for(int i=begin;i<=n;i++){
            curList.add(i);
            //drill down
            helper(result,n,k,i+1,curList);
            //reverse status(回溯)
            curList.remove(curList.size()-1);
        }
    }
}