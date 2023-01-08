class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(new ArrayList<>());
      list.add(new ArrayList<>());

      for(int i=0; i< colsum.length; i++){
        if(colsum[i] == 2){
          if(upper <= 0 || lower <= 0)return new ArrayList<>();
          upper--;
          lower--;
          list.get(0).add(1);
          list.get(1).add(1);
        }else{
          list.get(0).add(0);
          list.get(1).add(0);
        }
      }

      for(int i=0; i< colsum.length; i++){
        if(colsum[i] != 2){
          int required = colsum[i];

          if(required != 0 && upper > 0){
            list.get(0).set(i, 1);
            upper--;
            required--;
          }
          if(required != 0 && lower > 0){
            list.get(1).set(i, 1);
            lower--;
            required--;
          }

          if(required > 0)return new ArrayList<>();
        }
      }

      if(upper > 0 || lower > 0)return new ArrayList<>();
      return list;
    }
}
