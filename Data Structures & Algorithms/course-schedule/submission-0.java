class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    int[] inDegree = new int[numCourses];
    
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    
    for (int[] p : prerequisites) {
        int course = p[0], prereq = p[1];
        graph.get(prereq).add(course); // prereq → course (edge direction)
        inDegree[course]++;             // course has one more prerequisite
    }
    
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (inDegree[i] == 0) queue.offer(i); // no prerequisites — can start immediately
    }
    
    int completed = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll();
        completed++;
        
        for (int next : graph.get(course)) {
            inDegree[next]--;
            if (inDegree[next] == 0) queue.offer(next); // all its prereqs now done
        }
    }
    
    return completed == numCourses; // if fewer completed, a cycle blocked some courses
}
}
