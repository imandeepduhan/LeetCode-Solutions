/*
Problem Name : 125. Valid Palindrome
Problem Link : https://leetcode.com/problems/valid-palindrome/description/

My Approach : First, I convert uppercase letters to lowercase and remove dots, commas, spaces, etc.
Then, I create a new String and store the characters in reverse order. Finally, I compare both Strings.
*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String a = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            a += ch;
        }

        for(int i = 0; i < s.length(); i++) {
          if(s.charAt(i) != a.charAt(i)) {
             return false;
            }   
        }
        return true;
    }
}
