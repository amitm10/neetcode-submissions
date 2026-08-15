class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int pathLength = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cell[] = queue.poll();
                int r = cell[0], c = cell[1];

                if (r == n - 1 && c == n - 1) return pathLength;

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (grid[nr][nc] != 0) continue;
                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
            pathLength++;
        }
        return -1;
    }
}