class Solution {
    public int orangesRotting(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int freshCount = 0;
    
    // Step 1: find ALL initial rotten oranges, count fresh ones
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c] == 2) queue.offer(new int[]{r, c});
            else if (grid[r][c] == 1) freshCount++;
        }
    }
    
    if (freshCount == 0) return 0; // nothing to rot, already done
    
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int minutes = 0;
    
    // Step 2: multi-source BFS, level by level = minute by minute
    while (!queue.isEmpty() && freshCount > 0) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int nr = cell[0] + d[0], nc = cell[1] + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] != 1) continue; // not fresh, skip
                
                grid[nr][nc] = 2; // rot it
                freshCount--;
                queue.offer(new int[]{nr, nc});
            }
        }
        minutes++;
    }
    
    return freshCount == 0 ? minutes : -1;
}
}
