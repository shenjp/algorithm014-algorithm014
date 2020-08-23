//递归
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        helper(root,1,map);
        return new ArrayList<>(map.values());
    }
    public void helper(Node node,int level,Map<Integer,List<Integer>> map){
        if(node==null) return;
        if(map.containsKey(level)){
            map.get(level).add(node.val);
        }else{
            List<Integer> list=new ArrayList<>();
            list.add(node.val);
            map.put(level,list);
        }
        List<Node> children=node.children;
        if(children!=null&&!children.isEmpty()){
            for(Node subNode:children){
                helper(subNode,level+1,map);
            }
        }
    }
}
//队列迭代
class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}