class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        t = nums[len(nums) - k:] + nums[:len(nums) - k]
        print(t)
        for i in range(len(nums)):
            nums[i] = t[i]

s = Solution()
s.rotate([1,2,3,4,5,6,7], 3)