class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        cnt = 0
        visited = set()
        l = []
        for i, row in enumerate(grid):
            for j, elem in enumerate(grid[i]):
                if (i, j) in visited:
                    continue
                if elem == '1':
                    visited.add((i, j))
                    cnt += 1
                    l.append((i, j))
                    while l:
                        node = l.pop()
                        _i = node[0]
                        _j = node[1]
                        try:
                            if grid[_i][_j+1] == '1' and (_i, _j + 1) not in visited:
                                l.append((_i, _j + 1))
                                visited.add((_i, _j + 1))
                        except:
                            pass
                        try:
                            if _j != 0 and grid[_i][_j-1] == '1' and (_i, _j - 1) not in visited:
                                l.append((_i, _j - 1))
                                visited.add((_i, _j - 1))
                        except:
                            pass
                        try:
                            if grid[_i+1][_j] == '1' and (_i + 1, _j) not in visited:
                                l.append((_i + 1, _j))
                                visited.add((_i + 1, _j))
                        except:
                            pass
                        try:
                            if _i != 0 and grid[_i-1][_j] == '1' and (_i - 1, _j) not in visited:
                                l.append((_i - 1, _j))
                                visited.add((_i - 1, _j))
                        except:
                            pass
        return cnt

s = Solution()
print(s.numIslands(["00100100000000110100","01000011000100110000","10110000010001011110","11000000001001111111","00000100011110100000","01110001010100101100","00000000111001100000","01100000101101100100","00111001000000011101","11000101000110010110","00000010110010111101","00110010100100100101","01000001000000111000","00101001101110011001","10101010000000100110","10111010000001000011","10000100000010000011","00000010001010110101","10010000001000001111","00011000000001000100"]))