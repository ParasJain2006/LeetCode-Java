class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int originalColor = image[sr][sc];
        dfs(image, visited, sr, sc,color,originalColor);
        return image;
    }
    void dfs(int[][] grid, boolean[][] visited, int i, int j,int color,int originalColor ) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols) return;
        if (grid[i][j] != originalColor || visited[i][j]) return;
        visited[i][j] = true;
        grid[i][j]=color;
        dfs(grid, visited, i + 1, j,color,originalColor);
        dfs(grid, visited, i - 1, j,color,originalColor);
        dfs(grid, visited, i, j + 1,color,originalColor);
        dfs(grid, visited, i, j - 1,color,originalColor); 
    }
}