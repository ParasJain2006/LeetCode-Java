class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q= new LinkedList<>();
        char[] arr= new char[graph.length];
        for(int j=0;j<graph.length;j++){
            if(arr[j]==0){
                q.offer(j);
                arr[j]='r';
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int i: graph[curr]){
                        if(arr[i]!=0 && arr[i]==arr[curr]) return false;
                        if(arr[i]==0){
                            if(arr[curr]=='r')arr[i]='b';
                            else arr[i]='r';
                            q.add(i);
                        }
                    }
                }
            }
        }
        return true;
    }
}