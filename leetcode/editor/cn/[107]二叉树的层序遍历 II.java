//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 727 👎 0


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
    public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        checkFun(root, 0);
        // 反转res
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }
        return result;
    }

    // DFS
    public void checkFun(TreeNode root, Integer deep) {
        if (root == null) return;

        deep++;

        if (res.size() < deep) {
            res.add(new ArrayList<Integer>());
        }
        res.get(deep - 1).add(root.val);
        checkFun(root.left, deep);
        checkFun(root.right, deep);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
