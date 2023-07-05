<h2><a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a></h2><h3>Medium</h3><hr><div><p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

<p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [24,12,8,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
<strong>Output:</strong> [0,0,9,0,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)&nbsp;</code>extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>
</div>


# Intuition
나누기 연산이나 O(1)를 초과하는 공간복잡도를 허용치 않고, 시간복잡도 O(n)으로 배열의 곱을 구하는 방법을 고민하였다.

# Approach
1. 배열의 앞에서 뒤로 갈 때에는 nums 배열에서 추출한 값으로 result 배열을 만들어 나갔다. result[i+1] = nums[i] * result[i]
2. 배열의 뒤에서 앞으로 갈 때에는 추가 배열 생성 없이 변수 하나만 선언하여 nums 값을 누적하여 저장하였다. num = num * nums[i]
3. 동시에 최종 result 값을 구하기 위해 result 배열과 num 값을 곱하여 답을 도출해냈다. result[i] *= num
   
# Complexity
- Time complexity: 배열을 두 번 검색하므로 2N, -> O(N)

- Space complexity: 정답 배열 제외 변수만 선택하였으므로 O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
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
```
