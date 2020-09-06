DFS：Depth First Search，深度优先搜索，尽可能深的搜索。比如前、中、后序遍历。
```
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()<=level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```
BFS：Breadth First Search，广度优先搜索，按照层来搜索。比如层次遍历(层序遍历也可用DFS实现)。
```
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```
贪心算法
贪心算法是一种在每一步中都采取当前状态下最优的选择，从而希望结果是全局最优的。
由于贪心算法的高效性以及所求的的答案接近于最优结果，因此可以作为辅助算法或解决一些要求结果不是特别准确的问题。如：最小生成树、求哈弗曼编码
贪心是局部最优，且不能回退；动态规划会保存当前结果，全局最优，且能回退

二分查找
二分查找的前提：1）单调性 2）存在上下界 3）能够通过索引访问
```
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```