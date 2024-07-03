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


// Another easy solution




class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; // Size of the array.

        // Edge cases:
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If nums[mid] is the single element:
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
           
            // We are in the left: (just cheking where is mid if odd posion same element will be in [mid - 1] position , if 
            //  i am in even position same element will be in [mid + 1] position)
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                // Eliminate the left half:
                low = mid + 1;
            } 
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
    }
}

