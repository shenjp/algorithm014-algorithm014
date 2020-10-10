class Solution {
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums,int left,int right){
        if(left>=right) return 0;
        int mid=(left+right)/2;
        int count=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);
        int[] cache=new int[right-left+1];
        int index=0,i1=left,i2=left;
        for(int j=mid+1;j<=right;j++,index++){
            while(i1<=mid&&nums[i1]<=2*(long)nums[j]) i1++;
            while(i2<=mid&&nums[i2]<nums[j]) cache[index++]=nums[i2++];
            cache[index]=nums[j];
            count+=mid-i1+1;
        }
        while(i2<=mid) cache[index++]=nums[i2++];
        System.arraycopy(cache,0,nums,left,cache.length);
        return count;
    }
}