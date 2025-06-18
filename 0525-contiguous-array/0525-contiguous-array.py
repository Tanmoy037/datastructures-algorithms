class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefixSum = 0
        maxLength = 0
        prefixMap = {0: -1}  # prefixSum : first index seen
        
        for i, num in enumerate(nums):
            # Convert 0 to -1, 1 stays as 1
            if num == 0:
                prefixSum += -1
            else:
                prefixSum += 1
            
            # Check if prefixSum was seen before
            if prefixSum in prefixMap:
                # Found a subarray with sum = 0
                length = i - prefixMap[prefixSum]
                maxLength = max(maxLength, length)
            else:
                # Store the first occurrence of this prefixSum
                prefixMap[prefixSum] = i
        
        return maxLength
