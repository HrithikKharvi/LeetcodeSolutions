class Solution {
    public int findJudge(int n, int[][] trust) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

       for(int i=0; i< n+1; i++){
         graph.add(new ArrayList<>());
       }

        int[] indegree = new int[n+1];
        for(int i=0; i< trust.length; i++){
          int[] currentList = trust[i];
          graph.get(currentList[0]).add(currentList[1]);
          indegree[currentList[1]]++;
        }

        System.out.println(graph);
        for(int i=1; i<graph.size(); i++){
          ArrayList<Integer> currentList = graph.get(i);
          if(currentList.size() == 0 && indegree[i] == n-1) return i;
        }

        return -1;
    }
}
