class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (cash.containsKey(nums[i])) {
                    return new int[]{cash.get(nums[i]), i};
                    }
                    cash.put(target - nums[i], i);
                }
                return new int[]{};
            }
        }