学习笔记
位运算
运算符 示例
&按位与 9&5=1001&0101=0001=1
|按位或 9|5=1001|0101=1101=13
^按位异或 相同为0，相异为19^5=1001^0101=1100=12
~求反 ~1001=0110
<<左移 x<<1相当于x*=2
>>右移 x>>1相当于x/=2
>>>无符号右移 右移之后无论正数还是负数，左边都是补0对于正数，>>>和>>没区别对于负数，需要补码左补0，然后再转原码
1）计算机中数据分为有符号数和无符号数，对于有符号数，计算机规定用最高位来表示符号。“0”表示正数，“1”表示负数。计算机中带符号的整数都是采用二进制的补码进行存储。
2）Java没有无符号类型，都是有符号类型的数据类型
3）原码： 计算机中将一个数字转换为二进制，并在其最高位加上符号的一种表示方法
       反码： 根据表示规定，正数的反码就是其本身，而负数的反码是符号位不变，其余各位取反
       补码： 根据表示规定，正数的补码就是其本身，而负数的补码是其反码+1
4）x=x&(x-1)：清零最低位的1
      x&-x：得到最低位的1

布隆过滤器

布隆过滤器可以快速的判断一个元素是否存在，有一定的误判率。应用场景：垃圾邮件、评论过滤、Redis缓存
LRU Cache
class LRUCache {
    class Entry{
        int key;
        int value;
        Entry prev;
        Entry next;
        public Entry(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Entry> cache=new HashMap<>();
    Entry head;
    Entry tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Entry(-1,-1);
        tail=new Entry(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Entry cur=cache.get(key);
            moveToHead(cur);
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Entry cur=cache.get(key);
            cur.value=value;
            moveToHead(cur);
        }else{
            if(cache.size()>=capacity){
                cache.remove(tail.prev.key);
                removeLast();
            }
            Entry cur=new Entry(key,value);
            addToHead(cur);
            cache.put(key,cur);
        }
    }

    private void addToHead(Entry cur){
        cur.prev=head;
        cur.next=head.next;
        head.next=cur;
        cur.next.prev=cur;
    }

    private void removeLast(){
        tail.prev.prev.next=tail;
        tail.prev=tail.prev.prev;
    }

    private void moveToHead(Entry cur){
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        cur.prev=head;
        cur.next=head.next;
        head.next=cur;
        cur.next.prev=cur;
    }
}

排序算法(参考)




选择排序：每次找到最小值，然后放到待排序数组的起始位置
public void selectSort(int[] array){
    for(int i=0;i<array.length-1;i++){
        int minIndex=i;
        for(int j=i+1;j<array.length;j++){
            if(array[j]<array[minIndex]) minIndex=j;
        }
        int tmp=array[i];
        array[i]=array[minIndex];
        array[minIndex]=array[i];
    }
}

插入排序：从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
public void insertSort(int[] array){
    for(int i=1;i<array.length;i++){
        int preIndex=i-1;
        int curValue=array[i];
        while(preIndex>=0&&array[preIndex]>curValue){
            array[preIndex+1]=array[preIndex];
            preIndex--;
        }
        array[preIndex+1]=curValue;
    }
}

冒泡排序：嵌套循环，每次查看相邻元素如果逆序，则交换
public void bubbleSort(int[] array){
    for(int i=0;i<array.length-1;i++){
        for(int j=0;j<array.length-1-i;j++){
            if(array[j]>array[j+1]){
                int tmp=array[j];array[j]=array[j+1];array[j+1]=tmp;
            }
        }
    }
}

快速排序：数组取标杆pivot，将小元素放在pivot左边，大元素放在pivot右边，然后依次对左边和右边子数组继续快排，以达到整个数组有序
public void quickSort(int[] array,int begin,int end){
    if(begin>=end) return;
    int pivot=partition(array,begin,end);
    quickSort(array,begin,pivot);
    quickSort(array,pivot,end);
}

public int partition(int[] array,int begin,int end){
    //pivot:标杆位置
    int pivot=end;
    //counter:小于标杆元素的个数
    int counter=begin;
    for(int i=begin;i<=end;i++){
        if(array[i]<array[pivot]){
            int tmp=array[counter];array[counter]=array[i];array[i]=tmp;
            counter++;
        }
    }
    int tmp=array[counter];array[counter]=array[pivot];array[pivot]=tmp;
    return counter;
}

归并排序:将长度为n的序列分成两个长度为n/2的子序列，然后对两个子序列分别采用归并排序，最后将两个排序好的子序列合并成一个最终的排序序列
public void mergeSort(int[] array,int left,int right){
    if(left>=right) return;
    int mid=(left+right)/2;
    mergeSort(array,left,mid);
    mergeSort(array,mid+1,right);
    merge(array,left,mid,right);
}

public void merge(int[] array,int left,int mid,int right){
    int[] tmp=new int[right-left+1];
    int i=left,j=mid+1,k=0;
    while(i<=mid&&j<=right) tmp[k++]=array[i]<array[j]?array[i++]:array[j++];
    while(i<=mid) tmp[k++]=array[i++];
    while(j<=right) tmp[k++]=array[j++];
    System.arraycopy(tmp,0,array,left,tmp.length);
}

堆排序：将数组元素建立小顶堆，依次取出堆顶元素并删除。如PriorityQueue小顶堆。
实战
题号 题目 难易程度 解题思路
191 位1的个数 简单 x&(x-1):将最低位的1归0
231 2的幂 简单 看二进制是否只有一个1return n>0&&(n&(n-1))==0
190 颠倒二进制位 简单 ans+=(n&1)<<index
1122 数组的相对排序 简单 计数排序
242 有效的字母异位词 简单 计数排序
146 LRU Cache 中等 Map+双向链表
56 合并区间 中等 先将区间按照左边界升序，之后合并的时候如果当前区间的左边界大于最后一个区间的有边界直接添加到集合中；否则将最后一个区间的右边界更新为二者区间的最大右边界
51 N皇后 困难 DFS+回溯
493 翻转对 困难 归并排序
