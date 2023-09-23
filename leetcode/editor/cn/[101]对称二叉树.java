//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2551 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode) {
        // 左节点为空 右节点不为空 不对称
        if (leftNode == null && rightNode != null) return false;
            //左节点为不为空 右节点为空 不对称
        else if (leftNode != null && rightNode == null) return false;
            // 左节点为空 右节点为空 对称
        else if (leftNode == null && rightNode == null) return true;
            // 左右节点值不相等 不对称
        else if (leftNode.val != rightNode.val) return false;

        // 比较外侧节点 即左节点左侧，右节点右侧
        boolean outside = check(leftNode.left, rightNode.right);
        // 比较内侧节点 即左节点右侧，右节点左侧
        boolean inside = check(leftNode.right, rightNode.left);

        // 外侧内侧都相同才对称
        return outside && inside;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
