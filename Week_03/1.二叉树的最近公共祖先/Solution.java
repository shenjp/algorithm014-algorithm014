//遍历树构造Map<TreeNode,TreeNode> parentMap,然后从下往上找到最近的公共父节点
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack=new Stack<>();
        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        stack.push(root);
        parentMap.put(root,null);
        while(!stack.isEmpty()){
            TreeNode curNode=stack.pop();
            if(curNode.left!=null) {
                parentMap.put(curNode.left,curNode);
                stack.push(curNode.left);
            }
            if(curNode.right!=null) {
                parentMap.put(curNode.right,curNode);
                stack.push(curNode.right);
            }
            if(parentMap.containsKey(p)&&parentMap.containsKey(q)){
                break;
            }
        }
        List<TreeNode> pParents=new ArrayList<>();
        while(p!=null){
            pParents.add(p);
            p=parentMap.get(p);
        }
        while(!pParents.contains(q)&&q!=null){
            q=parentMap.get(q);
        }
        return q;
    }
}