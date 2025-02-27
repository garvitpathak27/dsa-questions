class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> subset = new ArrayList<>();
    public List<List<String>> partition(String s) {
    dfs(0 , 0 , s);
    return res;
    }

    private void dfs(int j , int i , String s){
        if(i >= s.length()){
            if( i == j){
                res.add(new ArrayList<>(subset));
            }
            return ;
        }

        if(ispal(s , j , i)){
            subset.add(s.substring(j , i+ 1));
            dfs(i+1 , i+ 1, s);
            subset.remove(subset.size() -1);
        }
        dfs(j , i+ 1 , s);
    }
    private boolean ispal(String s , int l , int r){
        while(l < r){
            if(s.charAt(l) !=  s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
