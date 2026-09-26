/*
Problem Name : 994. Rotting Oranges
Problem Link : https://leetcode.com/problems/rotting-oranges/description/

My Approach: First, I create a Node class in which I create three variables: row, col, and val.
Then, I create a Queue. It stores Node type values. I start a for loop to find 2 and store them in the Queue. 
Then, I call the bfs function. It runs until the Queue is not empty. 
In BFS, I check the four adjacent cells and add the fresh orange to the Queue. Finally, I return the ans.

*/

class Solution {
     static int ans = 0;

    static class Node {
        int row;
        int col;
        int val;

        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static void bfs(int[][] grid, Queue<Node> q) {
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.row;
            int y = curr.col;
            int val = curr.val;

            int[][] dir = {
                    { -1, 0 },
                    { 1, 0 },
                    { 0, -1 },
                    { 0, 1 }
            };

            for (int[] direction : dir) {
                int row = x + direction[0];
                int col = y + direction[1];

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {

                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        int newVal = val + 1;
                        q.add(new Node(row, col, newVal));
                        ans = Math.max(ans, newVal);
                    }

                }
            }

        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }

        boolean one = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans = -1;
                    one = false;
                    break;
                }
            }
        }

        if(one) {
            ans = 0;
            return ans;
        }

        bfs(grid, q);

        boolean ok = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans = -1;
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                break;
            }
        }

        return ans;
    }
}
