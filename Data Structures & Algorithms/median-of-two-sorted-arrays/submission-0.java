class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Median would be n + m / 2 - Want to find elements to left of it
            // Thus, we choose a elements from nums1 and b elements from nums2
            // Want a point where both left partitions are lesser than both right partitions
        // int left1 = 0, left2 = 0, right1 = nums1.length - 1, right2 = nums2.length - 1;
        // while(left1 + left2 < right1 + right2) {
        //     int k1 = (left1 + right1) / 2;
        //     int k2 = (left2 + right2) / 2;
        //     // Want to check the elements to the left are all lesser than elements to right
        //     if (nums1[k1] > nums2[k2]) {
        //         // Not - Must update k1
        //         right1 = k1 - 1;
        //     }
        //     else {
        //         left1 = k1;
        //     }

        //     if (nums2[k2] > nums1[k1]) {
        //         // Not - Must update k1
        //         right2 = k2 - 1;
        //     }
        //     else {
        //         left2 = k2;
        //     }
        // }
        // if ((nums1.length + nums2.length) % 2 == 0) {
        //     double d = nums1[left1] + nums2[left2];
        //     d /= 2.0;
        //     return d;
        // }
        // else {
        //     return Math.max(nums1[left1], nums2[left2]);
        // }

        // Optimization: We know that there must be n + m / 2 elements to left of median
            // So binary search through the min array to find a partition
            // Find the numbers that would be added to this partition in the opposing side (n + m / 2 - a)
                // Check if it works
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int numToPartition = (nums1.length + nums2.length + 1) / 2;
        int left = 0, right = nums1.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            int otherMid = numToPartition - mid;
            // if (nums1[mid] > nums1[(numToPartition - (mid + 1)) - 1]) {
            //     right = mid - 1;
            // }
            // else {
            //     left = mid + 1;
            // }

            int nums1Left = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int nums1Right = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int nums2Left = otherMid > 0 ? nums2[otherMid - 1] : Integer.MIN_VALUE;
            int nums2Right = otherMid < nums2.length ? nums2[otherMid] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // Both conditions are filled - partitions are found
                if ((nums1.length + nums2.length) % 2 != 0) {
                    // Odd
                    return Math.max(nums1Left, nums2Left);
                }
                // Even
                return ((Math.max(nums1Left, nums2Left)) + (Math.min(nums1Right, nums2Right))) / 2.0;
            }
            else if (nums1Left > nums2Right) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
