/*

Problem Name : 733. Flood Fill
Problem Link : https://leetcode.com/problems/flood-fill/description/

My approach : My approach: First, I checked the condition if the current element of the image is equal to the new color, then I stop the function and return the image matrix. Otherwise, I call the DFS function, which takes the image matrix, sr (row), sc (column), color, and oldColor as parameters. In the DFS function, I checked the condition `if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != oldColor || image[sr][sc] == color)`. If this condition is true, I return; otherwise, I call its four neighboring cells.

*/

class Solution {

    public static void dfs(int[][] image, int sr , int sc , int color , int oldColor) {
        int row = image.length;
        int col = image[0].length;
        if(sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != oldColor || image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr - 1 , sc , color, oldColor);
        dfs(image, sr, sc - 1, color , oldColor);
        dfs(image, sr, sc + 1, color, oldColor);
        dfs(image, sr + 1, sc, color , oldColor);
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         if(image[sr][sc] == color) {
            return image;
        }
        int oldColor = image[sr][sc];

        dfs(image, sr, sc, color, oldColor);

        return image;
    }
}
