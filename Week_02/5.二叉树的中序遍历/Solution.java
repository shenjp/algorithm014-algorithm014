//递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root,List<Integer> list){
        if(root==null) return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}
//栈迭代
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            result.add(cur.val);
            cur=cur.right;
        }
        return result;
    }
}