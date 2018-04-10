class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        result = (0, 0)
        for i in range(len(s)):
            for j in range(1, len(s)):
                if i - j >= 0 and i + j < len(s) and s[i - j] == s[i + j]:
                    if 2 * j > result[1] - result[0]:
                        result = (i - j, i + j)
                else:
                    break
            for j in range(1, len(s)):
                if i - j + 1 >= 0 and i + j < len(s) and s[i - j + 1] == s[i + j]:
                    if 2 * j - 1 > result[1] - result[0]:
                        result = (i - j + 1, i + j)
                else:
                    break
        return s[result[0] : result[1] + 1]

s = Solution()
print(s.longestPalindrome("babad"))