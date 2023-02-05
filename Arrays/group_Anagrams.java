class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      String[] sorted = new String[strs.length];
      System.arraycopy(strs, 0, sorted, 0, strs.length);
      Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i< strs.length; i++){
          char[] stringArray = strs[i].toCharArray();
          getSorted(stringArray, 0, stringArray.length);
          sorted[i] = String.valueOf(stringArray);

          if(map.containsKey(sorted[i])){
            map.get(sorted[i]).add(strs[i]);

          }else{
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(sorted[i], list);
          }

        }


        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> item : map.entrySet()){
          result.add(item.getValue());
        }

        return result;
    }


    public void getSorted(char[] strs, int start, int end){
      if((end-start) < 2)return;
      System.out.println("here");

      int mid = (start + end) / 2;

      getSorted(strs, start, mid);
      getSorted(strs, mid, end);
      sort(strs, start, mid, end);
    }

    public void sort(char[] strs, int start, int mid, int end){
      int i = start;
      int j = mid;
      int temp = 0;
      char[] tempArray = new char[strs.length];

      while(i < mid && j < end){

        tempArray[temp++] = strs[i] - 'a' < strs[j] - 'a' ? strs[i++] : strs[j++];
      }

      System.arraycopy(strs, i, strs, start+temp, mid-i);
      System.arraycopy(tempArray, 0, strs, start, temp);
      
    }
}
