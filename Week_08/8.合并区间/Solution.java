class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
        List<int[]> merged=new ArrayList<>();
        merged.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int l=intervals[i][0];
            int r=intervals[i][1];
            int[] preInterval=merged.get(merged.size()-1);
            if(l>preInterval[1]){
                merged.add(new int[]{l,r});
            }else{
                preInterval[1]=Math.max(preInterval[1],r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}