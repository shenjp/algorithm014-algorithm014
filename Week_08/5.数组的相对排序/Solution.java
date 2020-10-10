class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countArr=new int[1001];
        for(int i=0;i<arr1.length;i++){
            countArr[arr1[i]]++;
        }
        //先排arr2
        int index=0;
        for(int i=0;i<arr2.length;i++){
            while(countArr[arr2[i]]>0){
                arr1[index++]=arr2[i];
                countArr[arr2[i]]--;
            }
        }
        //在排arr1剩下的
        for(int i=0;i<countArr.length;i++){
            while(countArr[i]>0){
                arr1[index++]=i;
                countArr[i]--;
            }
        }
        return arr1;
    }
}