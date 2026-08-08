class Solution {
    public boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = filtered.length();
        for(int i=0; i < n / 2; i++){
            if (filtered.charAt(i) != filtered.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}