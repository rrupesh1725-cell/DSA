class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101]; // since 1 <= nums[i] <= 100
        int maxFreq = 0;

        // count frequency of each element
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        int ans = 0;
        // sum frequencies of elements that have the maximum frequency
        for (int f : freq) {
            if (f == maxFreq) {
                ans += f;
            }
        }

        return ans;
    }
}
