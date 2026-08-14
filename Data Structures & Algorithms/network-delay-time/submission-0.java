class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build adjacency list: node -> list of [neighbor, weight]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                 .add(new int[]{t[1], t[2]});
        }

        // 2. Dijkstra
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0}); // {node, distance}

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (visited[u]) continue; // stale entry, skip
            visited[u] = true;

            for (int[] edge : graph.getOrDefault(u, Collections.emptyList())) {
                int v = edge[0], w = edge[1];
                if (!visited[v] && d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // 3. Find the max distance, check reachability
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}