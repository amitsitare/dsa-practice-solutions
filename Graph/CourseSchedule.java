
import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add((new ArrayList<>()));
        }
        int[] inDegree = new int[numCourses];
        for (int[] preq : prerequisites) {
            int course = preq[0];
            int pre = preq[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }
        return count == numCourses;

    }
}