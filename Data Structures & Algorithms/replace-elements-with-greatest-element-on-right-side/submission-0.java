class Solution {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];           // Save current element
            arr[i] = rightMax;           // Replace with max from right
            rightMax = Math.max(rightMax, temp);  // Update max
        }
        return arr;
    }
}