class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # Initialize pointers i, j, and k to the end of the non-zero elements in nums1, nums2, and nums1 respectively
        i = m - 1
        j = n - 1
        k = m + n - 1
        
        # Merge nums1 and nums2 into nums1 in non-decreasing order
        while i >= 0 and j >= 0:
            if nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        
        # Copy the remaining elements of nums2 into nums1
        while j >= 0:
            nums1[k] = nums2[j]
            j -= 1
            k -= 1
