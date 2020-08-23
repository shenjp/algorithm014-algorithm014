//Map+将字符串转为int[26]
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int[] letters=new int[26];
            for(int k=0;k<s.length();k++){
                letters[s.charAt(k)-'a']+=1;
            }
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<letters.length;k++){
                sb.append(letters[k]);
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(s);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(sb.toString(),list);
            }
        }
        return new ArrayList<>(map.values());
    }

}