        //Recursive solution by leetcode
        //Terrible runtime of 58ms better than only 14.98% 
        //Bad memory better than only 34%
class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        //this variable saves if the current element is a match with the pattern (only considers one char)
        //it does not consider stars, since they will always come behind another element
        //so current text either matches my first char, or matches a point
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        //if my pattern lenght is bigger than 1 and the second element in my pattern is '*' (* matches 0 or 
        //  more of preceding element)
        //if yes it means that we will now ask if our text matches the patters minus the first 2 characters
            //we send the same text because * can match 0 characters, so we might skip this two elements of the pattern
        //OR if first element matched and text from the second character on matches the pattern
            //we ask for the first match and sent pattern without changes because the star means we could match
            //one element of text and keep matching that same character with the same pattern
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {

        //length is smaller than 2 or the second element is not *
        //return true if first element matches and the text and substring minus their first elements match
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}

        //DP solution by leetcode
        //Average runtime 3ms better than 49.8% (faster solution are more complex) O(T*P)
        //text lenght and pattern length 
        //Good memory better than ~90%
class Solution {
    public boolean isMatch(String text, String pattern) {

        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}