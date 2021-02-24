/*
 * @lc app=leetcode id=704 lang=kotlin
 *
 * [704] Binary Search
 */
//leetcode submit region begin(Prohibit modification and deletion)
// @lc code=start
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size -1
        var mid = 0
        while (left <= right) {
            mid = left + (right - left) /2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid  -1
            }
        }
        return -1
    }
}
// @lc code=end
//leetcode submit region end(Prohibit modification and deletion)
