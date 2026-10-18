/*
Problem Name : 4084. Last Visited Cell in a Directional Grid
Problem Link : https://leetcode.com/problems/last-visited-cell-in-a-directional-grid/description/

My Approach : First, I create a visited array with the same size as the grid. Then, I create four variables.
i and j are initialized to 0, and oldI and oldJ store the previous value of i and j. Then , I start a while loop and 
check the current character and increase or decrease i or j according to the current character.

*/

class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visit = new boolean[rowSize][colSize];
        int i = 0;
        int j = 0;
        int oldI = 0;
        int oldJ = 0;
        while(i >= 0 && j >= 0 && i < rowSize && j < colSize) {

            if(visit[i][j] == true) {
                return new int[] {oldI, oldJ};
            }

            oldI = i;
            oldJ = j;
            
            char ch = grid[i][j];
            if(ch == 'R') {
                visit[i][j] = true;
                j++;
            } else if (ch == 'L') {
                visit[i][j] = true;
                j--;
            } else if (ch == 'U') {
                visit[i][j] = true;
                i--;
            } else if (ch == 'D') {
                visit[i][j] = true;
                i++;
            }

            if(i < 0 || j < 0 || i >= rowSize || j >= colSize) {
                return new int[] {oldI, oldJ};
            }
        }

        return new int[] {oldI, oldJ};
    }
}
