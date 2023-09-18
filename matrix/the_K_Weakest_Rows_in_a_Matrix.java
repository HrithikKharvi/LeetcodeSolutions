class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
      List<Pair<Integer, Integer>> list = new ArrayList<>();

      for(int i=0; i<mat.length; i++){
        int count = 0;

        for(int j=0; j<mat[0].length; j++){
          if(mat[i][j] == 1)count++;
        }

        list.add(new Pair(i, count));
      }

      Collections.sort(list, new Comparator<Pair<Integer, Integer>>(){
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
          return p1.getValue() - p2.getValue();
        }
      });

      int[] sortedList = new int[k];

      for(int i=0; i< k; i++){
        sortedList[i] = list.get(i).getKey();
      }

      return sortedList;
    }
}
