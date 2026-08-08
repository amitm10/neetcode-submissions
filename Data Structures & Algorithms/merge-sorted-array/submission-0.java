class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //nums1 - Sorted - m good elements - length M+n
        //nums2 - Sorted - total n elements
        //merge nums1 and nums2  - should be sorted
        //in place modification and no return

        //step 1 - merge invalid placelse
        //step 2 mergesort
        //step 3 two pointers merge

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
    }
}