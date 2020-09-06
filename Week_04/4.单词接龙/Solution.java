//BFS：参考最小基因变化(Set contains时间复杂度O(1)，故把List转为Set)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        Set<String> wordSet=new HashSet<>(wordList);
        int length=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curStr=queue.poll();
                //terminate
                if(curStr.equals(endWord)){
                    return length;
                }
                //current logic
                char[] curArr=curStr.toCharArray();
                for(int j=0;j<curArr.length;j++){
                    char oldChar=curArr[j];
                    for(char k='a';k<='z';k++){
                        curArr[j]=k;
                        String newCurStr=new String(curArr);
                        if(!visited.contains(newCurStr)&&wordSet.contains(newCurStr)){
                            queue.offer(newCurStr);
                            visited.add(newCurStr);
                        }
                    }
                    curArr[j]=oldChar;
                }
            }
            length++;
        }
        return 0;
    }
}