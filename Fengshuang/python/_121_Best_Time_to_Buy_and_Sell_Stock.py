class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        profit = 0
        mi = prices[0]
        for i in prices:
            if i < mi:
                mi = i
            else:
                if i - mi > profit:
                    profit = i - mi
        return profit

s = Solution()
print(s.maxProfit([7, 6, 4, 3, 1]))