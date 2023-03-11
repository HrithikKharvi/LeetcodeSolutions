class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();

        for(int i=0; i< list1.length; i++){
          String word = list1[i];
          map1.put(word, i);
        }

        Map<String, Integer> map2  = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i=0; i< list2.length; i++){
          String word = list2[i];
          if(map1.containsKey(word)){
            int sum = map1.get(word) + i;
            map2.put(word, sum);
            if(sum < min)min = sum;
          }
        }


      ArrayList<String> arr = new ArrayList<>();

      for(String key : map2.keySet()){
        if(map2.get(key) == min)arr.add(key);
      }

      String[] result = new String[arr.size()];

      for(int i=0; i< result.length; i++){
        result[i] = arr.get(i);
      }

      return result;

    }
}
