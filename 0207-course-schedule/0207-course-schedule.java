class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q= new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] in= new int[numCourses];
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] edge: prerequisites){
            adj.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }
        for(int i=0;i<in.length;i++){
            if(in[i]==0) q.add(i);
        }
        int check=0;
        while(!q.isEmpty()){
            int x=q.poll();
            check++;
            for(int i:adj.get(x)){
                in[i]--;
                if(in[i]==0) q.add(i);
            }
        }
        return check==numCourses;
    }
}