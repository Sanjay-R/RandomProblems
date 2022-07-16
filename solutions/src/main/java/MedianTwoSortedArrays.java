public class MedianTwoSortedArrays {

    //LeetCode: https://leetcode.com/problems/median-of-two-sorted-arrays/

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            int[] merged = new int[m + n];

            int i = 0; //.....m
            int j = 0; //.....n
            int k = 0;

            while (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    merged[k] = nums1[i];
                    k++;
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    merged[k++] = nums2[j++];
                }
            }

            while (i < m) {
                merged[k++] = nums1[i++];
            }

            while (j < n) {
                merged[k++] = nums2[j++];
            }

            if (merged.length % 2 == 0) {
                int mid = merged.length / 2;
                return ((double) (merged[mid - 1] + merged[mid]) / 2);
            } else {
                return merged[merged.length / 2];
            }

        }
    }

}
