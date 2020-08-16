//1.按列求出左右最大值，然后累加该列的面积。O(n^2)
class solution{
    public int trap(int[] height) {
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int maxLeft=getMax(height,0,i);
            int maxRight=getMax(height,i+1,height.length);
            int minHeight=Math.min(maxLeft,maxRight);
            if(minHeight>height[i]){
                sum+=minHeight-height[i];
            }
        }
        return sum;
    }

    public int getMax(int[] height,int left,int right){
        int max=0;
        for(int i=left;i<right;i++){
            max=Math.max(max,height[i]);
        }
        return max;
    }
}

//2.单调递减栈。O(n)
class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for(int i=0;i<height.length;i++){
            while(!stack.empty()&&height[stack.peek()]<height[i]){
                int tmpHeight=height[stack.pop()];
                if(!stack.empty()){
                    int distance=i-stack.peek()-1;
                    int minHeight=Math.min(height[i],height[stack.peek()])-tmpHeight;
                    sum+=distance*minHeight;
                }
            }
            stack.push(i);
        }
        return sum;

    }
}

//3.双指针。O(n)
class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int sum=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    sum+=(leftMax-height[left]);
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    sum+=(rightMax-height[right]);
                }
                right--;
            }
        }
        return sum;

    }
}


