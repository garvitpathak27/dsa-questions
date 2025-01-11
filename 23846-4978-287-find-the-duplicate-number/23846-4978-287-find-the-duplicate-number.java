class Solution {
    public int findDuplicate(int[] nums) {
       boolean[] ap =new boolean[nums.length];
        for(int i:nums){
          if(ap[i]) return i;
          ap[i]=true;
        }
        return -1;
    }
}