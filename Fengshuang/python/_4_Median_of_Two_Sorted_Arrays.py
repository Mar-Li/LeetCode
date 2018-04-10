class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l1 = len(nums1)
        l2 = len(nums2)
        i1 = 0
        i2 = 0
        m1 = 0
        m2 = 0
        odd = ((l1 + l2) % 2) == 1
        even = ((l1 + l2) % 2) == 0
        # 3 - 1, 5 - 2
        # 4 - 1,2; 8 - 3,4
        for i in range(int((l1+l2)/2) + 1):
            if odd and i == int((l1 + l2) / 2):
                if i1 >= l1:
                    return nums2[i2]
                elif i2 >= l2:
                    return nums1[i1]
                else:
                    if nums1[i1] < nums2[i2]:
                        return nums1[i1]
                    else:
                        return nums2[i2]
            if even and i == int((l1 + l2) / 2) - 1:
                if i1 >= l1:
                    return (nums2[i2] + nums2[i2 + 1]) / 2
                elif i2 >= l2:
                    return (nums1[i1] + nums1[i1 + 1]) / 2
                else:
                    m1 = 0
                    if nums1[i1] < nums2[i2]:
                        m1 = nums1[i1]
                        i1 += 1
                    else:
                        m1 = nums2[i2]
                        i2 += 1
                    m2 = 0
                    if i1 >= l1:
                        m2 = nums2[i2]
                    elif i2 >= l2:
                        m2 = nums1[i1]
                    else:
                        if nums1[i1] < nums2[i2]:
                            m2 = nums1[i1]
                        else:
                            m2 = nums2[i2]
                    return (m1+m2)/2
                        
            if i1 >= l1:
                i2 += 1
            elif i2 >= l2:
                i1 += 1
            else:
                if nums1[i1] < nums2[i2]:
                    i1 += 1
                else:
                    i2 += 1
            
a = Solution()
print(a.findMedianSortedArrays([1,2], [3,4]))