class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dp = {}
        def _wordBreak(s, start, end, wordDict):
            if (start, end) in dp:
                return dp[(start, end)]
            _s = s[start:end]
            if _s in wordDict:
                dp[(start, end)] = True
                return True
            else:
                for i in range(1, end - start):
                    if _wordBreak(s, start, start + i, wordDict) and _wordBreak(s, start + i, end, wordDict):
                        dp[(start, end)] = True
                        return True
                else:
                    dp[(start, end)] = False
                    return False
        return _wordBreak(s, 0, len(s), set(wordDict))

s = Solution()
print(s.wordBreak("leetcode", ["leet","code"]))