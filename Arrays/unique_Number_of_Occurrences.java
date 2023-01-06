class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++){
          if(map.containsKey(arr[i])){
            map.put(arr[i], map.get(arr[i]) + 1);
          }else{
            map.put(arr[i], 1);
          }
        } 

          HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
          int key = item.getKey();
          int value = item.getValue();
          if(set.contains(value))return false;
          set.add(value);
        }

        return true;
    }
}

//Space optimized solution

// class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
//         Arrays.sort(arr);
//         Set<Integer> set = new HashSet<>();

//         int prev = 0;
//         int count = 0;
//         for(int a : arr){
//           if(a != prev){
//             if(set.contains(count))return false;
//             else{
//               set.add(count);
//               count = 1;
//               prev = a;
//             }
//           }else{
//             count++;
//           }
//         }

//         if(set.contains(count))return false;

//         return true;
//     }
// }
