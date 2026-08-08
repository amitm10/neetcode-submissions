class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueCharInStringSet = new HashSet<>(); 
        int l=0;//left removal
        int r=0;//traversal
        int res=0; 
        for(r=0;r<s.length();r++){
            while(uniqueCharInStringSet.contains(s.charAt(r))){
                uniqueCharInStringSet.remove(s.charAt(l));
                l++;
            }
            uniqueCharInStringSet.add(s.charAt(r));
            res = Math.max(res,r-l+1);

        }
        return res;

        
    }
}