//某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤： 
//
// 
// 设定一个正整数目标值 target 
// 将 password 前 target 个字符按原顺序移动至字符串末尾 
// 
//
// 请返回更新后的密码字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: password = "s3cur1tyC0d3", target = 4
//输出: "r1tyC0d3s3cu"
// 
//
// 示例 2： 
//
// 
//输入: password = "lrloseumgh", target = 6
//输出: "umghlrlose"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target < password.length <= 10000 
// 
//
// 
//
// Related Topics 数学 双指针 字符串 👍 454 👎 0


public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String s = solution.reverseLeftWords("s3cur1tyC0d3", 4);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder sb = new StringBuilder(s);
            reverseString(sb, 0, n - 1);
            reverseString(sb, n, len - 1);
            return sb.reverse().toString();
        }

        public void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}