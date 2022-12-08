class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
          graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i< prerequisites.length; i++){
          int[] currentList = prerequisites[i];
          graph.get(currentList[1]).add(currentList[0]);
        }

        ArrayList<Integer> queue = new ArrayList<>();

        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
          int[] currentList = prerequisites[i];
          indegree[currentList[0]]++;
        }

        for(int i=0; i< indegree.length; i++){
          if(indegree[i] == 0){
            queue.add(i);
          }
        }

      System.out.println(Arrays.toString(indegree));
      ArrayList<Integer> topo = new ArrayList<>();
      while(queue.size() > 0){
        int currentElement = queue.remove(0);
        ArrayList<Integer> currentList = graph.get(currentElement);

        for(int j=0; j< currentList.size(); j++){
          int currentVal = currentList.get(j);
          indegree[currentVal]--;
          if(indegree[currentVal] == 0)queue.add(currentVal);
        }

        topo.add(currentElement);
      }

      if(topo.size() == numCourses) return true;
      return false;

    }
}
