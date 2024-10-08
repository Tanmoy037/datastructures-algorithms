import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        
        if (totalSum == 0) {
            return 0;  // The sum is already divisible by p
        }
        
        int targetRemainder = totalSum;  // This is the remainder we need to adjust
        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);  // To handle cases where the subarray starts from index 0
        
        int prefixSum = 0;
        int minLength = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            
            // Calculate the required mod value we want to find
            int requiredMod = (prefixSum - targetRemainder + p) % p;
            
            // If this mod has been seen before, we can remove the subarray between them
            if (prefixModMap.containsKey(requiredMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(requiredMod));
            }
            
            // Store the current prefix mod value with the index
            prefixModMap.put(prefixSum, i);
        }
        
        // If we found a valid subarray, return the length, otherwise return -1
        return minLength == nums.length ? -1 : minLength;
    }
}



// Let's walk through a dry run of the solution with an example. We'll use the first example from the problem:

// Input:
// nums = [3, 1, 4, 2], p = 6
// Step-by-step dry run:
// Initial Setup:

// Compute the total sum of the array:
// 3 + 1 + 4 + 2 = 10
// Compute the total sum modulo p:
// 10 % 6 = 4
// Since the total sum is not divisible by p, we need to find a subarray to remove such that the remaining sum is divisible by p.
// The target remainder is 4. This means we need to remove a subarray such that the sum of the remaining elements has a modulo difference of 4.

// Prefix Mod Map Initialization:

// We use a hashmap prefixModMap to store the prefix sum mod values. We start by putting 0 mapped to index -1 to handle cases where the subarray starts from index 0.
// prefixModMap = {0: -1}
// Iterating through the array:

// We now iterate through the array and compute the prefix sum modulo p at each step.

// At index 0 (element 3):

// Update the prefix sum:
// prefixSum = (0 + 3) % 6 = 3
// We need to find a prefix sum that gives us the required mod difference requiredMod = (3 - 4 + 6) % 6 = 5.
// The mod value 5 is not in the map, so we cannot remove a subarray at this point.
// Add the current prefix sum mod value 3 to the map:
// prefixModMap = {0: -1, 3: 0}
// At index 1 (element 1):

// Update the prefix sum:
// prefixSum = (3 + 1) % 6 = 4
// The required mod is:
// requiredMod = (4 - 4 + 6) % 6 = 0
// We find that 0 exists in prefixModMap at index -1. This means we can remove the subarray from index 0 to index 1 to make the remaining sum divisible by p.
// The subarray length is 1 - (-1) = 2, so minLength = 2.
// Add the current prefix sum mod value 4 to the map:
// prefixModMap = {0: -1, 3: 0, 4: 1}
// At index 2 (element 4):

// Update the prefix sum:
// prefixSum = (4 + 4) % 6 = 2
// The required mod is:
// requiredMod = (2 - 4 + 6) % 6 = 4
// We find that 4 exists in prefixModMap at index 1. This means we can remove the subarray from index 2 to index 2 to make the remaining sum divisible by p.
// The subarray length is 2 - 1 = 1, so minLength = 1 (update the result).
// Add the current prefix sum mod value 2 to the map:
// prefixModMap = {0: -1, 3: 0, 4: 1, 2: 2}
// At index 3 (element 2):

// Update the prefix sum:
// prefixSum = (2 + 2) % 6 = 4
// The required mod is:
// requiredMod = (4 - 4 + 6) % 6 = 0
// We find that 0 exists in prefixModMap at index -1. However, removing this subarray gives a length of 3 - (-1) = 4, which is larger than the current minimum subarray length (1).
// Add the current prefix sum mod value 4 to the map (overwriting the old value):
// prefixModMap = {0: -1, 3: 0, 4: 3, 2: 2}
// Result:

// The smallest subarray length that can be removed to make the sum divisible by p is 1. Therefore, the output is 1.
// Summary of important steps:
// Prefix mod map: As we move through the array, we compute the prefix sum mod values and store them in a map. This helps in checking for subarrays that can be removed.

// Remainder adjustment: At each step, we compute the required mod difference to remove a subarray. If the difference is found in the prefix mod map, it means we can remove that subarray.

// Track smallest subarray length: We keep track of the smallest subarray length and return the result at the end.

// Final Output:

// Output: 1
