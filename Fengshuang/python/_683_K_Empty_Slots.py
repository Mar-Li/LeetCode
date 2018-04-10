# https://leetcode.com/problems/k-empty-slots/solution/
class Solution(object):
    def kEmptySlots(self, flowers, k):
        """
        :type flowers: List[int]
        :type k: int
        :rtype: int
        """
        length = len(flowers)
        position = [0] * length
        for day, p in enumerate(flowers):
            position[p - 1] = day + 1
        # item in bucket is [start_index, end_index, min_in_middle]
        print(position)
        bucket = [[i, i + k + 1, length] for i in range(length - k - 1)]
        for i in range(length - k - 1):
            for j in range(i + 1, i + k + 1):
                if position[j] < bucket[i][2]:
                    bucket[i][2] = position[j]
        result = length + 1
        for item in bucket:
            if item[2] > position[item[0]] and item[2] > position[item[1]]:
                result = min(result, max(position[item[0]], position[item[1]]))
        if result <= length:
            return result
        return -1

s = Solution()
print(s.kEmptySlots([3,9,2,8,1,6,10,5,4,7], 1))