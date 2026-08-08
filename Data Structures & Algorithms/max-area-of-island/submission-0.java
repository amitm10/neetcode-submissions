class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] == 1) {
                maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }
    }
    return maxArea;
}

private int dfs(int[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0; // bounds
    if (grid[r][c] != 1) return 0; // water or already-sunk land
    
    grid[r][c] = 0; // sink it — mark visited
    
    int area = 1; // count THIS cell
    area += dfs(grid, r-1, c);
    area += dfs(grid, r+1, c);
    area += dfs(grid, r, c-1);
    area += dfs(grid, r, c+1);
    
    return area;
}
}
