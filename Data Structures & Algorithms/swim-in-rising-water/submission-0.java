
    class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // {cost, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];

            if (cost > dist[r][c]) continue; // stale entry, skip

            if (r == n - 1 && c == n - 1) return cost; // reached destination

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int newCost = Math.max(cost, grid[nr][nc]); // minimax relaxation
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{newCost, nr, nc});
                }
            }
        }
        return -1; // unreachable, shouldn't happen given problem constraints
    }
}

