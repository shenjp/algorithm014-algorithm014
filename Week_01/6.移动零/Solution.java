class solution{
    //双指针
    public void moveZeroes(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int tmp=nums[i];
                nums[i]=nums[k];
                nums[k]=tmp;
                k++;
            }
        }
    }
}