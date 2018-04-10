class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        for i in range(2 ** len(nums)):
            temp = []
            for j in range(len(nums)):
                if (i >> j) & 1 == 1:
                    temp.append(nums[j])
            result.append(temp)
        return result

s = Solution()
print(s.subsets([3,4,5,6]))