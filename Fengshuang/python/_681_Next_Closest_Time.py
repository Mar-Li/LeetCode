# https://leetcode.com/problems/next-closest-time/solution/
class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        nums = sorted(set([int(time[i]) for i in [0, 1, 3, 4]]))
        print(nums)
        largest = max(nums)
        smallest = min(nums)
        # 4th digit
        if int(time[4]) < largest:
            for n in nums:
                if n > int(time[4]):
                    return time[:4] + str(n)

        # 3th digit
        for n in nums:
            if int(time[3]) < n <= 5:
                return time[:3] + str(n) + str(smallest)
        
        # 2nd digit
        if int(time[0]) < 2:
            if int(time[1]) < largest:
                for n in nums:
                    if n > int(time[1]):
                        return '%d%d:%d%d' % (int(time[0]), n, smallest, smallest)
        else:
            for n in nums:
                if int(time[1]) < n < 4:
                    return '%d%d:%d%d' % (int(time[0]), n, smallest, smallest)
        
        # 1st digit
        if int(time[1]) < 4:
            for n in nums:
                if int(time[3]) < n <= 2:
                    return '%d%d:%d%d' % (n, smallest, smallest, smallest)
        else:
            for n in nums:
                if int(time[3]) < n < 2:
                    return '%d%d:%d%d' % (n, smallest, smallest, smallest)
        return '%d%d:%d%d' % ((smallest,) * 4)

