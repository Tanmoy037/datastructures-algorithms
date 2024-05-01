// problem pivot index
// hint - we are doing this way becase we are beacause we are following a the pattern of prefix sum. So we created a prefix sum array and solving the problem using the aray.
class Solution {
    public int pivotIndex(int[] nums) {
        
        int [] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] + nums[i];
        }
        for ( int i = 0; i < result.length; i++){
            if (i > 0){
                int left = result[i - 1];
                int right = result[result.length - 1] - result[i];
                if (left == right){
                    return i;
                }
            } else {
                int left = result[i];
                int right = result[result.length - 1];
                if (left == right){
                    return i;
                }
            }
        }
        return -1;


    }
}