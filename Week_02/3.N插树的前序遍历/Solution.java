//递归
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    public void helper(Node node,List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        List<Node> children=node.children;
        if(children!=null&&!children.isEmpty()){
            for(Node subNode:children){
                helper(subNode,list);
            }
        }
    }
}
//栈迭代
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}