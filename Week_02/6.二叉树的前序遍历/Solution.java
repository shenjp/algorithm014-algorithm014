//递归
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}
//栈迭代
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.pop();
            if(cur==null) continue;
            result.add(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return result;
    }
}