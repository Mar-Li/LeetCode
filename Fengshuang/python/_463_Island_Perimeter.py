class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        visited = set()

        def getPerimeter(i, j):
            p = 0
            for x, y in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
                if 0 <= x < len(grid) and 0 <= y < len(grid[0]):
                    if (x, y) not in visited and grid[x][y] == 1:
                        visited.add((x, y))
                        p += getPerimeter(x, y)
                    if grid[x][y] == 0:
                        p += 1
                else:
                    p += 1
            return p

        for i, row in enumerate(grid):
            for j, elem in enumerate(row):
                if grid[i][j] == 1:
                    visited.add((i, j))
                    return getPerimeter(i, j)

