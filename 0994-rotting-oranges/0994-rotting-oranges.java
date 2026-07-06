class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) {
                q.add(new int[] {i,j,0});
                visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], time = cur[2];
            ans=Math.max(ans,time);
            if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]==1){
                visited[i-1][j]=true;
                q.add(new int[] {i-1,j,time+1});
            }
            if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]==1){
                visited[i][j-1]=true;
                q.add(new int[] {i,j-1,time+1});
            }
            if(i+1<m && !visited[i+1][j] && grid[i+1][j]==1){
                visited[i+1][j]=true;
                q.add(new int[] {i+1,j,time+1});
            }
            if(j+1<n && !visited[i][j+1] && grid[i][j+1]==1){
                visited[i][j+1]=true;
                q.add(new int[] {i,j+1,time+1});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]) return -1;
            }
        }
        return ans;
    }
}