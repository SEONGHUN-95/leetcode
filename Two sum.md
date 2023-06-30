# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
이중 포문으로 해결하면 O(n2)으로는 풀 수 있지만 다른 방법이 필요하겠다고 느낌.
# Approach
<!-- Describe your approach to solving the problem. -->
1. key와 value 모두 int 값을 갖는 HashMap을 선언한다.
2. nums를 탐색하며 현재 값의 보수가 존재하는지 확인한다.
    1. 존재하지 않는다면 보수와 그 인덱스 값을 map에 저장한다.
    2. 존재한다면 해당 보수의 인덱스 값과 현재 인덱스 값을 갖는 int 배열을 반환한다.
* 문제에서는 무조건 정답이 존재하고 한 개의 쌍만을 갖는다고 했으니 다른 조건 없이 코드를 작성한다.

# Complexity
- Time complexity: O(n)
   - 최대 nums의 원소 개수만큼 탐색하니 O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
    - n 개수만큼 map을 생성하므로 O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
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
```
