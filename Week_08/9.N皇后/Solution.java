class Solution {
    int n;
    Set<Integer> cols=new HashSet<>();
    Set<Integer> pies=new HashSet<>();
    Set<Integer> nas=new HashSet<>();
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        int[] queens=new int[n];
        Arrays.fill(queens,-1);
        dfs(0,queens);
        return this.ans;
    }

    public void dfs(int row,int[] queens){
        if(row==n){
            ans.add(trans(queens));
            return;
        }
        for(int i=0;i<n;i++){
            if(cols.contains(i)) continue;
            int pie=row+i;
            if(pies.contains(pie)) continue;
            int na=row-i;
            if(nas.contains(na)) continue;
            queens[row]=i;
            cols.add(i);
            pies.add(pie);
            nas.add(na);
            dfs(row+1,queens);
            //回溯
            queens[row]=-1;
            cols.remove(i);
            pies.remove(pie);
            nas.remove(na);
        }
    }

    public List<String> trans(int[] queens){
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] tmp=new char[n];
            Arrays.fill(tmp,'.');
            tmp[queens[i]]='Q';
            ans.add(new String(tmp));
        }
        return ans;
    }
}