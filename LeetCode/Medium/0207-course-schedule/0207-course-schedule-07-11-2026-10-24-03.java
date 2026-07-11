import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            // prereq -> course
            adj.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0)
                q.add(i);

        }

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0)
                    q.add(neighbour);

            }
        }

        return count == numCourses;
    }
}