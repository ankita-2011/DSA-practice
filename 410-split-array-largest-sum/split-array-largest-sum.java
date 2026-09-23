class Solution {

    public int splitArray(int[] nums, int k) {

        int left = 0;
        long right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {

                right = mid;

            } else {

                left = (int) mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(
            int[] nums,
            int k,
            long maxSum) {

        int parts = 1;
        long currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {

                parts++;
                currentSum = num;

                if (parts > k) {
                    return false;
                }

            } else {

                currentSum += num;
            }
        }

        return true;
    }
}