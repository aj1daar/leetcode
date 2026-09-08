class Solution {    
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

            String longestPalindrome = "";

            for (int i = 0; i < s.length(); i++) {
                int left = i;
                int right = i;
                while (left >= 0 && right <=s.length()-1 
                && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
            
            }
                if (right-(left+1) > longestPalindrome.length()) {
                longestPalindrome = s.substring(left+1, right);
                }

                int left2 = i;
                int right2 = i + 1;

                while (left2 >= 0 && right2 <=s.length()-1 
                    && s.charAt(left2) == s.charAt(right2)){

                    left2--;
                    right2++;
            
                }

            if (right2 - left2 - 1 > longestPalindrome.length()) {
            longestPalindrome = s.substring(left2 + 1, right2);
            }

        }

    return longestPalindrome;
    }
}