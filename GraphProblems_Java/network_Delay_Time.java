class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<String>> graph = new ArrayList<>();
        for(int i=0; i< n+1; i++){
            graph.add(new ArrayList<String>());
        }

        for(int i=0; i< times.length; i++){
            int[] currentList = times[i];
            int iVal = currentList[0];
            int jVal = currentList[1];
            int value = currentList[2];
            graph.get(iVal).add(jVal+":"+value);
        }
       

       Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
       queue.add(new Pair(k, 0));
       int[] arr = new int[n];
       Arrays.fill(arr, Integer.MAX_VALUE);
       arr[k-1] = 0;

       while(queue.size() > 0){
         int currentNode = queue.peek().getKey();
         int currentValue = queue.peek().getValue();
         queue.remove();

        ArrayList<String> adjs = graph.get(currentNode);

        for(String ad : adjs){
          int num = Integer.parseInt(ad.split(":")[0]);
          int time = Integer.parseInt(ad.split(":")[1]);

            if(arr[num-1] > time + currentValue){
              arr[num-1] = time + currentValue;
            queue.add(new Pair(num, currentValue + time));

            }
        }
       }

       int max = -1;
      for(int i=0; i< arr.length; i++){
        if(arr[i] >= Integer.MAX_VALUE)return -1;

        max = Math.max(max, arr[i]);
      }
       System.out.println(Arrays.toString(arr));
       return max;
    }
}
