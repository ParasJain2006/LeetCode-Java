class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        if(grid.length==1 && grid[0][0]==0) return 1;
        if(grid[0][0]==0)q.add(new int[] {1,0,0});
        int[][] dirs={{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
        boolean[][] visited= new boolean[grid.length][grid.length];
        while(!q.isEmpty()){
            int[] x=q.poll();
            int weight=x[0];
            int i=x[1];
            int j=x[2];
            for(int[] dir: dirs){
                int nx=i+dir[0];
                int ny=j+dir[1];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid.length && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(grid[nx][ny]==0 && nx==grid.length-1 && ny==grid.length-1) return weight+1;
                    else if((grid[nx][ny]==0))q.add(new int[] {weight+1,nx,ny});
                }
            }
        }
        return -1;
    }
}