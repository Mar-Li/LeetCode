class Solution:
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        from collections import defaultdict
        paths = defaultdict(int)
        paths[(0, 0)] = 1
        for h in range(n):
            for w in range(m):
                if h == 0 and w == 0:
                    continue
                paths[(w, h)] = paths[(w-1, h)] + paths[(w, h-1)]
        return paths[(m-1, n-1)]

s = Solution()
s.uniquePaths(4,10)