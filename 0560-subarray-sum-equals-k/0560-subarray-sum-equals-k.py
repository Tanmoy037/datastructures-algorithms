class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # prefixSum[j] - prefixSum[i-1] = k,
        # prefixSum[j] - k = prefixSum[i-1]
        res = 0 
        curSum = 0
        prefixSums= {0 : 1}

        for n in nums:
            curSum += n
            diff = curSum - k 

            res += prefixSums.get(diff,0)
            prefixSums[curSum] = prefixSums.get(curSum, 0) + 1
            
        return res