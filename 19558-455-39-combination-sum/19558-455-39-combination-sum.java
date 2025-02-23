class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target , /*index */ 0 , new ArrayList<>() , ans);
        return ans;
    }
    private static void backtrack(int []  nums , int remain , int start , List<Integer> subset , List<List<Integer>> ans){
        if(remain == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        else if(remain < 0){
            return ;
        }
        for(int i = start ; i < nums.length ; i++){
            subset.add(nums[i]);
            backtrack(nums , remain - nums[i] , i , subset , ans);
            subset.remove(subset.size() - 1);// clearing the subset for further use 
        }
    }
}