class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return
        if len(nums) == 1:
            return 0
        left_le = None
        for i, num in enumerate(nums):
            if i == 0:
                if nums[1] < nums[0]:
                    return 0
                elif nums[1] == nums[0]:
                    left_le = True
                else:
                    left_le = False
            elif i == len(nums) - 1:
                if left_le:
                    return
                else:
                    return i
            else:
                if left_le:
                    left_le = nums[i] >= nums[i+1]
                    continue
                else:
                    if nums[i] > nums[i+1]:
                        return i
                    elif nums[i] == nums[i+1]:
                        left_le = True
                    else:
                        left_le = False
