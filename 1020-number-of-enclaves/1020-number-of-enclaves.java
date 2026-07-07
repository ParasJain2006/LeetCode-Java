import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        // Top and Bottom rows
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                visited[0][j] = true;
                q.offer(new int[]{0, j});
            }

            if (grid[rows - 1][j] == 1 && !visited[rows - 1][j]) {
                visited[rows - 1][j] = true;
                q.offer(new int[]{rows - 1, j});
            }
        }

        // Left and Right columns
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                visited[i][0] = true;
                q.offer(new int[]{i, 0});
            }

            if (grid[i][cols - 1] == 1 && !visited[i][cols - 1]) {
                visited[i][cols - 1] = true;
                q.offer(new int[]{i, cols - 1});
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    grid[nr][nc] == 1 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}