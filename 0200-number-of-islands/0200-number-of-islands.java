class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(grid,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            if (x > 0 && !visited[x - 1][y] && grid[x - 1][y] == '1') {
                visited[x - 1][y] = true;
                q.offer(new int[]{x - 1, y});
            }
            if (y > 0 && !visited[x][y - 1] && grid[x][y - 1] == '1') {
                visited[x][y - 1] = true;
                q.offer(new int[]{x, y - 1});
            }
            if (x < grid.length - 1 && !visited[x + 1][y] && grid[x + 1][y] == '1') {
                visited[x + 1][y] = true;
                q.offer(new int[]{x + 1, y});
            }
            if (y < grid[0].length - 1 && !visited[x][y + 1] && grid[x][y + 1] == '1') {
                visited[x][y + 1] = true;
                q.offer(new int[]{x, y + 1});
            }
        }
    }
}
