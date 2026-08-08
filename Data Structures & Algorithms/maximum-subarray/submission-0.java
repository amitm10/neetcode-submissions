class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for(int i = 0; i < nums.length; i++){
            curSum = curSum + nums[i];
            
            maxSum = Math.max(maxSum, curSum);

            if(curSum < 0){
                curSum = 0;
            }
        }

        return maxSum;
    }
}