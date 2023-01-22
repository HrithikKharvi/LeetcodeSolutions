class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<String>> graph = new  ArrayList<>();
        if(n > 100)return 0;

        for(int i=0; i< n; i++){
          graph.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length; i++){
          int[] a = edges[i];
          graph.get(a[0]).add(a[1] + ":" + a[2]);
          graph.get(a[1]).add(a[0] + ":" + a[2]);
        }

        int[] arr = new int[n];
        for(int i=0; i< n; i++){
          int count = findCount(graph, i, distanceThreshold);
          arr[i] = count;
        }

        int minIndex = 0;
        int min = Integer.MAX_VALUE;

      System.out.println(Arrays.toString(arr));
        for(int i=0; i< arr.length; i++){
          if(arr[i] <= min){
            min = arr[i];
            minIndex = i;
          }
        }

        return minIndex;

    }

    public int findCount(ArrayList<ArrayList<String>> graph, int index, int thresh){
      int[] minArr = new int[graph.size()];
      Set<Integer> set = new HashSet<>();

      Arrays.fill(minArr, Integer.MAX_VALUE);

      Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

      queue.add(new Pair(index, 0));
      minArr[index] = 0;

      while(queue.size() > 0){
        int currentCity = queue.peek().getKey();
        int length = queue.peek().getValue();
        queue.remove();

        ArrayList<String> adjs = graph.get(currentCity);

        for(String ad : adjs){
          int nextCity = Integer.parseInt(ad.split(":")[0]);
          int required = Integer.parseInt(ad.split(":")[1]);

          int tempLoc = required + length;

          if(tempLoc <= thresh && tempLoc < minArr[nextCity]){
            set.add(nextCity);
            queue.add(new Pair(nextCity, tempLoc));
            minArr[nextCity] = tempLoc;
          }

        }

      }

        return set.size();

    }

}
