//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
//
// Related Topics 树 广度优先搜索 👍 407 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // 创建结果列表
        List<List<Integer>> res = new ArrayList<>();
        // 创建队列
        Deque<Node> queue = new LinkedList<>();
        // 判断初始节点是否为空
        if (root == null) return res;

        // 初始节点不为空，放入队列
        queue.offer(root);

        // 判断队列是否为空
        while (!queue.isEmpty()) {
            // 当前队列长度，即二叉树当前层的节点个数
            int levelSize = queue.size();
            // 创建列表，用存放每一层的元素
            List<Integer> levelList = new ArrayList<>();

            // 循环当前层的每一个节点
            for (int i = 0; i < levelSize; i++) {
                // 去除队列中的节点元素
                Node node = queue.poll();
                // 将当前节点值存放到列表
                levelList.add(node.val);

                // 获取当前节点的子节点
                List<Node> children = node.children;
                // 判断子节点是否为空
                if (children == null || children.size() == 0) {
                    continue;
                }
                // 子节点不为空，将子节点的列表添加到队列中
                for (Node chil : children) {
                    if (chil != null) {
                        queue.offer(chil);
                    }
                }
            }
            // 二叉树的当前层遍历完，将当前层节点列表添加到结果中
            res.add(levelList);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
