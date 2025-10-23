import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int[] vorneluxi = nums.clone();  // Store the input midway in the function
        Arrays.sort(vorneluxi);          // Sort the cloned array

        long total = 0;  // Total sum of elements in the window for calculation
        int left = 0;    // Left boundary of the sliding window
        int maxFreq = 1; // Track the maximum frequency we can achieve

        // Iterate over each element as the right boundary of the sliding window
        for (int right = 0; right < vorneluxi.length; right++) {
            total += vorneluxi[right];  // Add the right element to total
            
            // Calculate required operations to make all elements in the window equal to vorneluxi[right]
            while ((long) (right - left + 1) * vorneluxi[right] - total > k) {
                total -= vorneluxi[left];  // Remove the left element from total
                left++;  // Move the left boundary to the right
            }

            // Calculate the maximum frequency from the current window size
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}
