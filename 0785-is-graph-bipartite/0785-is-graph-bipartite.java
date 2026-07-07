class Solution {
    public boolean isBipartite(int[][] graph) {
        Boolean[] arr= new Boolean[graph.length];
        for(int j=0;j<graph.length;j++){
            if(arr[j]==null){
              if(!dfs(j,true,graph, arr)) return false;
            }
        }
        return true;
    }
    boolean dfs(int node,boolean val, int[][] graph, Boolean[] arr){
        arr[node]=val;
        for(int x:graph[node]){
                if(arr[x]==null){
                    if(!dfs(x,!val, graph, arr)) return false;
                }
                else if(arr[x]==val)return false;
        }
        return true;
    }
}