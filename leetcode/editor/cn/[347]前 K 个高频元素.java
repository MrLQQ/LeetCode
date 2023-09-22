//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1692 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 优先级队列 小顶堆
        PriorityQueue<int[]> pd = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 答案数组
        int[] res = new int[k];
        // 统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 将数字及其对应的次数放如优先级队列
        for (var x : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();
            pd.offer(tmp);
            // 因为是小顶堆,堆顶是最小的，如果插入元素的数量大于K，就删除堆顶元素
            // 保证剩下的K个元素都是出现次数最多的
            if (pd.size() > k) pd.poll();
        }
        while (!pd.isEmpty()) {
            res[--k] = pd.poll()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
