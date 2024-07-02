class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Edge case: if the array contains only one element
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Ensure `mid` is even
            if (mid % 2 == 1) {
                mid--;
            }
            
            // Compare `mid` with `mid + 1`
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        
        // Left should point to the single element
        return nums[left];
    }
}
