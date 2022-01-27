package leetcode.LongestSubstringWithoutRepeatingCharacters_3;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));
    }
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1) {
            return 1;
        }


        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            maxLength = Math.max(sb.length(), maxLength);

            if(i+1 >= chars.length) {
                break;
            }

            String currentStr = sb.toString();

            int duplIndex = currentStr.indexOf(chars[i+1]);
            if(duplIndex > -1) {
                sb.setLength(0);
                String ya = currentStr.substring(duplIndex+1, currentStr.length());
                sb.append(ya);

            }


        }

        return maxLength;
    }
}
