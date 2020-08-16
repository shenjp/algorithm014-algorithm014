class solution{
    //先反转整个数组，再反转0到k，再反转k到size
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<2) return;
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int tmp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=tmp;
        }
    }
}