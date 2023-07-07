class Solution {
    public int findMin(int[] nums) {
        return findMinRecursive(nums, 0, nums.length -1);
    }
    private int findMinRecursive(int[] nums, int left, int right){
        int mid = (left+right)/2;
        
//         if (left == right){
//             return nums[left];
//         }
        
        if (nums[mid]>nums[right]) {
            return findMinRecursive(nums, mid+1, right);
        }
        
        else if(nums[mid]<nums[right]) {
            return findMinRecursive(nums, left, mid);
        }
        
        return nums[left];
    }
}