class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Very easy to do two pointer and merge via a separate array

        // Instead, have to merge in-space – However, cannot overwrite previous elements
            // Solution: Go from last to first to replace 0s first
            // Thus, our solution is to put in last elements first – Like a reverse two pointer merge
        
        // In this one, we just want to continuously add elements from second array into first
            // When we added all of second array into first, our 0s are filled and we can return nums1 as is
        int last = m + n - 1;
        int i = m - 1, j = n - 1;
        while (j >= 0) {
            // Merge in reverse order
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[last--] = nums1[i--];
            else
                nums1[last--] = nums2[j--];
        }
    }
}