class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
         String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", 
            "mno", "qprs", "tuv", "wxyz"
        };

        List<String> res = new ArrayList<>();
        res.add("");
        for(char digit : digits.toCharArray()){
            List<String> temp = new ArrayList<>();
            for(String curr : res){
                 for(char c : digitToChar[digit - '0'].toCharArray()){
                    temp.add(curr + c);
                }
            }
            res = temp;
        }
        return res;
        
    }
}