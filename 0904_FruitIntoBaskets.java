/*
Problem Name : 904. Fruit Into Baskets
Problem Link : https://leetcode.com/problems/fruit-into-baskets/description/

My Approach: First, I store the first two elements of fruits in basketFirst and basketSecond. Then, I declare a variable count = 2 and ans = 0.
Then, I start a for loop and check the condition if (basketFirst == basketSecond && fruit != basketFirst). When it is true, 
I set basketSecond = fruit and increment count.Otherwise, I check whether fruit is different from both basketFirst and basketSecond. 
Then, I calculate ans and change the values of basketFirst, basketSecond, and count.nWhen the loop finishes, I return Math.max(ans, count).

*/

class Solution {
    public int totalFruit(int[] fruits) {

        if(fruits.length <= 2) {
            return fruits.length;
        }
        int backetFirst = fruits[0];
        int backetSecond = fruits[1];
    
        int count = 2;
        int ans = 0;
        for(int i = 2; i < fruits.length; i++) {
            int fruit = fruits[i];
            
            if(backetFirst == backetSecond && fruit != backetFirst) {
                backetSecond = fruit;
                count++;
                continue;
            }
            if(fruit != backetFirst && fruit != backetSecond) {
                ans = Math.max(count, ans);
                backetFirst = fruits[i - 1];
                backetSecond = fruit;
                count = 2;
                int idx = i - 2;
                while(idx >= 0 && backetFirst == fruits[idx]) {
                    count++;
                    idx--;
                }

            } else {
                count++;
            }
        }

        return Math.max(ans, count);
    }
}
