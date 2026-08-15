class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 1. Build adjacency list — undirected, so add both directions
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new double[]{v, p});
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(new double[]{u, p});
        }

        // 2. Init distances (probabilities) — 0 means "unreached" here, not infinity
        double[] dist = new double[n];
        dist[start] = 1.0; // probability of "already being at start" is 1

        // 3. Max-heap ordered by probability (note: reversed comparator vs standard Dijkstra)
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int u = (int) curr[0];
            double p = curr[1];

            if (visited[u]) continue;
            visited[u] = true;

            if (u == end) return p; // early exit — popped means finalized (max-heap analog)

            for (double[] edge : graph.getOrDefault(u, Collections.emptyList())) {
                int v = (int) edge[0];
                double edgeProb = edge[1];
                double newProb = p * edgeProb; // multiply instead of add

                if (!visited[v] && newProb > dist[v]) { // > instead of 
                    dist[v] = newProb;
                    pq.offer(new double[]{v, newProb});
                }
            }
        }
        return 0.0; // end never reached
    }
}