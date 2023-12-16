class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(List<String> li : paths){
          String start = li.get(0);
          String end = li.get(1);

          set.add(start);
          set.add(end);

          if(map.containsKey(start)){
            map.put(start, map.get(start) + 1);

          }else{
            map.put(start, 1);
          }
        }

        Iterator<String> iter = set.iterator();

        while(iter.hasNext()){
          String key = iter.next();
         if(!map.containsKey(key))return key;
        }

        return "";
    }
}
