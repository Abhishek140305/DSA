class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        int[] courseOrder = new int[numCourses];
        int[] inDegree = new int[numCourses];
        int coursesCompleted = 0;
        int idx = 0;


        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());


        for (int[] arr : prerequisites) {
            adjacencyList.get(arr[1]).add(arr[0]);
            inDegree[arr[0]]++;
        }


        Deque<Integer> q = new ArrayDeque<>();


        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                q.addLast(i);


        while (!q.isEmpty()) {
            int course = q.removeFirst();
            courseOrder[idx] = course;
            coursesCompleted++;
            idx++;


            for (int neighbour : adjacencyList.get(course)) {
                inDegree[neighbour]--;


                if (inDegree[neighbour] == 0)
                    q.addLast(neighbour);
            }
        }


        return coursesCompleted == numCourses ? courseOrder : new int[0];
    }
}