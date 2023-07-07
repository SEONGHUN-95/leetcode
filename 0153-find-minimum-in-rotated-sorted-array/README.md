<h2><a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a></h2><h3>Medium</h3><hr><div><p>Suppose an array of length <code>n</code> sorted in ascending order is <strong>rotated</strong> between <code>1</code> and <code>n</code> times. For example, the array <code>nums = [0,1,2,4,5,6,7]</code> might become:</p>

<ul>
	<li><code>[4,5,6,7,0,1,2]</code> if it was rotated <code>4</code> times.</li>
	<li><code>[0,1,2,4,5,6,7]</code> if it was rotated <code>7</code> times.</li>
</ul>

<p>Notice that <strong>rotating</strong> an array <code>[a[0], a[1], a[2], ..., a[n-1]]</code> 1 time results in the array <code>[a[n-1], a[0], a[1], a[2], ..., a[n-2]]</code>.</p>

<p>Given the sorted rotated array <code>nums</code> of <strong>unique</strong> elements, return <em>the minimum element of this array</em>.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(log n) time.</code></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,5,1,2]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The original array was [1,2,3,4,5] rotated 3 times.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [11,13,15,17]
<strong>Output:</strong> 11
<strong>Explanation:</strong> The original array was [11,13,15,17] and it was rotated 4 times. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5000</code></li>
	<li><code>-5000 &lt;= nums[i] &lt;= 5000</code></li>
	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is sorted and rotated between <code>1</code> and <code>n</code> times.</li>
</ul>
</div>

# Intuition
이진 탐색하듯 값을 찾아가도록 설계해야함을 확인하였다.

# Approach
1. 배열의 중간값 선택, 가장 끝값과 비교하여 중간값이 더 크다면 중간값과 끝 값 사이에 가장 작은 값이 있음을 알 수 있다.
2. 그렇지 않다면 처음과 중간값 사이에 가장 작은 값이 있음을 알 수 있다.
3. 이러한 조건 하에 배열을 절반씩 줄이면서 탐색하면 중간값과 끝 값이 같은, 최솟값만 남은 배열이 남게 된다.

# Complexity
- Time complexity: 이진 검색하며 값을 절반씩 줄여나가기 때문에 O(logn)

- Space complexity: 추가 변수 외 새로운 메모리 할당이 없으니 O(1)

# Code
```
class Solution {
    public int findMin(int[] nums) {
        return findMinRecursive(nums, 0, nums.length -1);
    }
    private int findMinRecursive(int[] nums, int left, int right){
        int mid = (left+right)/2;
        
        if (nums[mid]>nums[right]) {
            return findMinRecursive(nums, mid+1, right);
        }
        
        else if(nums[mid]<nums[right]) {
            return findMinRecursive(nums, left, mid);
        }
        
        return nums[left];
    }
}
```
