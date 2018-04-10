class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []
        start = 0
        result = []
        for i, num in enumerate(nums):
            if i - start != num - nums[start]:
                if start == i - 1:
                    result.append(str(nums[start]))
                else:
                    result.append('%d->%d' % (nums[start], nums[i - 1]))
                start = i
        if start == len(nums) - 1:
            result.append(str(nums[start]))
        else:
            result.append('%d->%d' % (nums[start], nums[-1]))
        return result

s = Solution()
print(s.summaryRanges([0,2,3,4,6,8,9]))