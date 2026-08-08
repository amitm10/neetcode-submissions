class Solution {
    public int climbStairs(int n) {
        //n = total number of steps
        //base case n=1
        //1 =1; 2 =2; 3 = 3; 4 = 1*4;2.2//112//121//211;5 = 1*5,122,212,221,1112,
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}