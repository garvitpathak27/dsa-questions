class Solution {
    public int maximumCount(int[] nums) {
        int countp = 0;
        int countn   = 0;
        for(int i : nums){
            if (i > 0){
                countp++;
            }
            else if(i< 0){
                countn ++;
            }
        }
        return Math.max(countp , countn);
    }
}