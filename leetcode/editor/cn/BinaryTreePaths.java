//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1037 👎 0


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();   //存放最终结果
            if (root == null) return res;
            List<Integer> paths = new ArrayList<>(); // 作为结果中的路径
            traversal(root, paths, res);
            return res;
        }

        public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
            // 前序遍历，中
            paths.add(root.val);
            // 遇到叶子结点
            if (root.left == null && root.right == null) {
                // 输出
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                // 记录最后一个节点
                sb.append(paths.get(paths.size() - 1));
                // 收集最后一个路径
                res.add(sb.toString());
                return;
            }

            // 递归和回溯是同时进行，所以要放在同一个括号内
            if (root.left != null) {
                // 左
                traversal(root.left, paths, res);
                // 回溯
                paths.remove(paths.size() - 1);
            }
            if (root.right != null) {
                // 右
                traversal(root.right, paths, res);
                // 回溯
                paths.remove(paths.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}