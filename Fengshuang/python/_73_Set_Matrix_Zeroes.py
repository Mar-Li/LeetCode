class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        row, col = set(), set()
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    row.add(i)
                    col.add(j)
        for i in row:
            for j in range(len(matrix[i])):
                matrix[i][j] = 0
        for i in col:
            for j in range(len(matrix)):
                matrix[j][i] = 0
        print(matrix)
s = Solution()
s.setZeroes([[1,1,1], [1,0,1],[1,1,0]])