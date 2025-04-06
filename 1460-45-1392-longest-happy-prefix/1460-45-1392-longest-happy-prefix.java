class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        // Build the LPS array
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int max = lps[n - 1];

        StringBuilder ans = new StringBuilder();
        for (i = 0; i < max; i++) {
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
