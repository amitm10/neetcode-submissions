class Solution {

    //1,2,3,4,5,6,7,8,9
//2 - 1

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i-1]*nums[i-1];
        }

        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i]*suffix;
            suffix *= nums[i];
        }

        return res;

    }
}