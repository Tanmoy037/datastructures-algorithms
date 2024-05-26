class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans = new long [nums.length];
        long max = nums[0];
        long sum = 0;

        for ( int i = 0; i < nums.length; i++){
            max = Math.max (nums[i], max);
            sum += max + nums [i];
            ans [i] = sum;
        }
        return ans;
    }
}