
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        d = {}
        start = 0
        m = 0
        for i, c in enumerate(s):
            if (c in d):
                start = d[c] + 1
                d = {}
                for j in range(start, i + 1):
                    d[s[j]] = j
            else:
                d[c] = i
                m = max(m, i - start + 1)
        return m

s = Solution()
print(s.lengthOfLongestSubstring('abcabcfadsfdasfasdfasfsadfbb'))