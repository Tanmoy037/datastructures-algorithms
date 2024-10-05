class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Step 1: Calculate remainder frequencies
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) remainder += k;  // Handle negative remainders
            remainderCount[remainder]++;
        }
        
        // Step 2: Check if the remainders can form valid pairs
        for (int i = 1; i < k; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;  // Mismatched remainder pairs
            }
        }
        
        
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        
        return true;
    }
}



// Let’s dry run the code with the given input arr = [1,2,3,4,5,10,6,7,8,9] and k = 5.

// Step 1: Initialize the remainderCount array.

// We initialize an array remainderCount[] of size k = 5, which will store the count of each remainder (from 0 to k-1). Initially, remainderCount = [0, 0, 0, 0, 0].

// Step 2: Calculate remainder frequencies.

// We iterate over each element in arr, calculate its remainder when divided by k, and increment the count in the remainderCount array.

// 	•	For num = 1:
// remainder = 1 % 5 = 1
// remainderCount[1]++
// remainderCount = [0, 1, 0, 0, 0]
// 	•	For num = 2:
// remainder = 2 % 5 = 2
// remainderCount[2]++
// remainderCount = [0, 1, 1, 0, 0]
// 	•	For num = 3:
// remainder = 3 % 5 = 3
// remainderCount[3]++
// remainderCount = [0, 1, 1, 1, 0]
// 	•	For num = 4:
// remainder = 4 % 5 = 4
// remainderCount[4]++
// remainderCount = [0, 1, 1, 1, 1]
// 	•	For num = 5:
// remainder = 5 % 5 = 0
// remainderCount[0]++
// remainderCount = [1, 1, 1, 1, 1]
// 	•	For num = 10:
// remainder = 10 % 5 = 0
// remainderCount[0]++
// remainderCount = [2, 1, 1, 1, 1]
// 	•	For num = 6:
// remainder = 6 % 5 = 1
// remainderCount[1]++
// remainderCount = [2, 2, 1, 1, 1]
// 	•	For num = 7:
// remainder = 7 % 5 = 2
// remainderCount[2]++
// remainderCount = [2, 2, 2, 1, 1]
// 	•	For num = 8:
// remainder = 8 % 5 = 3
// remainderCount[3]++
// remainderCount = [2, 2, 2, 2, 1]
// 	•	For num = 9:
// remainder = 9 % 5 = 4
// remainderCount[4]++
// remainderCount = [2, 2, 2, 2, 2]

// Step 3: Check if the remainders can form valid pairs.

// We now iterate through the remainderCount array and check if the remainders can form pairs.

// 	•	For i = 1:
// Check if remainderCount[1] equals remainderCount[4] (since k - 1 = 4).
// remainderCount[1] = 2 and remainderCount[4] = 2, so they match. This means we can pair numbers with remainder 1 and numbers with remainder 4 to form sums divisible by 5.
// 	•	For i = 2:
// Check if remainderCount[2] equals remainderCount[3] (since k - 2 = 3).
// remainderCount[2] = 2 and remainderCount[3] = 2, so they match. This means we can pair numbers with remainder 2 and numbers with remainder 3 to form sums divisible by 5.

// Special Case for remainder = 0:

// Finally, check the special case for remainder 0. We need to ensure that remainderCount[0] is even because elements with remainder 0 must pair with each other.

// 	•	remainderCount[0] = 2, which is even, so the numbers with remainder 0 can be paired (in this case, 5 and 10).

// Conclusion:

// Since all conditions are satisfied (the remainders can be paired correctly), the function returns true.

// Summary of Pairing:

// The pairs are:

// 	•	(1, 9) (remainders 1 and 4)
// 	•	(2, 8) (remainders 2 and 3)
// 	•	(3, 7) (remainders 3 and 2)
// 	•	(4, 6) (remainders 4 and 1)
// 	•	(5, 10) (remainders 0 and 0)

// All of these pairs sum up to a number divisible by k = 5, so the output is true.