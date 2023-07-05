class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i = 1 ; i<nums.length ; i++){
            result[i] = nums[i-1] * result[i-1];
        }

        int num = 1;
        for(int i = nums.length-2 ; i>=0 ; i--){
            num *= nums[i+1];
            result[i] *= num;
        }
        return result;
    }
}