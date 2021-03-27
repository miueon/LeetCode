/*
 * @lc app=leetcode id=56 lang=typescript
 *
 * [56] Merge Intervals
 */

// @lc code=start
function merge(intervals: number[][]): number[][] {
    if (intervals.length === 0) {
        return []
    }
    intervals.sort((a, b) => a[0] - b[0])
    let res:number[][] = []
    res.push(intervals[0])
    for (let i = 1; i < intervals.length; i++) {
        const curr = intervals[i]
        const last = res[res.length -1]
        if (curr[0] <= last[1]) {
            last[1] = Math.max(last[1], curr[1]);
        } else {
            res.push(curr)
        }
    }
    return res
};
// @lc code=end

