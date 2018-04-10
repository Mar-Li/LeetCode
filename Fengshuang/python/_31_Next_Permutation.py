class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            _i = len(nums) - i - 1
            if _i == 0:
                nums.reverse()
                return
            else:
                if nums[_i] > nums[_i - 1]:
                    for j in range(i + 1):
                        index = len(nums) - j - 1
                        if nums[_i - 1] < nums[index]:
                            temp = sorted(nums[_i - 1:index] + nums[index + 1:])
                            nums[_i - 1] = nums[index]
                            nums[_i:] = temp
                            return

s = Solution()
a = [1,1,5,2,1]
print(a)
s.nextPermutation(a)
print(a)
