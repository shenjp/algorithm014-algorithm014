//Map+大顶堆
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue=
                new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll().getKey();
        }
        return result;
    }
}