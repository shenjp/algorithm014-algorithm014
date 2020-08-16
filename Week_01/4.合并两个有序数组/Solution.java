class solution{
    //从后向前遍历，将大的元素放在nums1尾部
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int index=m+n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>nums2[index2]){
                nums1[index--]=nums1[index1--];
            }else{
                nums1[index--]=nums2[index2--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, index2+1);
    }
}