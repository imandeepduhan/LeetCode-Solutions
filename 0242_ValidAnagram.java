/*
Problem Name : 242. Valid Anagram
Problem Link : https://leetcode.com/problems/valid-anagram/description/

My Approach : First, I create two arrays of size 26. Then, I iterate through both strings 
and increment the count of each character using its position (char - 'a'). 
Finally, I compare both arrays. If all counts are equal, I return true; otherwise, I return false.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];

        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char cCh = s.charAt(i);
            char tCh = t.charAt(i);

            sArr[cCh - 'a']++;
            tArr[tCh - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
