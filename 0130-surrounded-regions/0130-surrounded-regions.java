class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q= new LinkedList<>();
        int[][] dirs={{0,-1},{1,0},{0,1},{-1,0}};
        int r= board.length, c= board[0].length;
        for(int i=0;i<c;i++) q.add(new int[] {0,i});
        for(int i=0;i<r;i++) q.add(new int[] {i,c-1});
        for(int i=c-1;i>=0;i--) q.add(new int[] {r-1,i});
        for(int i=r-1;i>=0;i--) q.add(new int[] {i,0});
        boolean[][] visited= new boolean[r][c];
        while(!q.isEmpty()){
            int[] temp= q.poll();
            int i=temp[0], j=temp[1];
            char k=board[i][j];
            visited[i][j]=true;
            if(k!='O') continue;
            for(int[] x:dirs){
                int ni=x[0]+i, nj=x[1]+j;
                if(ni>=0 && nj>=0 && ni<r && nj<c && board[ni][nj]=='O' && !visited[ni][nj]) q.add(new int[] {ni,nj});
            }
        }
        for(int i=1;i<r-1;i++){
            for(int j=1;j<c-1;j++){
                if(!visited[i][j] && board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}