class Solution {
    class Tuple {
        int stops;
        int node;
        int dist;
        Tuple(int stops, int node, int dist) {
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < flights.length; i++) adjList.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        int[] dists = new int[n];
        Arrays.fill(dists, (int) 1e9);
        dists[src] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int dist = current.dist;
            int node = current.node;
            int stops = current.stops;
            if (stops <= k) {
                for (int[] neighbor : adjList.get(node)) {
                    if (dist + neighbor[1] < dists[neighbor[0]]) {
                        dists[neighbor[0]] = dist + neighbor[1];
                        queue.add(new Tuple(
                            stops + 1,
                            neighbor[0],
                            dists[neighbor[0]]
                        ));
                    }
                }
            }
        }
        if (dists[dst] != (int) 1e9) return dists[dst];
        return -1;
    }
}
