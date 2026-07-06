class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length,c=mat[0].length;
        boolean[][] visited= new boolean[r][c];
        int[][] ans= new int[r][c];
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0) {
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        int dirs[][]={{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int i=temp[0];
            int j=temp[1];
            int k=temp[2];
            ans[i][j]=k;
            for(int[] x:dirs){
                int ni=i+x[0];
                int nj=j+x[1];
                if(ni>=0 && nj>=0 && ni<r && nj<c && !visited[ni][nj]){
                        q.add(new int[]{ni,nj,k+1});
                        visited[ni][nj]=true;
                }
            }
        }
        return ans;
    }
}