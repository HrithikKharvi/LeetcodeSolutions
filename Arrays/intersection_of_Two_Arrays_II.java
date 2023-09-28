class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] smallArray = nums1.length <= nums2.length ? nums1 : nums2;
        int[] bigArray = nums2.length >= nums1.length ? nums2 : nums1;

        for(int i=0; i< bigArray.length; i++){
          if(map.containsKey(bigArray[i])){
            map.put(bigArray[i], map.get(bigArray[i]) + 1);
          }else{
            map.put(bigArray[i], 1);
          }
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i< smallArray.length; i++){
          if(map.containsKey(smallArray[i])){
            if(map.get(smallArray[i]) > 0){
              result.add(smallArray[i]);
              map.put(smallArray[i], map.get(smallArray[i])-1);
            }
          }
        }

        int[] arr = new int[result.size()];
        for(int i=0; i< arr.length; i++)arr[i] = result.get(i);

        return arr;
    }
}
