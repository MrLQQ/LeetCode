//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 661 👎 0


public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int leftValue = sumOfLeftLeaves(root.left); // 左
            int rightValue = sumOfLeftLeaves(root.right); // 右
            int midValue = 0;
            // 左子树就是一个左叶子的情况
            if (root.left != null && root.left.left == null && root.left.right == null) {
                midValue = root.left.val;
            }
            return midValue + leftValue + rightValue; // 中
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}