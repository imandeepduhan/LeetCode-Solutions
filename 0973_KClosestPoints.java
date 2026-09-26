/*
Problem Name : 973. K Closest Points to Origin
Problem Link : https://leetcode.com/problems/k-closest-points-to-origin/description/

My Approach : I create a PriorityQueue and sort the Pairs based on their distance from the origin.
When the pq size is greater than k, I remove the first Pair. Finally, I return the 2D ans array.

*/

class Solution {
    class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            int d1 = a.first * a.first + a.second * a.second;
            int d2 = b.first * b.first + b.second * b.second;
                return d2 - d1;
        });

        for(int i = 0; i < points.length; i++) {
            pq.offer(new Pair(points[i][0], points[i][1]));

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[i][0] = p.first;
            ans[i][1] = p.second;

            i++;
        }

        return ans;
    }
}
