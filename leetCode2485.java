class Solution {
    public int pivotInteger(int n) {
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }
        
        // Iterate to find the pivot integer
        for (int i = 1; i <= n; i++) {
            int leftSum = prefixSum[i];  // Sum of numbers from 1 toi
            int rightSum = prefixSum[n] - prefixSum[i - 1];  // Sum of numbers from i to n
            
            if (leftSum == rightSum) {
                return i;
            }
        }
        
        return -1;  
    }
}