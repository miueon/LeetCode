/*
 * @lc app=leetcode id=1011 lang=typescript
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
function shipWithinDays(weights: number[], D: number): number {
    let left = getMax(weights)
    let right = getSum(weights)
    let mid = 0
    while(left <= right){
        mid = left + (right - left) / 2
        if(canFinish(weights, D, mid)){
            right = mid -1
        } else {
            left = mid + 1
        }
    }
    return left
};
function getMax(nums:number[]):number{
    let max = nums[0]
    for (let i of nums) {
        if(i > max){
            max = i
        }
    }
    return max
}

function getSum(n:number[]):number{
    let count = 0
    n.forEach((value) => {
        count += value
    })
    return count
}
function canFinish(weights:number[], D: number, cap:number):Boolean{
    let i = 0
    for (let day = 0; day < weights.length; day++) {
        let maxCap = cap
        while((maxCap -= weights[i])>= 0) {
            i++
            if(i == weights.length) {
                return true
            }
        }       
    }
    return false
}
// @lc code=end

