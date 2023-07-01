# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
이중 for문 대신 한 번에 해결할 방법 모색
# Approach
<!-- Describe your approach to solving the problem. -->
1. 충분히 큰 값을 최초 최솟값, 가장 수익이 적은 상황인 0을 최초 수익으로 설정.
2. 탐색 시작
3. 현재 금액에서 현재까지의 최솟값을 뺀 수익이 최대 수익(max_profit)보다 크면 최대 수익을 갈아치움.
    - 최초 최솟값을 충분히 큰 값, 최초 최대 수익을 0으로 뒀으니 수익을 내어 판매할 수 있는 상황이 없으면 최종 최대 수익은 0이 된다.

# Complexity
- Time complexity: 한 번의 검색이므로 O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: 두 변수 외 추가 공간을 할당하지 않으니 O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maxProfit(int[] prices) {
        int min = 10000;
        int max_profit = 0;
        for(int i = 0; i < prices.length ; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            if(prices[i]-min>max_profit){
                max_profit = prices[i]-min;
            }
        }
        return max_profit;
    }
}
```
