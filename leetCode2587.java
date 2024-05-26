import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int maxScore(int[] nums) {
        long[] result = new long[nums.length];
        nums = Arrays.stream(nums)
                     .boxed()
                     .sorted(Comparator.reverseOrder())
                     .mapToInt(Integer::intValue)
                     .toArray();

        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            result[i] = result [i -1] + nums [i];
        }
        int count = 0;
        for (int i = 0; i < result.length; i++){
            
            if (result[i] > 0){
                count ++;
            }

        }
        return count;

    }
}

