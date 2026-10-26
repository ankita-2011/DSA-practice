class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> firstIndex = new HashMap<>();

        firstIndex.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (firstIndex.containsKey(sum)) {
                int length = i - firstIndex.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                firstIndex.put(sum, i);
            }
        }

        return maxLength;
    }
}
