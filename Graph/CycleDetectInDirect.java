
import java.util.*;

class CycleDetectInDirect {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preq = pre[1];
            adj.get(preq).add(course);

            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] order = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;
            for (int neigh : adj.get(course)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }

        }
        if (idx == numCourses)
            return order;
        return new int[0];

    }
}