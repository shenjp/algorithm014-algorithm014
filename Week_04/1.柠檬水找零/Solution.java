//贪心算法：如果面值为10，则5的剩余数量至少为1；如果面值为20，则10和5至少各为1或者5数量至少为3
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum=0;
        int tenNum=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) fiveNum++;
            if(bills[i]==10){
                if(fiveNum<1) return false;
                fiveNum--;
                tenNum++;
            }
            if(bills[i]==20){
                if(fiveNum>0&&tenNum>0){
                    fiveNum--;
                    tenNum--;
                }else{
                    if(fiveNum<3) return false;
                    fiveNum=fiveNum-3;
                }
            }
        }
        return true;
    }
}