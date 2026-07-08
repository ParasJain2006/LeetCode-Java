class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v= graph.length;
        boolean[] visited = new boolean[v];
        boolean[] pathvis = new boolean[v];
        boolean[] check = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]) dfs(graph, visited, pathvis, check,i);
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i])ans.add(i);
        }
        return ans;
    }
    boolean dfs(int[][] graph, boolean[] visited, boolean[] pathvis,boolean[] check, int node){
        visited[node]=true;
        pathvis[node]=true;
        check[node]=false;
        for(int i:graph[node]){
            if(!visited[i]){
                if(dfs(graph,visited,pathvis,check,i)) return true;
            }
            else if(pathvis[i]) return true;
        }
        pathvis[node]=false;
        check[node]=true;
        return false;
    }
}