class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            if (s1Map.containsKey(rightChar)) {
                s1Map.put(rightChar, s1Map.get(rightChar) - 1);
                if (s1Map.get(rightChar) >= 0)
                    count--;
            }
            right++;

            if (count == 0)
                return true;

            if (right - left == s1.length()) {
                char leftChar = s2.charAt(left);
                if (s1Map.containsKey(leftChar)) {
                    s1Map.put(leftChar, s1Map.get(leftChar) + 1);
                    if (s1Map.get(leftChar) > 0)
                        count++;
                }
                left++;
            }
        }

        return false;
    }
}