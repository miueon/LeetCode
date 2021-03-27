/*
 * @lc app=leetcode id=986 lang=typescript
 *
 * [986] Interval List Intersections
 */

// @lc code=start
function intervalIntersection(firstList: number[][], secondList: number[][]): number[][] {
    let i = 0
    let j = 0
    const res = []
    while (i < firstList.length && j < secondList.length) {
        const a1 = firstList[i][0]
        const a2 = firstList[i][1]
        const b1 = secondList[j][0]
        const b2 = secondList[j][1]
        if (b2 >= a1 && a2 >= b1) { // it would be more understandable if you
            // take a look as reverse view like in what condition there is no intersections
            //
            res.push([Math.max(a1, b1), Math.max(a2, b2)])
        }
        if (b2 < a2) {
            j += 1;
        } else {
            i +=1
        }
    }
    return res
}
;

// @lc code=end

