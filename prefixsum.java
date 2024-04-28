public class prefixsum {
    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 4, 5};
        // int[] prefixSum = new int[nums.length];
        // prefixSum[0] = nums[0];
        // for (int i = 1; i < nums.length; i++){
        //     prefixSum[i] = prefixSum[i-1] + nums[i];
        // }
        // for (int i = 0; i < prefixSum.length; i++){
        //     System.out.println(prefixSum[i]);
        // }

        int [] nums =  {1, 2, 3, 4, 5};
        int [] prefixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = 0; j <= i; j++){
                sum += nums[j];
            }
            prefixSum[i] = sum;
            
        }
        for (int i = 0; i < prefixSum.length; i++){
            System.out.println(prefixSum[i]);
        }
    }
}
