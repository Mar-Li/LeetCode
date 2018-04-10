import re

class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        lines = input.split('\n')
        stack = []
        maxi = 0
        for line in lines:
            m = re.search(r'^(\t*)([^\t]*)$', line)
            level = 0
            if m.group(1):
                level = len(m.group(1))
            length = len(m.group(2))
            while level < len(stack):
                stack.pop()
            if level == len(stack):
                if not stack:
                    if '.' in line:
                        maxi = max(length, maxi)
                    else:
                        length += 1
                    stack.append(length)
                else:
                    if '.' in line:
                        maxi = max(length + stack[-1], maxi)
                    else:
                        length += 1
                    stack.append(length + stack[-1])
        return maxi

s = Solution()
print(s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))