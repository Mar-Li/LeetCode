class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i, num in enumerate(nums):
            if i > 0:
                if i % 2 == 1:
                    if num < nums[i - 1]:
                        nums[i - 1], nums[i] = nums[i], nums[i - 1]
                else:
                    if num > nums[i - 1]:
                        nums[i - 1], nums[i] = nums[i], nums[i - 1]


s = Solution()
s.wiggleSort([3, 5, 2, 1, 6, 4])