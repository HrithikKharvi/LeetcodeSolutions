class Solution {
    public boolean winnerOfGame(String colors) {
        List<Integer> list = charArrayCount(colors);

        int aCount = 0;
        int bCount = 0;

        for(int i=0; i< list.size(); i++){
          if(i % 2 == 0){
            aCount += list.get(i) - 2 > 0 ?  list.get(i) - 2 : 0;
          }else{
            bCount += list.get(i) - 2 > 0 ? list.get(i) - 2 : 0;
          }
        }

        return aCount > bCount;

    }

    public List<Integer> charArrayCount(String s){
      List<Integer> list = new ArrayList<>();
      int index = 0;
      int count = 0;

      char currentChar = 'A';

      for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);

        if(currentChar == ch){
          count++;
        }else{
          list.add(count);
          count = 1;
          currentChar = ch;
        }

        if(i == s.length()-1){
          list.add(count);
        }
      }

      return list;
    }
}
