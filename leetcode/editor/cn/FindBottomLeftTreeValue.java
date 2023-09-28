//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 533 👎 0


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int maxDeep = Integer.MIN_VALUE;
        int res = 0;

        public int findBottomLeftValue(TreeNode root) {
            // 递归
            // func(root, 0);
            // 层序遍历
            level(root);
            return res;
        }

        // 层序遍历
        public void level(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            if (root == null) return;
            que.offer(root);
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = que.poll();
                    if (i == 0) res = poll.val;
                    if (poll.left != null) que.offer(poll.left);
                    if (poll.right != null) que.offer(poll.right);
                }
            }
            return;
        }


        // 递归方法
        public void func(TreeNode root, Integer deep) {
            if (root.left == null && root.right == null) {
                if (deep > maxDeep) {
                    maxDeep = deep;
                    res = root.val;
                }
                return;
            }

            if (root.left != null) {
                deep++;
                func(root.left, deep);
                deep--;
            }

            if (root.right != null) {
                deep++;
                func(root.right, deep);
                deep--;
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}