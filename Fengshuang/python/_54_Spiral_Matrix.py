class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return []
        result = []
        direction = 'r'
        visited = set()
        width, height = len(matrix[0]), len(matrix)
        x, y = 0, 0
        result.append(matrix[x][y])
        visited.add((x, y))
        while True:
            if direction == 'r':
                if y + 1 >= width or (x, y + 1) in visited:
                    direction = 'd'
                    x += 1
                else:
                    y += 1
            elif direction == 'd':
                if x + 1 >= height or (x + 1, y) in visited:
                    direction = 'l'
                    y -= 1
                else:
                    x += 1
            elif direction == 'l':
                if y - 1 < 0 or (x, y - 1) in visited:
                    direction = 'u'
                    x -= 1
                else:
                    y -= 1
            elif direction == 'u':
                if x - 1 < 0 or (x - 1, y) in visited:
                    direction = 'r'
                    y += 1
                else:
                    x -= 1
            if (x, y) in visited or x < 0 or x >= height or y < 0 or y >= width:
                return result
            else:
                result.append(matrix[x][y])
                visited.add((x, y))

s = Solution()
print(s.spiralOrder([
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]))
