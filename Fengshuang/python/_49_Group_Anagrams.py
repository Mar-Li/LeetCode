class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        temp = {}
        for s in strs:
            key = tuple(sorted(s))
            if key in temp:
                temp[key].append(s)
            else:
                temp[key] = [s]
        return [x for x in temp.values()]

s = Solution()
print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))