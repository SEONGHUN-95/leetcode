class Solution {
    public int maxSubArray(int[] nums) {
        int currentMaxSum = nums[0];
        int maxValue = nums[0];
        for(int i = 1 ; i<nums.length; i++){
             currentMaxSum = Math.max(nums[i]+currentMaxSum, nums[i]);
             maxValue = Math.max(currentMaxSum, maxValue);
        }
        return maxValue;
    }
}