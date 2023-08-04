class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i< vals.length; i++)adjList.add(new ArrayList<>());
//O(E * )
        for(int[] ed : edges){
          int start = ed[0];
          int end = ed[1];

          List<Integer> list1 = adjList.get(start);
          List<Integer> list2 = adjList.get(end);

          //O(N-1)
          add(list1, end, vals);
          //O(N-1)
          add(list2, start, vals);
        }

        for(int i=0; i<vals.length; i++)Collections.sort(adjList.get(i), Collections.reverseOrder());


        int max = Integer.MIN_VALUE;
        for(int i=0; i<vals.length; i++){
          List<Integer> list = adjList.get(i);

          int sum = vals[i];
          int count = 0;
          max = Math.max(sum, max);

          for(int item : list){
            if(count == k)break;
            sum += item;
            count++;
            max = Math.max(sum, max);
          }

          max = Math.max(max, sum);
        }

        return max;

    }

    public void add(List<Integer> list, int value, int[] values){
      list.add(values[value]);
    }

}
