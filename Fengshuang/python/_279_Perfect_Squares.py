from collections import defaultdict

class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = defaultdict(int)
        squares = []
        s = 1
        while s * s <= n:
            squares.append(s*s)
            s += 1
        l = len(squares)
        for i in range(1, 1 + n):
            if i in squares:
                dp[i] = 1
            else:
                for j in range(l):
                    if squares[j] > i:
                        break
                    if dp[i] == 0 or dp[i] > 1 + dp[i - squares[j]]:
                        dp[i] = 1 + dp[i - squares[j]]
        return dp[n]

s = Solution()
print(s.numSquares(7691))