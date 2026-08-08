class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0, maxLen = 1;
        for (int right = 1; right < arr.length; right++) {
            int cmp = Integer.compare(arr[right - 1], arr[right]);
            
            if (cmp == 0) {
                left = right;  // equal → window can only start at 'right' now, jump directly
            } else if (right == arr.length - 1 || 
                       cmp * Integer.compare(arr[right], arr[right + 1]) != -1) {
                // next comparison doesn't flip → window ends here
                maxLen = Math.max(maxLen, right - left + 1);
                left = right;  // jump left forward, don't decrement one at a time
            }
        }
        return maxLen;
    }
}