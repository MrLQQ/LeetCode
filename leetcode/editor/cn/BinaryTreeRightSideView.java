//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 958 👎 0


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        public List<List<Integer>> res = new ArrayList<List<Integer>>();

        public List<Integer> rightSideView(TreeNode root) {
            checkFun(root, 0);
            // 将res中每一层的最后一个元素提取出来作为结果
            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < res.size(); i++) {
                result.add(res.get(i).get(res.get(i).size() - 1));
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

}