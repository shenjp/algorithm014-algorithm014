import java.util.Arrays;

/**
 * @author shenjp
 * @description 排序算法
 * @date 2020/10/11
 */
public class Solution {

    public static void main(String[] args) {
        int[] array={6,5,4,3,2,1};
        Solution solution=new Solution();
        solution.bubbleSort(array);
        System.out.println(Arrays.asList(array));
    }

    /**
     * 冒泡排序
     * @param array
     */
    public void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp=array[j];array[j]=array[j+1];array[j+1]=tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j=i+1;i<array.length;j++){
                if(array[j]<array[minIndex]) minIndex=j;
            }
            int tmp=array[i];array[i]=array[minIndex];array[minIndex]=tmp;
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int preIndex=i-1;
            int curValue=array[i];
            while(preIndex>=0&&array[preIndex]<curValue){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=curValue;
        }
    }

    /**
     * 快速排序
     * @param array
     * @param begin
     * @param end
     */
    public void quickSort(int[] array,int begin,int end){
        if(begin>=end) return;
        int pivot=partition(array,begin,end);
        quickSort(array,begin,pivot-1);
        quickSort(array,pivot+1,end);
    }

    private int partition(int[] array,int begin,int end){
        //小于标杆元素的个数
        int counter=begin;
        //标杆元素
        int pivot=end;
        for(int i=begin;i<=end;i++){
            if(array[i]<array[pivot]){
                int tmp=array[i];array[i]=array[counter];array[counter]=tmp;
                counter++;
            }
        }
        int tmp=array[counter];array[counter]=array[pivot];array[pivot]=tmp;
        return counter;
    }

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public void mergeSort(int[] array,int left,int right){
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    private void merge(int[] array,int left,int mid,int right){
        int[] tmp=new int[right-left+1];
        int i=left,j=mid+1,index=0;
        while(i<=mid&&j<=right) tmp[index++]=array[i]<array[j]?array[i++]:array[j++];
        while(i<=mid) tmp[index++]=array[i++];
        while(j<=right) tmp[index++]=array[j++];
        System.arraycopy(tmp,0,array,left,tmp.length);
    }


}
