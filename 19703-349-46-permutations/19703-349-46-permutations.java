class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return Arrays.asList(new ArrayList<>());
        }
        //initial persm is  [[]]
        // then after first iteration only this fucntion will add [[3]] 
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1 , nums.length));
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> p : perms){
            for(int i = 0 ; i <= p.size() ; i++){
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i,nums[0]);
                ans.add(p_copy);
            }
        }
        return ans;

    }
}
