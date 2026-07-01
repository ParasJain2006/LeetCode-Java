class Solution {
    public int findCircleNum(int[][] isConnected) {
            boolean[] visited= new boolean[isConnected.length];
            int ans=0;
            for(int i=0;i<isConnected.length;i++){
                if(!visited[i]){
                    ans++;
                   dfs(isConnected,visited,i);
                }
            }
            return ans;
        }
        void dfs(int[][] isConnected,boolean[] visited, int i){
            visited[i]=true;
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]!=0 && !visited[j]){
                    dfs(isConnected,visited,j);
                }
            }
        }
    }