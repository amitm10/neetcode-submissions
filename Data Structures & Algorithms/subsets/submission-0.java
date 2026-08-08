class Solution {
    public List<List<Integer>> subsets(int[] nums) {//list of list of integers
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;//result is going to store all the lists
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));//add null
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);//solving using recusrsion
            tempList.remove(tempList.size() - 1);
        }
    }
}