class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        a, b = 1, 1
        result = []
        for i in range(rowIndex + 1):
            result.append(int(a / b))
            a *= rowIndex - i
            b *= i + 1
        return result

s = Solution()
print(s.getRow(0))