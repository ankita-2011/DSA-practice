class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (matches(target, window)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}