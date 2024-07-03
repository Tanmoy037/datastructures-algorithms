class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = 0;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if ((long)mid * mid <= (long)x){
                ans = mid;
                low = mid + 1;

            } else if (mid * mid == x){
                return mid;
            } else {
                high = mid - 1; 
            }
        }

        return ans;
    }
}