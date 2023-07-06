<h2><a href="https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a></h2><h3>Medium</h3><hr><div><p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty">subarray</span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>
</div>


# Intuition
배열을 한 번만 훑어서 최대 값의 조합을 도출해내는 것이 필요. 훑는 과정에서 실시간으로 조건이 대입되야 함을 판단.

# Approach
1. 첫번째 원소부터 검색 시작, 지금까지 더해온 것과 다음 원소를 비교하여 더 큰 값을 subArray로 지정한다.
2. 만약 지금까지의 최댓값과 subArray를 비교해서 더 큰 것을 최댓값에 저장.
3. 검색 반복, 최댓값 도출.

# Complexity
- Time complexity:
배열 1회 탐색으로 O(n)

- Space complexity:
상수 개의 변수만 있으므로 O(1)

# Code
```
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
```
