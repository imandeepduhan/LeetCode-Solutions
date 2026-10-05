/*
Problem Name : 3295. Report Spam Message
Problem Link : https://leetcode.com/problems/report-spam-message/description/

My Approach: First, I create a HashSet and add all the words from bannedWords to the set. 
Then, I check the message array one by one. If the set contains the current message word,
I increment the count. When the count becomes 2 or more, I return true. Otherwise, I return false.

*/

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> set = new HashSet<>();
        for(String word: bannedWords) {
            set.add(word);
        }
        int count = 0;
        for(String word: message) {
            if(set.contains(word)) {
                count++;
            }

            if(count >= 2) {
                return true;
            }
        }

        return false;
    }
}
