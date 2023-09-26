//假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：path = "a.aef.qerf.bb"
//
//输出："a aef qerf bb"
//
// 
//
// 
//
// 限制： 
//
// 0 <= path.length <= 10000 
//
// Related Topics 字符串 👍 564 👎 0


public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            //扩充空间，空格数量2倍
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    str.append("  ");
                }
            }
            //若是没有空格直接返回
            if (str.length() == 0) {
                return s;
            }
            //有空格情况 定义两个指针
            int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
            s += str.toString();
            int right = s.length() - 1;//右指针：指向扩展字符串的最后一个位置
            char[] chars = s.toCharArray();
            while (left >= 0) {
                if (chars[left] == ' ') {
                    chars[right--] = '0';
                    chars[right--] = '2';
                    chars[right] = '%';
                } else {
                    chars[right] = chars[left];
                }
                left--;
                right--;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}