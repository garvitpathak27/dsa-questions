class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        join(nums , 0 ,new ArrayList<>() , ans);
        return ans;

    }

    private void join(int [] nums , int x , List<Integer> temp , List<List<Integer>>ans){
        ans.add(new ArrayList<>(temp));

        for(int i = x ; i < nums.length ; i++){
            if(i > x && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);

            join(nums,i+1 , temp , ans);
            temp.remove(temp.size() -1);
        }
    }
}