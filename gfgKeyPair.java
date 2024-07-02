// https://www.geeksforgeeks.org/problems/key-pair5616/1

import java.util.HashSet;

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashSet<Integer> res = new HashSet<>();
        for (int num : arr) {
            int temp = x - num;
            if (res.contains(temp)) {
                return true;
            }
            res.add(num);
        }
        return false;
    }
}
