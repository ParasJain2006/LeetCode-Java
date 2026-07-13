class Solution {
    class Tuple {
    int dist;
    int row;
    int col;

    Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq= new PriorityQueue<>((x,y)-> Integer.compare(x.dist,y.dist));
        int[][] calc= new int[heights.length][heights[0].length];
        for (int[] row : calc) Arrays.fill(row, (int) 1e9);
        pq.add(new Tuple(0,0,0));
        calc[0][0]=0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(pq.size()!=0){
            Tuple t= pq.poll();
            int dist= t.dist;
            int i= t.row;
            int j= t.col;
            for(int[] dir:dirs){
                int nx=i+dir[0];
                int ny=j+dir[1];
                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length){
                    int x=Math.max(Math.abs(heights[nx][ny]-heights[i][j]),dist);
                    if (calc[nx][ny] > x) {
                        calc[nx][ny] = x;
                        pq.add(new Tuple(x, nx, ny));
                    }
                }
            }
        }
        return calc[heights.length-1][heights[0].length-1];
    }
}