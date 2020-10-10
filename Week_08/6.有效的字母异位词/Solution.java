class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] countArr=new int[26];
        for(int i=0;i<s.length();i++) countArr[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) countArr[t.charAt(i)-'a']--;
        for(int i=0;i<countArr.length;i++){
            if(countArr[i]>0) return false;
        }
        return true;
    }
}