//递归思路：中序序列按照前序序列的第一个元素拆分为左右子树
class Solution {
    private Map<Integer,Integer> inOrderMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode helper(int[] preOrder,int[] inOrder,int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft>preRight) return null;
        int inRoot=inOrderMap.get(preOrder[preLeft]);
        int leftSize=inRoot-inLeft;
        TreeNode root=new TreeNode(preOrder[preLeft]);
        root.left=helper(preOrder,inOrder,preLeft+1,preLeft+leftSize,inLeft,inRoot-1);
        root.right=helper(preOrder,inOrder,preLeft+leftSize+1,preRight,inRoot+1,inRight);
        return root;
    }
}