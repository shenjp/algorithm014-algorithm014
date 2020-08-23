学习笔记
#### 数据结构

- 散列表
- Set集合

- 树

  定义：没有回路的连通无向图，有如下特性：

  1）任意两个节点有且只有一条路径

  2）如果有n个节点，那有n-1条边

  3）树中有且仅有一个没有前驱的节点称为根节点

- 二叉树

  性质：

  1）第k层最多有2^(k-1)个节点

  2）深度为k层的树最多有2^k-1个节点

- 完全二叉树

  定义：除最后一层外，其它层节点数都达到最大，且最后一层从左向右依次分布。

- 满二叉树

  定义：所有叶子节点都有相同的高度

- 二叉搜索树(Binary Search Tree)

  定义：任何节点的左子树值小于当前值，右子树的值大于当前值

- 图(可用邻接矩阵来表示)

  无向无权图、有向无权图、无权有向图、有权有向图。

#### 算法

- DFS(Depth First Search深度优先检索)
  按照树的深度遍历
- BFS(Breadth First Search广度优先检索)
  按照树的层次遍历

####实战

| #            | 题目                                                         | 难度 | 关键词              | 已过遍数 |
| ------------ | ------------------------------------------------------------ | ---- | ------------------- | -------- |
| 242          | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) | 简单 | 将字符串转为int[26] | 2        |
| 49           | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | 中等 | 将字符串转为int[26] | 2        |
| 1            | [两数之和](https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/) | 简单 | HashMap             | 2        |
| 94           | [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | 中等 | 递归、栈迭代        | 2        |
| 144          | [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) | 中等 | 递归、栈迭代        | 2        |
| 590          | [N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) | 简单 | 递归、栈迭代        | 2        |
| 589          | [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/) | 简单 | 递归、栈迭代        | 2        |
| 429          | [N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/) | 中等 | 递归、队列迭代      | 2        |
| 剑指Offer 40 | [最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/) | 简单 | 排序、小顶堆        | 2        |
| 239          | [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/) | 困难 | 双端队列、大顶堆    | 2        |
| 剑指Offer 49 | [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)      | 中等 |                     |          |
| 347          | [前K个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) | 中等 | Map+大顶堆          | 1        |
| 200          | [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 中等 |                     |          |

