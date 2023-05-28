class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> depGraph = new ArrayList<>();
        int[] depArray = new int[numCourses];
        for(int i=0; i<numCourses; i++){
          depGraph.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
          int firstValue = arr[0];
          int secondValue = arr[1];
          depGraph.get(secondValue).add(firstValue);
          depArray[firstValue]++;
        }



        List<Integer> queue = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
          if(depArray[i] == 0)queue.add(i);
        }


        int[] resultArray = new int[numCourses];
        int counter = 0;

        while(queue.size() > 0){
          int value = queue.remove(0);
          if(depArray[value] == 0){
              resultArray[counter++] = value;
          }
          List<Integer> neighbors = depGraph.get(value);

          for(int node : neighbors){
            depArray[node]--;
            if(depArray[node] == 0){
              queue.add(node);
            }
          }
        }

        if(counter != numCourses)return new int[0];

        return resultArray;

    }
}
