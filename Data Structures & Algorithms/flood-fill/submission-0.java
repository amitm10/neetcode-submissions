class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    if (oldColor == newColor) return image; // avoid infinite recursion (see note below)
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
    // 1. bounds check
    if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
    // 2. not the color we're filling (this ALSO acts as the visited check)
    if (image[r][c] != oldColor) return;
    
    image[r][c] = newColor; // paint it — this doubles as marking "visited"
    
    dfs(image, r-1, c, oldColor, newColor);
    dfs(image, r+1, c, oldColor, newColor);
    dfs(image, r, c-1, oldColor, newColor);
    dfs(image, r, c+1, oldColor, newColor);
}

}